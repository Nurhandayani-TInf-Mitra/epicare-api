package epicare_api.security;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    public JwtAuthenticationFilter(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authorizationHeader =
                request.getHeader("Authorization");

        if (authorizationHeader == null
                || !authorizationHeader.startsWith("Bearer ")) {

            filterChain.doFilter(request, response);
            return;
        }

        String token = authorizationHeader.substring(7);

        try {
            Claims claims = jwtService.extractClaims(token);
            String username = claims.getSubject();

            if (username != null
                    && SecurityContextHolder.getContext()
                            .getAuthentication() == null) {

                Object rolesClaim = claims.get("roles");

                if (!(rolesClaim instanceof List<?> rolesList)) {
                    response.sendError(
                            HttpServletResponse.SC_UNAUTHORIZED,
                            "Token tidak valid");
                    return;
                }

                List<SimpleGrantedAuthority> authorities =
                        rolesList.stream()
                                .filter(String.class::isInstance)
                                .map(String.class::cast)
                                .map(role -> new SimpleGrantedAuthority(
                                        "ROLE_" + role))
                                .toList();

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                username,
                                null,
                                authorities);

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }

        } catch (io.jsonwebtoken.JwtException
                | IllegalArgumentException e) {

            SecurityContextHolder.clearContext();

            response.sendError(
                    HttpServletResponse.SC_UNAUTHORIZED,
                    "Token tidak valid atau kedaluwarsa");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
