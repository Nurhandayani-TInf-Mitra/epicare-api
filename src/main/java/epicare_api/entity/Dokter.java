package epicare_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dokter")
public class Dokter {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_dokter")
    private Long idDokter;

    @Column(name = "id_user", nullable = false, unique = true)
    private Long idUser;

    @Column(name = "nomor_sip", length = 50, unique = true)
    private String nomorSip;

    @Column(name = "spesialisasi", nullable = false, length = 100)
    private String spesialisasi;

    public Dokter() {
    }

    public Long getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(Long idDokter) {
        this.idDokter = idDokter;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNomorSip() {
        return nomorSip;
    }

    public void setNomorSip(String nomorSip) {
        this.nomorSip = nomorSip;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        this.spesialisasi = spesialisasi;
    }

}
