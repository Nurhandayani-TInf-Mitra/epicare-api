package epicare_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "pasien_caregiver")
public class PasienCaregiver {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_caregiver")
    private Long idCaregiver;

    @Column(name = "id_pasien", nullable = false)
    private Long idPasien;

    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "hubungan", nullable = false, length = 50)
    private String hubungan;

    @Column(name = "tanggal_mulai")
    private LocalDate tanggalMulai;

    @Column(name = "tanggal_selesai")
    private LocalDate tanggalSelesai;

    @Column(name = "status", length = 20)
    private String status;

    public PasienCaregiver() {
    }

    public Long getIdCaregiver() {
        return idCaregiver;
    }

    public void setIdCaregiver(Long idCaregiver) {
        this.idCaregiver = idCaregiver;
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

    public String getHubungan() {
        return hubungan;
    }

    public void setHubungan(String hubungan) {
        this.hubungan = hubungan;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
