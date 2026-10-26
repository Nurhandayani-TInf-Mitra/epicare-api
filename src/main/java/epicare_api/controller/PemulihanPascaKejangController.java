package epicare_api.controller;

import epicare_api.entity.PemulihanPascaKejang;
import epicare_api.service.PemulihanPascaKejangService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pemulihan-pasca-kejang")
public class PemulihanPascaKejangController {

    private final PemulihanPascaKejangService service;

    public PemulihanPascaKejangController(
            PemulihanPascaKejangService service) {
        this.service = service;
    }

    // GET: seluruh data
    @GetMapping
    public ResponseEntity<List<PemulihanPascaKejang>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // GET: berdasarkan ID pemulihan
    @GetMapping("/{id}")
    public ResponseEntity<PemulihanPascaKejang> getById(
            @PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // GET: berdasarkan ID kejang
    @GetMapping("/kejang/{idKejang}")
    public ResponseEntity<PemulihanPascaKejang> getByIdKejang(
            @PathVariable Long idKejang) {
        return service.getByIdKejang(idKejang)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: menambahkan data
    @PostMapping
    public ResponseEntity<PemulihanPascaKejang> create(
            @RequestBody PemulihanPascaKejang data) {

        PemulihanPascaKejang hasil = service.create(data);

        return ResponseEntity.status(HttpStatus.CREATED).body(hasil);
    }

    // PUT: memperbarui data
    @PutMapping("/{id}")
    public ResponseEntity<PemulihanPascaKejang> update(
            @PathVariable Long id,
            @RequestBody PemulihanPascaKejang data) {

        return service.update(id, data)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: menghapus data
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.delete(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
