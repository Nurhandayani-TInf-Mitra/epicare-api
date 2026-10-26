package epicare_api.service;

import epicare_api.entity.Kejang;
import epicare_api.repository.KejangRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KejangService {

    private final KejangRepository kejangRepository;

    public KejangService(KejangRepository kejangRepository) {
        this.kejangRepository = kejangRepository;
    }

    // Mengambil seluruh data kejang
    public List<Kejang> getAllKejang() {
        return kejangRepository.findAll();
    }

    // Mengambil data kejang berdasarkan ID
    public Optional<Kejang> getKejangById(Long idKejang) {
        return kejangRepository.findById(idKejang);
    }

    // Mengambil riwayat kejang berdasarkan ID pasien
    public List<Kejang> getKejangByIdPasien(Long idPasien) {
        return kejangRepository.findByIdPasien(idPasien);
    }

    // Menambahkan data kejang
    public Kejang createKejang(Kejang kejang) {
        // ID dibuat otomatis oleh database
        kejang.setIdKejang(null);
        return kejangRepository.save(kejang);
    }

    // Memperbarui data kejang
    public Optional<Kejang> updateKejang(
            Long idKejang, Kejang dataBaru) {

        return kejangRepository.findById(idKejang)
                .map(dataLama -> {
                    dataLama.setIdPasien(dataBaru.getIdPasien());
                    dataLama.setTanggalWaktu(dataBaru.getTanggalWaktu());
                    dataLama.setDurasi(dataBaru.getDurasi());
                    dataLama.setKondisiSebelum(dataBaru.getKondisiSebelum());
                    dataLama.setKehilanganKesadaran(
                            dataBaru.getKehilanganKesadaran());
                    dataLama.setJatuh(dataBaru.getJatuh());
                    dataLama.setCedera(dataBaru.getCedera());
                    dataLama.setKejangSesaat(dataBaru.getKejangSesaat());
                    dataLama.setKejangBerulang(dataBaru.getKejangBerulang());
                    dataLama.setKondisiLainnya(dataBaru.getKondisiLainnya());
                    dataLama.setTingkatKeparahan(
                            dataBaru.getTingkatKeparahan());
                    dataLama.setCatatanSistem(dataBaru.getCatatanSistem());

                    return kejangRepository.save(dataLama);
                });
    }

    // Menghapus data kejang
    public boolean deleteKejang(Long idKejang) {
        if (!kejangRepository.existsById(idKejang)) {
            return false;
        }

        kejangRepository.deleteById(idKejang);
        return true;
    }
}
