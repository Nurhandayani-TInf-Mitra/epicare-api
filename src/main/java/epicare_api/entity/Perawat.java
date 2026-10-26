package epicare_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "perawat")
public class Perawat {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_perawat")
    private Long idPerawat;

    @Column(name = "id_user", nullable = false, unique = true)
    private Long idUser;

    @Column(name = "nomor_str", length = 50, unique = true)
    private String nomorStr;

    public Perawat() {
    }

    public Long getIdPerawat() {
        return idPerawat;
    }

    public void setIdPerawat(Long idPerawat) {
        this.idPerawat = idPerawat;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getNomorStr() {
        return nomorStr;
    }

    public void setNomorStr(String nomorStr) {
        this.nomorStr = nomorStr;
    }

}
