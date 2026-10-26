package epicare_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "kontak_darurat")
public class KontakDarurat {

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_kontak_darurat")
    private Long idKontakDarurat;

    @Column(name = "id_pasien", nullable = false)
    private Long idPasien;

    @Column(name = "nama_kontak", nullable = false, length = 100)
    private String namaKontak;

    @Column(name = "no_hp", nullable = false, length = 13)
    private String noHp;

    @Column(name = "hubungan", nullable = false, length = 50)
    private String hubungan;

    @Column(name = "prioritas", nullable = false)
    private Integer prioritas;

    public KontakDarurat() {
    }

    public Long getIdKontakDarurat() {
        return idKontakDarurat;
    }

    public void setIdKontakDarurat(Long idKontakDarurat) {
        this.idKontakDarurat = idKontakDarurat;
    }

    public Long getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Long idPasien) {
        this.idPasien = idPasien;
    }

    public String getNamaKontak() {
        return namaKontak;
    }

    public void setNamaKontak(String namaKontak) {
        this.namaKontak = namaKontak;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getHubungan() {
        return hubungan;
    }

    public void setHubungan(String hubungan) {
        this.hubungan = hubungan;
    }

    public Integer getPrioritas() {
        return prioritas;
    }

    public void setPrioritas(Integer prioritas) {
        this.prioritas = prioritas;
    }

}
