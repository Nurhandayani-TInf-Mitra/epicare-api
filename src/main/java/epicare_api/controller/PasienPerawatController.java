package epicare_api.controller;

import epicare_api.entity.PasienPerawat;
import epicare_api.service.PasienPerawatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pasien-perawat")
public class PasienPerawatController {
    private final PasienPerawatService service;

    public PasienPerawatController(PasienPerawatService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PasienPerawat>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PasienPerawat> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PasienPerawat> create(@RequestBody PasienPerawat data) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PasienPerawat> update(
            @PathVariable Long id, @RequestBody PasienPerawat data) {
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
