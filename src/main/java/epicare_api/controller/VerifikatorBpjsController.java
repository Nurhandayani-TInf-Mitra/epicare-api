package epicare_api.controller;

import epicare_api.entity.VerifikatorBpjs;
import epicare_api.service.VerifikatorBpjsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/verifikator-bpjs")
public class VerifikatorBpjsController {
    private final VerifikatorBpjsService service;

    public VerifikatorBpjsController(VerifikatorBpjsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<VerifikatorBpjs>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VerifikatorBpjs> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VerifikatorBpjs> create(@RequestBody VerifikatorBpjs data) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VerifikatorBpjs> update(
            @PathVariable Long id, @RequestBody VerifikatorBpjs data) {
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
