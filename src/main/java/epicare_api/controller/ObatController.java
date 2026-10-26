package epicare_api.controller;

import epicare_api.entity.Obat;
import epicare_api.service.ObatService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/obat")
public class ObatController {

    private final ObatService obatService;

    public ObatController(ObatService obatService) {
        this.obatService = obatService;
    }

    // GET: Mengambil seluruh data obat
    @GetMapping
    public ResponseEntity<List<Obat>> getAllObat() {
        return ResponseEntity.ok(obatService.getAllObat());
    }

    // GET: Mengambil obat berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<Obat> getObatById(@PathVariable Long id) {
        return obatService.getObatById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Menambahkan obat
    @PostMapping
    public ResponseEntity<Obat> createObat(@RequestBody Obat obat) {
        Obat obatBaru = obatService.createObat(obat);
        return ResponseEntity.status(HttpStatus.CREATED).body(obatBaru);
    }

    // PUT: Mengubah obat
    @PutMapping("/{id}")
    public ResponseEntity<Obat> updateObat(
            @PathVariable Long id,
            @RequestBody Obat obat) {

        return obatService.updateObat(id, obat)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Menghapus obat
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteObat(@PathVariable Long id) {
        if (!obatService.deleteObat(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
