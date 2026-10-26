package epicare_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "pasien_dokter")
public class PasienDokter {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_pasien_dokter")
    private Long idPasienDokter;

    @Column(name = "id_pasien", nullable = false)
    private Long idPasien;

    @Column(name = "id_dokter", nullable = false)
    private Long idDokter;

    @Column(name = "tanggal_mulai")
    private LocalDate tanggalMulai;

    @Column(name = "tanggal_selesai")
    private LocalDate tanggalSelesai;

    public PasienDokter() {
    }

    public Long getIdPasienDokter() {
        return idPasienDokter;
    }

    public void setIdPasienDokter(Long idPasienDokter) {
        this.idPasienDokter = idPasienDokter;
    }

    public Long getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Long idPasien) {
        this.idPasien = idPasien;
    }

    public Long getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(Long idDokter) {
        this.idDokter = idDokter;
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
