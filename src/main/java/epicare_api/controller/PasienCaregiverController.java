package epicare_api.controller;

import epicare_api.entity.PasienCaregiver;
import epicare_api.service.PasienCaregiverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pasien-caregiver")
public class PasienCaregiverController {
    private final PasienCaregiverService service;

    public PasienCaregiverController(PasienCaregiverService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PasienCaregiver>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PasienCaregiver> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PasienCaregiver> create(@RequestBody PasienCaregiver data) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PasienCaregiver> update(
            @PathVariable Long id, @RequestBody PasienCaregiver data) {
        return service.update(id, data)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
