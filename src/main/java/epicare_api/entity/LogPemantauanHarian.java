package epicare_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_pemantauan_harian")
public class LogPemantauanHarian {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_log")
    private Long idLog;

    @Column(name = "id_pemulihan", nullable = false)
    private Long idPemulihan;

    @Column(name = "tanggal_log", nullable = false, insertable = false)
    private LocalDateTime tanggalLog;

    @Column(name = "gejala_tambahan", columnDefinition = "TEXT")
    private String gejalaTambahan;

    @Column(name = "tingkat_risiko", length = 20)
    private String tingkatRisiko;

    @Column(name = "rekomendasi", length = 30)
    private String rekomendasi;

    @Column(name = "pulih_total", nullable = false)
    private Boolean pulihTotal;

    @Column(name = "catatan_sistem", columnDefinition = "TEXT")
    private String catatanSistem;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public LogPemantauanHarian() {
    }

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
    }

    public Long getIdPemulihan() {
        return idPemulihan;
    }

    public void setIdPemulihan(Long idPemulihan) {
        this.idPemulihan = idPemulihan;
    }

    public LocalDateTime getTanggalLog() {
        return tanggalLog;
    }

    public void setTanggalLog(LocalDateTime tanggalLog) {
        this.tanggalLog = tanggalLog;
    }

    public String getGejalaTambahan() {
        return gejalaTambahan;
    }

    public void setGejalaTambahan(String gejalaTambahan) {
        this.gejalaTambahan = gejalaTambahan;
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

    public Boolean getPulihTotal() {
        return pulihTotal;
    }

    public void setPulihTotal(Boolean pulihTotal) {
        this.pulihTotal = pulihTotal;
    }

    public String getCatatanSistem() {
        return catatanSistem;
    }

    public void setCatatanSistem(String catatanSistem) {
        this.catatanSistem = catatanSistem;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
