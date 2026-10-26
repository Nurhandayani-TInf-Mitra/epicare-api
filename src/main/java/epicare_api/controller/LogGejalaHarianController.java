package epicare_api.controller;

import epicare_api.entity.LogGejalaHarian;
import epicare_api.service.LogGejalaHarianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/log-gejala-harian")
public class LogGejalaHarianController {
    private final LogGejalaHarianService service;

    public LogGejalaHarianController(LogGejalaHarianService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LogGejalaHarian>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogGejalaHarian> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LogGejalaHarian> create(@RequestBody LogGejalaHarian data) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LogGejalaHarian> update(
            @PathVariable Long id, @RequestBody LogGejalaHarian data) {
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
