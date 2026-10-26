package epicare_api.service;

import epicare_api.entity.KontakDarurat;
import epicare_api.repository.KontakDaruratRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KontakDaruratService {

    private final KontakDaruratRepository kontakDaruratRepository;

    public KontakDaruratService(
            KontakDaruratRepository kontakDaruratRepository) {
        this.kontakDaruratRepository = kontakDaruratRepository;
    }

    // Mengambil seluruh data kontak darurat
    public List<KontakDarurat> getAllKontakDarurat() {
        return kontakDaruratRepository.findAll();
    }

    // Mengambil kontak darurat berdasarkan ID
    public Optional<KontakDarurat> getKontakDaruratById(
            Long idKontakDarurat) {
        return kontakDaruratRepository.findById(idKontakDarurat);
    }

    // Mengambil kontak darurat berdasarkan ID pasien
    public List<KontakDarurat> getKontakDaruratByIdPasien(
            Long idPasien) {
        return kontakDaruratRepository.findByIdPasien(idPasien);
    }

    // Menambahkan kontak darurat
    public KontakDarurat createKontakDarurat(
            KontakDarurat kontakDarurat) {
        kontakDarurat.setIdKontakDarurat(null);
        return kontakDaruratRepository.save(kontakDarurat);
    }

    // Mengubah kontak darurat
    public Optional<KontakDarurat> updateKontakDarurat(
            Long idKontakDarurat,
            KontakDarurat kontakBaru) {

        return kontakDaruratRepository.findById(idKontakDarurat)
                .map(kontakLama -> {
                    kontakLama.setIdPasien(kontakBaru.getIdPasien());
                    kontakLama.setNamaKontak(kontakBaru.getNamaKontak());
                    kontakLama.setNoHp(kontakBaru.getNoHp());
                    kontakLama.setHubungan(kontakBaru.getHubungan());
                    kontakLama.setPrioritas(kontakBaru.getPrioritas());

                    return kontakDaruratRepository.save(kontakLama);
                });
    }

    // Menghapus kontak darurat
    public boolean deleteKontakDarurat(Long idKontakDarurat) {
        if (!kontakDaruratRepository.existsById(idKontakDarurat)) {
            return false;
        }

        kontakDaruratRepository.deleteById(idKontakDarurat);
        return true;
    }
}
