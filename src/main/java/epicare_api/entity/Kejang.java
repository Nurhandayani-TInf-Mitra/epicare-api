package epicare_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "kejang")
public class Kejang {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_kejang")
    private Long idKejang;

    @Column(name = "id_pasien", nullable = false)
    private Long idPasien;

    @Column(name = "tanggal_waktu", nullable = false)
    private LocalDateTime tanggalWaktu;

    @Column(name = "durasi", nullable = false, length = 20)
    private String durasi;

    @Column(name = "kondisi_sebelum", columnDefinition = "TEXT")
    private String kondisiSebelum;

    @Column(name = "kehilangan_kesadaran", nullable = false)
    private Boolean kehilanganKesadaran;

    @Column(name = "jatuh", nullable = false)
    private Boolean jatuh;

    @Column(name = "cedera", nullable = false)
    private Boolean cedera;

    @Column(name = "kejang_sesaat", nullable = false)
    private Boolean kejangSesaat;

    @Column(name = "kejang_berulang", nullable = false)
    private Boolean kejangBerulang;

    @Column(name = "kondisi_lainnya", columnDefinition = "TEXT")
    private String kondisiLainnya;

    @Column(name = "tingkat_keparahan", length = 20)
    private String tingkatKeparahan;

    @Column(name = "catatan_sistem", columnDefinition = "TEXT")
    private String catatanSistem;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    public Kejang() {
    }

    public Long getIdKejang() {
        return idKejang;
    }

    public void setIdKejang(Long idKejang) {
        this.idKejang = idKejang;
    }

    public Long getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Long idPasien) {
        this.idPasien = idPasien;
    }

    public LocalDateTime getTanggalWaktu() {
        return tanggalWaktu;
    }

    public void setTanggalWaktu(LocalDateTime tanggalWaktu) {
        this.tanggalWaktu = tanggalWaktu;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getKondisiSebelum() {
        return kondisiSebelum;
    }

    public void setKondisiSebelum(String kondisiSebelum) {
        this.kondisiSebelum = kondisiSebelum;
    }

    public Boolean getKehilanganKesadaran() {
        return kehilanganKesadaran;
    }

    public void setKehilanganKesadaran(Boolean kehilanganKesadaran) {
        this.kehilanganKesadaran = kehilanganKesadaran;
    }

    public Boolean getJatuh() {
        return jatuh;
    }

    public void setJatuh(Boolean jatuh) {
        this.jatuh = jatuh;
    }

    public Boolean getCedera() {
        return cedera;
    }

    public void setCedera(Boolean cedera) {
        this.cedera = cedera;
    }

    public Boolean getKejangSesaat() {
        return kejangSesaat;
    }

    public void setKejangSesaat(Boolean kejangSesaat) {
        this.kejangSesaat = kejangSesaat;
    }

    public Boolean getKejangBerulang() {
        return kejangBerulang;
    }

    public void setKejangBerulang(Boolean kejangBerulang) {
        this.kejangBerulang = kejangBerulang;
    }

    public String getKondisiLainnya() {
        return kondisiLainnya;
    }

    public void setKondisiLainnya(String kondisiLainnya) {
        this.kondisiLainnya = kondisiLainnya;
    }

    public String getTingkatKeparahan() {
        return tingkatKeparahan;
    }

    public void setTingkatKeparahan(String tingkatKeparahan) {
        this.tingkatKeparahan = tingkatKeparahan;
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

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
