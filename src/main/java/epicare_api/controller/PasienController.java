package epicare_api.controller;

import epicare_api.entity.Pasien;
import epicare_api.service.PasienService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pasien")
public class PasienController {
    private final PasienService service;

    public PasienController(PasienService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Pasien>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pasien> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pasien> create(@RequestBody Pasien data) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pasien> update(
            @PathVariable Long id, @RequestBody Pasien data) {
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
