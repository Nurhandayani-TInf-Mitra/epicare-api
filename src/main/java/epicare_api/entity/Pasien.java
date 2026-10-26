package epicare_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "pasien")
public class Pasien {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_pasien")
    private Long idPasien;

    @Column(name = "id_user", nullable = false, unique = true)
    private Long idUser;

    @Column(name = "no_bpjs", length = 13, unique = true)
    private String noBpjs;

    @Column(name = "tanggal_mulai_sakit")
    private LocalDate tanggalMulaiSakit;

    @Column(name = "tanggal_mulai_pengobatan")
    private LocalDate tanggalMulaiPengobatan;

    public Pasien() {
    }

    public Long getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Long idPasien) {
        this.idPasien = idPasien;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNoBpjs() {
        return noBpjs;
    }

    public void setNoBpjs(String noBpjs) {
        this.noBpjs = noBpjs;
    }

    public LocalDate getTanggalMulaiSakit() {
        return tanggalMulaiSakit;
    }

    public void setTanggalMulaiSakit(LocalDate tanggalMulaiSakit) {
        this.tanggalMulaiSakit = tanggalMulaiSakit;
    }

    public LocalDate getTanggalMulaiPengobatan() {
        return tanggalMulaiPengobatan;
    }

    public void setTanggalMulaiPengobatan(LocalDate tanggalMulaiPengobatan) {
        this.tanggalMulaiPengobatan = tanggalMulaiPengobatan;
    }

}
