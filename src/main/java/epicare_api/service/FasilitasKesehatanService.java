package epicare_api.service;

import epicare_api.entity.FasilitasKesehatan;
import epicare_api.repository.FasilitasKesehatanRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FasilitasKesehatanService {

    private final FasilitasKesehatanRepository faskesRepository;

    public FasilitasKesehatanService(
            FasilitasKesehatanRepository faskesRepository) {
        this.faskesRepository = faskesRepository;
    }

    // Mengambil seluruh data fasilitas kesehatan
    public List<FasilitasKesehatan> getAllFaskes() {
        return faskesRepository.findAll();
    }

    // Mengambil fasilitas kesehatan berdasarkan ID
    public Optional<FasilitasKesehatan> getFaskesById(Long idFaskes) {
        return faskesRepository.findById(idFaskes);
    }

    // Menambahkan fasilitas kesehatan
    public FasilitasKesehatan createFaskes(FasilitasKesehatan faskes) {
        faskes.setIdFaskes(null);
        return faskesRepository.save(faskes);
    }

    // Mengubah fasilitas kesehatan
    public Optional<FasilitasKesehatan> updateFaskes(
            Long idFaskes,
            FasilitasKesehatan faskesBaru) {

        return faskesRepository.findById(idFaskes)
                .map(faskesLama -> {
                    faskesLama.setNamaFaskes(faskesBaru.getNamaFaskes());
                    faskesLama.setJenisFaskes(faskesBaru.getJenisFaskes());
                    faskesLama.setAlamat(faskesBaru.getAlamat());
                    faskesLama.setNoTelepon(faskesBaru.getNoTelepon());

                    return faskesRepository.save(faskesLama);
                });
    }

    // Menghapus fasilitas kesehatan
    public boolean deleteFaskes(Long idFaskes) {
        if (!faskesRepository.existsById(idFaskes)) {
            return false;
        }

        faskesRepository.deleteById(idFaskes);
        return true;
    }
}
