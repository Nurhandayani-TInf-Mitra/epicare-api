package epicare_api.controller;

import epicare_api.entity.Gejala;
import epicare_api.service.GejalaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gejala")
public class GejalaController {

    private final GejalaService gejalaService;

    public GejalaController(GejalaService gejalaService) {
        this.gejalaService = gejalaService;
    }

    // GET: Mengambil seluruh data gejala
    @GetMapping
    public ResponseEntity<List<Gejala>> getAllGejala() {
        return ResponseEntity.ok(gejalaService.getAllGejala());
    }

    // GET: Mengambil gejala berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<Gejala> getGejalaById(
            @PathVariable Integer id) {

        return gejalaService.getGejalaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Menambahkan gejala
    @PostMapping
    public ResponseEntity<Gejala> createGejala(
            @RequestBody Gejala gejala) {

        Gejala gejalaBaru = gejalaService.createGejala(gejala);

        return ResponseEntity.status(HttpStatus.CREATED).body(gejalaBaru);
    }

    // PUT: Mengubah gejala
    @PutMapping("/{id}")
    public ResponseEntity<Gejala> updateGejala(
            @PathVariable Integer id,
            @RequestBody Gejala gejala) {

        return gejalaService.updateGejala(id, gejala)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Menghapus gejala
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGejala(
            @PathVariable Integer id) {

        if (!gejalaService.deleteGejala(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
