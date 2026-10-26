package epicare_api.controller;

import epicare_api.entity.Perawat;
import epicare_api.service.PerawatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/perawat")
public class PerawatController {
    private final PerawatService service;

    public PerawatController(PerawatService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Perawat>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Perawat> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Perawat> create(@RequestBody Perawat data) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Perawat> update(
            @PathVariable Long id, @RequestBody Perawat data) {
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
