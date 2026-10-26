package epicare_api.controller;

import epicare_api.entity.LogPemantauanHarian;
import epicare_api.service.LogPemantauanHarianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/log-pemantauan-harian")
public class LogPemantauanHarianController {
    private final LogPemantauanHarianService service;

    public LogPemantauanHarianController(LogPemantauanHarianService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LogPemantauanHarian>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogPemantauanHarian> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LogPemantauanHarian> create(@RequestBody LogPemantauanHarian data) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LogPemantauanHarian> update(
            @PathVariable Long id, @RequestBody LogPemantauanHarian data) {
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
