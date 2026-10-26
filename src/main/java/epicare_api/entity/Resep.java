package epicare_api.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "resep")
public class Resep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resep")
    private Long idResep;

    @Column(name = "id_pasien", nullable = false)
    private Long idPasien;

    @Column(name = "id_dokter", nullable = false)
    private Long idDokter;

    @Column(name = "tanggal_resep", nullable = false)
    private LocalDate tanggalResep;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_resep", nullable = false)
    private StatusResep statusResep = StatusResep.Aktif;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    public enum StatusResep {
        Aktif,
        Selesai,
        Dibatalkan
    }

    public Resep() {
    }

    public Long getIdResep() {
        return idResep;
    }

    public void setIdResep(Long idResep) {
        this.idResep = idResep;
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

    public LocalDate getTanggalResep() {
        return tanggalResep;
    }

    public void setTanggalResep(LocalDate tanggalResep) {
        this.tanggalResep = tanggalResep;
    }

    public StatusResep getStatusResep() {
        return statusResep;
    }

    public void setStatusResep(StatusResep statusResep) {
        this.statusResep = statusResep;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
