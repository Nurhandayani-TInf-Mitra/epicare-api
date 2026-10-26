package epicare_api.controller;

import epicare_api.entity.FasilitasKesehatan;
import epicare_api.service.FasilitasKesehatanService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faskes")
public class FasilitasKesehatanController {

    private final FasilitasKesehatanService faskesService;

    public FasilitasKesehatanController(
            FasilitasKesehatanService faskesService) {
        this.faskesService = faskesService;
    }

    // GET: Mengambil seluruh fasilitas kesehatan
    @GetMapping
    public ResponseEntity<List<FasilitasKesehatan>> getAllFaskes() {
        return ResponseEntity.ok(faskesService.getAllFaskes());
    }

    // GET: Mengambil fasilitas berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<FasilitasKesehatan> getFaskesById(
            @PathVariable Long id) {

        return faskesService.getFaskesById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Menambahkan fasilitas kesehatan
    @PostMapping
    public ResponseEntity<FasilitasKesehatan> createFaskes(
            @RequestBody FasilitasKesehatan faskes) {

        FasilitasKesehatan faskesBaru =
                faskesService.createFaskes(faskes);

        return ResponseEntity.status(HttpStatus.CREATED).body(faskesBaru);
    }

    // PUT: Mengubah fasilitas kesehatan
    @PutMapping("/{id}")
    public ResponseEntity<FasilitasKesehatan> updateFaskes(
            @PathVariable Long id,
            @RequestBody FasilitasKesehatan faskes) {

        return faskesService.updateFaskes(id, faskes)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Menghapus fasilitas kesehatan
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaskes(@PathVariable Long id) {
        if (!faskesService.deleteFaskes(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
