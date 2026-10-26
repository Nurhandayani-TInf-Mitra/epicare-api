package epicare_api.repository;

import epicare_api.entity.Resep;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResepRepository extends JpaRepository<Resep, Long> {

    List<Resep> findByIdPasien(Long idPasien);

    List<Resep> findByIdDokter(Long idDokter);

    List<Resep> findByStatusResep(Resep.StatusResep statusResep);
}
