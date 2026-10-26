package epicare_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "verifikator_bpjs")
public class VerifikatorBpjs {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_verifikator")
    private Long idVerifikator;

    @Column(name = "id_user", nullable = false, unique = true)
    private Long idUser;

    @Column(name = "nomor_identitas_petugas", length = 50, unique = true)
    private String nomorIdentitasPetugas;

    @Column(name = "kantor_bpjs", length = 150)
    private String kantorBpjs;

    public VerifikatorBpjs() {
    }

    public Long getIdVerifikator() {
        return idVerifikator;
    }

    public void setIdVerifikator(Long idVerifikator) {
        this.idVerifikator = idVerifikator;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNomorIdentitasPetugas() {
        return nomorIdentitasPetugas;
    }

    public void setNomorIdentitasPetugas(String nomorIdentitasPetugas) {
        this.nomorIdentitasPetugas = nomorIdentitasPetugas;
    }

    public String getKantorBpjs() {
        return kantorBpjs;
    }

    public void setKantorBpjs(String kantorBpjs) {
        this.kantorBpjs = kantorBpjs;
    }

}
