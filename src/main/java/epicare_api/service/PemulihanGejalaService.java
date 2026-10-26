package epicare_api.service;

import epicare_api.entity.PemulihanGejala;
import epicare_api.repository.PemulihanGejalaRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PemulihanGejalaService {

    private final PemulihanGejalaRepository pemulihanGejalaRepository;

    public PemulihanGejalaService(
            PemulihanGejalaRepository pemulihanGejalaRepository) {
        this.pemulihanGejalaRepository = pemulihanGejalaRepository;
    }

    // Mengambil seluruh data pemulihan gejala
    public List<PemulihanGejala> getAllPemulihanGejala() {
        return pemulihanGejalaRepository.findAll();
    }

    // Mengambil data berdasarkan ID
    public Optional<PemulihanGejala> getPemulihanGejalaById(
            Long idPemulihanGejala) {
        return pemulihanGejalaRepository.findById(idPemulihanGejala);
    }

    // Mengambil data berdasarkan ID pemulihan
    public List<PemulihanGejala> getByIdPemulihan(Long idPemulihan) {
        return pemulihanGejalaRepository.findByIdPemulihan(idPemulihan);
    }

    // Menambahkan data pemulihan gejala
    public PemulihanGejala createPemulihanGejala(
            PemulihanGejala pemulihanGejala) {
        pemulihanGejala.setIdPemulihanGejala(null);
        return pemulihanGejalaRepository.save(pemulihanGejala);
    }

    // Mengubah data pemulihan gejala
    public Optional<PemulihanGejala> updatePemulihanGejala(
            Long idPemulihanGejala,
            PemulihanGejala dataBaru) {

        return pemulihanGejalaRepository.findById(idPemulihanGejala)
                .map(dataLama -> {
                    dataLama.setIdPemulihan(dataBaru.getIdPemulihan());
                    dataLama.setIdGejala(dataBaru.getIdGejala());
                    dataLama.setTingkatAwal(dataBaru.getTingkatAwal());
                    dataLama.setStatusGejala(dataBaru.getStatusGejala());
                    dataLama.setWaktuHilang(dataBaru.getWaktuHilang());

                    return pemulihanGejalaRepository.save(dataLama);
                });
    }

    // Menghapus data pemulihan gejala
    public boolean deletePemulihanGejala(Long idPemulihanGejala) {
        if (!pemulihanGejalaRepository.existsById(idPemulihanGejala)) {
            return false;
        }

        pemulihanGejalaRepository.deleteById(idPemulihanGejala);
        return true;
    }
}
