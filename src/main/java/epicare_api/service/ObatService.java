package epicare_api.service;

import epicare_api.entity.Obat;
import epicare_api.repository.ObatRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObatService {

    private final ObatRepository obatRepository;

    public ObatService(ObatRepository obatRepository) {
        this.obatRepository = obatRepository;
    }

    // Mengambil seluruh data obat
    public List<Obat> getAllObat() {
        return obatRepository.findAll();
    }

    // Mengambil data obat berdasarkan ID
    public Optional<Obat> getObatById(Long idObat) {
        return obatRepository.findById(idObat);
    }

    // Menambahkan data obat
    public Obat createObat(Obat obat) {
        obat.setIdObat(null);
        return obatRepository.save(obat);
    }

    // Mengubah data obat
    public Optional<Obat> updateObat(Long idObat, Obat obatBaru) {
        return obatRepository.findById(idObat)
                .map(obatLama -> {
                    obatLama.setNamaObat(obatBaru.getNamaObat());
                    obatLama.setBentukSediaan(obatBaru.getBentukSediaan());

                    return obatRepository.save(obatLama);
                });
    }

    // Menghapus data obat
    public boolean deleteObat(Long idObat) {
        if (!obatRepository.existsById(idObat)) {
            return false;
        }

        obatRepository.deleteById(idObat);
        return true;
    }
}
