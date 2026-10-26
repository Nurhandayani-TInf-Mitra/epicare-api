package epicare_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fasilitas_kesehatan")
public class FasilitasKesehatan {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_faskes")
    private Long idFaskes;

    @Column(name = "nama_faskes", nullable = false, length = 150)
    private String namaFaskes;

    @Column(name = "jenis_faskes", nullable = false, length = 30)
    private String jenisFaskes;

    @Column(name = "alamat", nullable = false, columnDefinition = "TEXT")
    private String alamat;

    @Column(name = "no_telepon", length = 13)
    private String noTelepon;

    public FasilitasKesehatan() {
    }

    public Long getIdFaskes() {
        return idFaskes;
    }

    public void setIdFaskes(Long idFaskes) {
        this.idFaskes = idFaskes;
    }

    public String getNamaFaskes() {
        return namaFaskes;
    }

    public void setNamaFaskes(String namaFaskes) {
        this.namaFaskes = namaFaskes;
    }

    public String getJenisFaskes() {
        return jenisFaskes;
    }

    public void setJenisFaskes(String jenisFaskes) {
        this.jenisFaskes = jenisFaskes;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

}
