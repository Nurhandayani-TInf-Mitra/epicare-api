package epicare_api.controller;

import epicare_api.entity.DokterFaskes;
import epicare_api.service.DokterFaskesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/dokter-faskes")
public class DokterFaskesController {
    private final DokterFaskesService service;

    public DokterFaskesController(DokterFaskesService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DokterFaskes>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DokterFaskes> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DokterFaskes> create(@RequestBody DokterFaskes data) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DokterFaskes> update(
            @PathVariable Long id, @RequestBody DokterFaskes data) {
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
