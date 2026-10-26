package epicare_api.controller;

import epicare_api.entity.PasienDokter;
import epicare_api.service.PasienDokterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pasien-dokter")
public class PasienDokterController {
    private final PasienDokterService service;

    public PasienDokterController(PasienDokterService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PasienDokter>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PasienDokter> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PasienDokter> create(@RequestBody PasienDokter data) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PasienDokter> update(
            @PathVariable Long id, @RequestBody PasienDokter data) {
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
