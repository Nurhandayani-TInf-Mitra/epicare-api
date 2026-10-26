package epicare_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "pemulihan_pasca_kejang")
public class PemulihanPascaKejang {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_pemulihan")
    private Long idPemulihan;

    @Column(name = "id_kejang", nullable = false, unique = true)
    private Long idKejang;

    @Column(name = "kondisi_cedera", nullable = false, length = 100)
    private String kondisiCedera;

    @Column(name = "kecepatan_pemulihan", length = 20)
    private String kecepatanPemulihan;

    @Column(name = "tingkat_risiko", length = 20)
    private String tingkatRisiko;

    @Column(name = "rekomendasi", length = 30)
    private String rekomendasi;

    @Column(name = "status_pemulihan", nullable = false, length = 20)
    private String statusPemulihan;

    @Column(name = "catatan_sistem", columnDefinition = "TEXT")
    private String catatanSistem;

    @Column(name = "waktu_input_awal", nullable = false, insertable = false)
    private LocalDateTime waktuInputAwal;

    @Column(name = "waktu_pulih_total")
    private LocalDateTime waktuPulihTotal;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    public PemulihanPascaKejang() {
    }

    public Long getIdPemulihan() {
        return idPemulihan;
    }

    public void setIdPemulihan(Long idPemulihan) {
        this.idPemulihan = idPemulihan;
    }

    public Long getIdKejang() {
        return idKejang;
    }

    public void setIdKejang(Long idKejang) {
        this.idKejang = idKejang;
    }

    public String getKondisiCedera() {
        return kondisiCedera;
    }

    public void setKondisiCedera(String kondisiCedera) {
        this.kondisiCedera = kondisiCedera;
    }

    public String getKecepatanPemulihan() {
        return kecepatanPemulihan;
    }

    public void setKecepatanPemulihan(String kecepatanPemulihan) {
        this.kecepatanPemulihan = kecepatanPemulihan;
    }

    public String getTingkatRisiko() {
        return tingkatRisiko;
    }

    public void setTingkatRisiko(String tingkatRisiko) {
        this.tingkatRisiko = tingkatRisiko;
    }

    public String getRekomendasi() {
        return rekomendasi;
    }

    public void setRekomendasi(String rekomendasi) {
        this.rekomendasi = rekomendasi;
    }

    public String getStatusPemulihan() {
        return statusPemulihan;
    }

    public void setStatusPemulihan(String statusPemulihan) {
        this.statusPemulihan = statusPemulihan;
    }

    public String getCatatanSistem() {
        return catatanSistem;
    }

    public void setCatatanSistem(String catatanSistem) {
        this.catatanSistem = catatanSistem;
    }

    public LocalDateTime getWaktuInputAwal() {
        return waktuInputAwal;
    }

    public void setWaktuInputAwal(LocalDateTime waktuInputAwal) {
        this.waktuInputAwal = waktuInputAwal;
    }

    public LocalDateTime getWaktuPulihTotal() {
        return waktuPulihTotal;
    }

    public void setWaktuPulihTotal(LocalDateTime waktuPulihTotal) {
        this.waktuPulihTotal = waktuPulihTotal;
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
