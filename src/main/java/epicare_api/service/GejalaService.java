package epicare_api.service;

import epicare_api.entity.Gejala;
import epicare_api.repository.GejalaRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GejalaService {

    private final GejalaRepository gejalaRepository;

    public GejalaService(GejalaRepository gejalaRepository) {
        this.gejalaRepository = gejalaRepository;
    }

    // Mengambil seluruh data gejala
    public List<Gejala> getAllGejala() {
        return gejalaRepository.findAll();
    }

    // Mengambil gejala berdasarkan ID
    public Optional<Gejala> getGejalaById(Integer idGejala) {
        return gejalaRepository.findById(idGejala);
    }

    // Menambahkan gejala
    public Gejala createGejala(Gejala gejala) {
        gejala.setIdGejala(null);
        return gejalaRepository.save(gejala);
    }

    // Mengubah gejala
    public Optional<Gejala> updateGejala(
            Integer idGejala, Gejala gejalaBaru) {

        return gejalaRepository.findById(idGejala)
                .map(gejalaLama -> {
                    gejalaLama.setNamaGejala(gejalaBaru.getNamaGejala());

                    return gejalaRepository.save(gejalaLama);
                });
    }

    // Menghapus gejala
    public boolean deleteGejala(Integer idGejala) {
        if (!gejalaRepository.existsById(idGejala)) {
            return false;
        }

        gejalaRepository.deleteById(idGejala);
        return true;
    }
}
