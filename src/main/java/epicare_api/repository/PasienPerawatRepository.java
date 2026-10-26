package epicare_api.repository;

import epicare_api.entity.PasienPerawat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PasienPerawatRepository
        extends JpaRepository<PasienPerawat, Long> {

    List<PasienPerawat> findByIdPasien(Long idPasien);
    List<PasienPerawat> findByIdPerawat(Long idPerawat);
}