package epicare_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "pemulihan_gejala")
public class PemulihanGejala {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_pemulihan_gejala")
    private Long idPemulihanGejala;

    @Column(name = "id_pemulihan", nullable = false)
    private Long idPemulihan;

    @Column(name = "id_gejala", nullable = false)
    private Integer idGejala;

    @Column(name = "tingkat_awal", nullable = false, length = 50)
    private String tingkatAwal;

    @Column(name = "status_gejala", nullable = false, length = 20)
    private String statusGejala;

    @Column(name = "waktu_hilang")
    private LocalDateTime waktuHilang;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    public PemulihanGejala() {
    }

    public Long getIdPemulihanGejala() {
        return idPemulihanGejala;
    }

    public void setIdPemulihanGejala(Long idPemulihanGejala) {
        this.idPemulihanGejala = idPemulihanGejala;
    }

    public Long getIdPemulihan() {
        return idPemulihan;
    }

    public void setIdPemulihan(Long idPemulihan) {
        this.idPemulihan = idPemulihan;
    }

    public Integer getIdGejala() {
        return idGejala;
    }

    public void setIdGejala(Integer idGejala) {
        this.idGejala = idGejala;
    }

    public String getTingkatAwal() {
        return tingkatAwal;
    }

    public void setTingkatAwal(String tingkatAwal) {
        this.tingkatAwal = tingkatAwal;
    }

    public String getStatusGejala() {
        return statusGejala;
    }

    public void setStatusGejala(String statusGejala) {
        this.statusGejala = statusGejala;
    }

    public LocalDateTime getWaktuHilang() {
        return waktuHilang;
    }

    public void setWaktuHilang(LocalDateTime waktuHilang) {
        this.waktuHilang = waktuHilang;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
