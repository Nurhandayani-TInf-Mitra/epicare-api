package epicare_api.controller;

import epicare_api.entity.User;
import epicare_api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) { this.userService = userService; }

    // Respons API sengaja tidak menyertakan password.
    public record UserResponse(Long idUser, String username, String email, String noHp,
                               String statusAkun, LocalDateTime createdAt,
                               LocalDateTime updatedAt) {
        static UserResponse from(User u) {
            return new UserResponse(u.getIdUser(), u.getUsername(), u.getEmail(), u.getNoHp(),
                    u.getStatusAkun(), u.getCreatedAt(), u.getUpdatedAt());
        }
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll().stream().map(UserResponse::from).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        return userService.getById(id).map(UserResponse::from)
                .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.from(userService.create(user)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @RequestBody User user) {
        Optional<User> updated = userService.update(id, user);
        return updated.map(UserResponse::from).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return userService.delete(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
