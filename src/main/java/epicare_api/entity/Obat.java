package epicare_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "obat")
public class Obat {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_obat")
    private Long idObat;

    @Column(name = "nama_obat", nullable = false, length = 100, unique = true)
    private String namaObat;

    @Column(name = "bentuk_sediaan", nullable = false, length = 20)
    private String bentukSediaan;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    public Obat() {
    }

    public Long getIdObat() {
        return idObat;
    }

    public void setIdObat(Long idObat) {
        this.idObat = idObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public String getBentukSediaan() {
        return bentukSediaan;
    }

    public void setBentukSediaan(String bentukSediaan) {
        this.bentukSediaan = bentukSediaan;
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
