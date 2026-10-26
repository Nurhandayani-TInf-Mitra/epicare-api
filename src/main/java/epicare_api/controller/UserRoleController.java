package epicare_api.controller;

import epicare_api.entity.UserRole;
import epicare_api.service.UserRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-roles")
public class UserRoleController {
    private final UserRoleService userRoleService;
    public UserRoleController(UserRoleService userRoleService) { this.userRoleService = userRoleService; }

    @GetMapping
    public List<UserRole> getAll() { return userRoleService.getAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<UserRole> getById(@PathVariable Long id) {
        return userRoleService.getById(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{idUser}")
    public List<UserRole> getByUserId(@PathVariable Long idUser) {
        return userRoleService.getByUserId(idUser);
    }

    @GetMapping("/role/{idRole}")
    public List<UserRole> getByRoleId(@PathVariable Integer idRole) {
        return userRoleService.getByRoleId(idRole);
    }

    @PostMapping
    public ResponseEntity<UserRole> create(@RequestBody UserRole input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userRoleService.create(input));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserRole> update(@PathVariable Long id, @RequestBody UserRole input) {
        Optional<UserRole> updated = userRoleService.update(id, input);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return userRoleService.delete(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
