package epicare_api.repository;

import epicare_api.entity.PasienDokter;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PasienDokterRepository
        extends JpaRepository<PasienDokter, Long> {

    List<PasienDokter> findByIdPasien(Long idPasien);
    List<PasienDokter> findByIdDokter(Long idDokter);
}