package epicare_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "pasien_perawat")
public class PasienPerawat {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_pasien_perawat")
    private Long idPasienPerawat;

    @Column(name = "id_pasien", nullable = false)
    private Long idPasien;

    @Column(name = "id_perawat", nullable = false)
    private Long idPerawat;

    @Column(name = "tanggal_mulai")
    private LocalDate tanggalMulai;

    @Column(name = "tanggal_selesai")
    private LocalDate tanggalSelesai;

    public PasienPerawat() {
    }

    public Long getIdPasienPerawat() {
        return idPasienPerawat;
    }

    public void setIdPasienPerawat(Long idPasienPerawat) {
        this.idPasienPerawat = idPasienPerawat;
    }

    public Long getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Long idPasien) {
        this.idPasien = idPasien;
    }

    public Long getIdPerawat() {
        return idPerawat;
    }

    public void setIdPerawat(Long idPerawat) {
        this.idPerawat = idPerawat;
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
