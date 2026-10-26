package epicare_api.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "resep_detail")
public class ResepDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resep_detail")
    private Long idResepDetail;

    @Column(name = "id_resep", nullable = false)
    private Long idResep;

    @Column(name = "id_obat", nullable = false)
    private Long idObat;

    @Column(name = "dosis", nullable = false, length = 50)
    private String dosis;

    @Column(name = "frekuensi", nullable = false)
    private Integer frekuensi = 1;

    @Convert(converter = SatuanFrekuensiConverter.class)
    @Column(name = "satuan_frekuensi", nullable = false)
    private SatuanFrekuensi satuanFrekuensi =
            SatuanFrekuensi.Kali_Sehari;

    @Column(name = "waktu_pemberian", length = 100)
    private String waktuPemberian;

    @Column(name = "aturan_pakai", columnDefinition = "TEXT")
    private String aturanPakai;

    @Column(name = "catatan", columnDefinition = "TEXT")
    private String catatan;

    @Column(name = "tanggal_mulai", nullable = false)
    private LocalDate tanggalMulai;

    @Column(name = "tanggal_selesai")
    private LocalDate tanggalSelesai;

    @Column(name = "created_at", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

    public enum SatuanFrekuensi {
        Kali_Sehari("Kali Sehari"),
        Kali_Seminggu("Kali Seminggu"),
        Sesuai_Kebutuhan("Sesuai Kebutuhan");

        private final String nilaiDatabase;

        SatuanFrekuensi(String nilaiDatabase) {
            this.nilaiDatabase = nilaiDatabase;
        }

        public String getNilaiDatabase() {
            return nilaiDatabase;
        }

        public static SatuanFrekuensi dariNilaiDatabase(String nilai) {
            for (SatuanFrekuensi satuan : values()) {
                if (satuan.nilaiDatabase.equals(nilai)) {
                    return satuan;
                }
            }
            throw new IllegalArgumentException(
                "Satuan frekuensi tidak dikenal: " + nilai
            );
        }
    }

    public ResepDetail() {
    }

    public Long getIdResepDetail() {
        return idResepDetail;
    }

    public void setIdResepDetail(Long idResepDetail) {
        this.idResepDetail = idResepDetail;
    }

    public Long getIdResep() {
        return idResep;
    }

    public void setIdResep(Long idResep) {
        this.idResep = idResep;
    }

    public Long getIdObat() {
        return idObat;
    }

    public void setIdObat(Long idObat) {
        this.idObat = idObat;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public Integer getFrekuensi() {
        return frekuensi;
    }

    public void setFrekuensi(Integer frekuensi) {
        this.frekuensi = frekuensi;
    }

    public SatuanFrekuensi getSatuanFrekuensi() {
        return satuanFrekuensi;
    }

    public void setSatuanFrekuensi(SatuanFrekuensi satuanFrekuensi) {
        this.satuanFrekuensi = satuanFrekuensi;
    }

    public String getWaktuPemberian() {
        return waktuPemberian;
    }

    public void setWaktuPemberian(String waktuPemberian) {
        this.waktuPemberian = waktuPemberian;
    }

    public String getAturanPakai() {
        return aturanPakai;
    }

    public void setAturanPakai(String aturanPakai) {
        this.aturanPakai = aturanPakai;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
