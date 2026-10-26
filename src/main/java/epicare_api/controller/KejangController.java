package epicare_api.controller;

import epicare_api.entity.Kejang;
import epicare_api.service.KejangService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kejang")
public class KejangController {

    private final KejangService kejangService;

    public KejangController(KejangService kejangService) {
        this.kejangService = kejangService;
    }

    // GET seluruh data kejang
    @GetMapping
    public ResponseEntity<List<Kejang>> getAllKejang() {
        return ResponseEntity.ok(kejangService.getAllKejang());
    }

    // GET data berdasarkan ID kejang
    @GetMapping("/{id}")
    public ResponseEntity<Kejang> getKejangById(
            @PathVariable Long id) {

        return kejangService.getKejangById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET riwayat kejang berdasarkan ID pasien
    @GetMapping("/pasien/{idPasien}")
    public ResponseEntity<List<Kejang>> getKejangByIdPasien(
            @PathVariable Long idPasien) {

        return ResponseEntity.ok(
                kejangService.getKejangByIdPasien(idPasien));
    }

    // POST menambahkan data kejang
    @PostMapping
    public ResponseEntity<Kejang> createKejang(
            @RequestBody Kejang kejang) {

        Kejang hasil = kejangService.createKejang(kejang);

        return ResponseEntity.status(HttpStatus.CREATED).body(hasil);
    }

    // PUT memperbarui data kejang
    @PutMapping("/{id}")
    public ResponseEntity<Kejang> updateKejang(
            @PathVariable Long id,
            @RequestBody Kejang dataBaru) {

        return kejangService.updateKejang(id, dataBaru)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE menghapus data kejang
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKejang(
            @PathVariable Long id) {

        if (!kejangService.deleteKejang(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
