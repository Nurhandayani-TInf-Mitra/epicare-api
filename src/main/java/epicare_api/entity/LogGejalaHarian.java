package epicare_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "log_gejala_harian")
public class LogGejalaHarian {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_log_gejala")
    private Long idLogGejala;

    @Column(name = "id_log", nullable = false)
    private Long idLog;

    @Column(name = "id_pemulihan_gejala", nullable = false)
    private Long idPemulihanGejala;

    @Column(name = "kondisi_hari_ini", nullable = false, length = 20)
    private String kondisiHariIni;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    public LogGejalaHarian() {
    }

    public Long getIdLogGejala() {
        return idLogGejala;
    }

    public void setIdLogGejala(Long idLogGejala) {
        this.idLogGejala = idLogGejala;
    }

    public Long getIdLog() {
        return idLog;
    }

    public void setIdLog(Long idLog) {
        this.idLog = idLog;
    }

    public Long getIdPemulihanGejala() {
        return idPemulihanGejala;
    }

    public void setIdPemulihanGejala(Long idPemulihanGejala) {
        this.idPemulihanGejala = idPemulihanGejala;
    }

    public String getKondisiHariIni() {
        return kondisiHariIni;
    }

    public void setKondisiHariIni(String kondisiHariIni) {
        this.kondisiHariIni = kondisiHariIni;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
