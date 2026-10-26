package epicare_api.controller;

import epicare_api.entity.KontakDarurat;
import epicare_api.service.KontakDaruratService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kontak-darurat")
public class KontakDaruratController {

    private final KontakDaruratService kontakDaruratService;

    public KontakDaruratController(
            KontakDaruratService kontakDaruratService) {
        this.kontakDaruratService = kontakDaruratService;
    }

    // GET: Mengambil seluruh kontak darurat
    @GetMapping
    public ResponseEntity<List<KontakDarurat>> getAllKontakDarurat() {
        return ResponseEntity.ok(
                kontakDaruratService.getAllKontakDarurat());
    }

    // GET: Mengambil kontak berdasarkan ID
    @GetMapping("/{id}")
    public ResponseEntity<KontakDarurat> getKontakDaruratById(
            @PathVariable Long id) {

        return kontakDaruratService.getKontakDaruratById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET: Mengambil kontak berdasarkan ID pasien
    @GetMapping("/pasien/{idPasien}")
    public ResponseEntity<List<KontakDarurat>>
            getKontakDaruratByIdPasien(
                    @PathVariable Long idPasien) {

        return ResponseEntity.ok(
                kontakDaruratService
                        .getKontakDaruratByIdPasien(idPasien));
    }

    // POST: Menambahkan kontak darurat
    @PostMapping
    public ResponseEntity<KontakDarurat> createKontakDarurat(
            @RequestBody KontakDarurat kontakDarurat) {

        KontakDarurat kontakBaru =
                kontakDaruratService.createKontakDarurat(kontakDarurat);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(kontakBaru);
    }

    // PUT: Mengubah kontak darurat
    @PutMapping("/{id}")
    public ResponseEntity<KontakDarurat> updateKontakDarurat(
            @PathVariable Long id,
            @RequestBody KontakDarurat kontakDarurat) {

        return kontakDaruratService
                .updateKontakDarurat(id, kontakDarurat)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Menghapus kontak darurat
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKontakDarurat(
            @PathVariable Long id) {

        if (!kontakDaruratService.deleteKontakDarurat(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
