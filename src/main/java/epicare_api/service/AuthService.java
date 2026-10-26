package epicare_api.service;

import java.util.List;

import epicare_api.dto.LoginRequest;
import epicare_api.dto.LoginResponse;
import epicare_api.entity.Role;
import epicare_api.entity.User;
import epicare_api.entity.UserRole;
import epicare_api.repository.RoleRepository;
import epicare_api.repository.UserRepository;
import epicare_api.repository.UserRoleRepository;
import epicare_api.security.JwtService;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            UserRoleRepository userRoleRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED,
                        "Username atau password salah"));

        if (user.getPassword() == null
                || !passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword())) {

            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Username atau password salah");
        }

        if (!"Aktif".equalsIgnoreCase(user.getStatusAkun())) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Akun tidak aktif");
        }

        List<String> roles = userRoleRepository
                .findByIdUser(user.getIdUser())
                .stream()
                .map(UserRole::getIdRole)
                .map(roleRepository::findById)
                .flatMap(java.util.Optional::stream)
                .map(Role::getNamaRole)
                .distinct()
                .toList();

        if (roles.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Pengguna belum memiliki role");
        }

        String token = jwtService.generateToken(
                user.getIdUser(),
                user.getUsername(),
                roles);

        return new LoginResponse(
                "Login berhasil",
                token,
                jwtService.getExpirationMs() / 1000,
                user.getIdUser(),
                user.getUsername(),
                user.getStatusAkun(),
                roles);
    }
}
