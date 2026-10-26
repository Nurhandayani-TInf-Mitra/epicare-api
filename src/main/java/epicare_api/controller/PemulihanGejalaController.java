package epicare_api.controller;

import epicare_api.entity.PemulihanGejala;
import epicare_api.service.PemulihanGejalaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pemulihan-gejala")
public class PemulihanGejalaController {

    private final PemulihanGejalaService pemulihanGejalaService;

    public PemulihanGejalaController(
            PemulihanGejalaService pemulihanGejalaService) {
        this.pemulihanGejalaService = pemulihanGejalaService;
    }

    // GET: Mengambil seluruh data
    @GetMapping
    public ResponseEntity<List<PemulihanGejala>> getAll() {
        return ResponseEntity.ok(
                pemulihanGejalaService.getAllPemulihanGejala());
    }

    // GET: Mengambil data berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<PemulihanGejala> getById(
            @PathVariable Long id) {
        return pemulihanGejalaService.getPemulihanGejalaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET: Mengambil data berdasarkan ID pemulihan
    @GetMapping("/pemulihan/{idPemulihan}")
    public ResponseEntity<List<PemulihanGejala>> getByIdPemulihan(
            @PathVariable Long idPemulihan) {
        return ResponseEntity.ok(
                pemulihanGejalaService.getByIdPemulihan(idPemulihan));
    }

    // POST: Menambahkan data
    @PostMapping
    public ResponseEntity<PemulihanGejala> create(
            @RequestBody PemulihanGejala data) {
        PemulihanGejala hasil =
                pemulihanGejalaService.createPemulihanGejala(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(hasil);
    }

    // PUT: Mengubah data
    @PutMapping("/{id}")
    public ResponseEntity<PemulihanGejala> update(
            @PathVariable Long id,
            @RequestBody PemulihanGejala data) {
        return pemulihanGejalaService.updatePemulihanGejala(id, data)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Menghapus data
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!pemulihanGejalaService.deletePemulihanGejala(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
