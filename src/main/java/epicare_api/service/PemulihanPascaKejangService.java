package epicare_api.service;

import epicare_api.entity.PemulihanPascaKejang;
import epicare_api.repository.PemulihanPascaKejangRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PemulihanPascaKejangService {

    private final PemulihanPascaKejangRepository repository;

    public PemulihanPascaKejangService(
            PemulihanPascaKejangRepository repository) {
        this.repository = repository;
    }

    // Mengambil seluruh data pemulihan pasca kejang
    public List<PemulihanPascaKejang> getAll() {
        return repository.findAll();
    }

    // Mengambil data berdasarkan ID pemulihan
    public Optional<PemulihanPascaKejang> getById(Long id) {
        return repository.findById(id);
    }

    // Mengambil data berdasarkan ID kejang
    public Optional<PemulihanPascaKejang> getByIdKejang(Long idKejang) {
        return repository.findAll()
                .stream()
                .filter(data -> data.getIdKejang().equals(idKejang))
                .findFirst();
    }

    // Menambahkan data pemulihan pasca kejang
    public PemulihanPascaKejang create(
            PemulihanPascaKejang data) {
        data.setIdPemulihan(null);
        return repository.save(data);
    }

    // Memperbarui data pemulihan pasca kejang
    public Optional<PemulihanPascaKejang> update(
            Long id, PemulihanPascaKejang dataBaru) {

        return repository.findById(id).map(dataLama -> {
            dataLama.setIdKejang(dataBaru.getIdKejang());
            dataLama.setKondisiCedera(dataBaru.getKondisiCedera());
            dataLama.setKecepatanPemulihan(
                    dataBaru.getKecepatanPemulihan());
            dataLama.setTingkatRisiko(dataBaru.getTingkatRisiko());
            dataLama.setRekomendasi(dataBaru.getRekomendasi());
            dataLama.setStatusPemulihan(dataBaru.getStatusPemulihan());
            dataLama.setCatatanSistem(dataBaru.getCatatanSistem());
            dataLama.setWaktuPulihTotal(dataBaru.getWaktuPulihTotal());

            return repository.save(dataLama);
        });
    }

    // Menghapus data pemulihan pasca kejang
    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}
