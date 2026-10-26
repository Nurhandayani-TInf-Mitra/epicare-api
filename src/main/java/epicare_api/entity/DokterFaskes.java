package epicare_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "dokter_faskes")
public class DokterFaskes {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_dokter_faskes")
    private Long idDokterFaskes;

    @Column(name = "id_dokter", nullable = false)
    private Long idDokter;

    @Column(name = "id_faskes", nullable = false)
    private Long idFaskes;

    @Column(name = "tanggal_mulai")
    private LocalDate tanggalMulai;

    @Column(name = "tanggal_selesai")
    private LocalDate tanggalSelesai;

    public DokterFaskes() {
    }

    public Long getIdDokterFaskes() {
        return idDokterFaskes;
    }

    public void setIdDokterFaskes(Long idDokterFaskes) {
        this.idDokterFaskes = idDokterFaskes;
    }

    public Long getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(Long idDokter) {
        this.idDokter = idDokter;
    }

    public Long getIdFaskes() {
        return idFaskes;
    }

    public void setIdFaskes(Long idFaskes) {
        this.idFaskes = idFaskes;
    }

    public LocalDate getTanggalMulai() {
        return tanggalMulai;
    }

    public void setTanggalMulai(LocalDate tanggalMulai) {
        this.tanggalMulai = tanggalMulai;
    }

    public LocalDate getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(LocalDate tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

}
