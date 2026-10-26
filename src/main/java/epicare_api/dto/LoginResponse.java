package epicare_api.dto;

import java.util.List;

public class LoginResponse {

    private String message;
    private String token;
    private String tokenType;
    private long expiresIn;
    private Long idUser;
    private String username;
    private String statusAkun;
    private List<String> roles;

    public LoginResponse() {
    }

    public LoginResponse(
            String message,
            String token,
            long expiresIn,
            Long idUser,
            String username,
            String statusAkun,
            List<String> roles) {

        this.message = message;
        this.token = token;
        this.tokenType = "Bearer";
        this.expiresIn = expiresIn;
        this.idUser = idUser;
        this.username = username;
        this.statusAkun = statusAkun;
        this.roles = roles;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public Long getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public String getStatusAkun() {
        return statusAkun;
    }

    public List<String> getRoles() {
        return roles;
    }
}