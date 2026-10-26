package epicare_api.repository;

import epicare_api.entity.Kejang;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface KejangRepository extends JpaRepository<Kejang, Long> {
    List<Kejang> findByIdPasien(Long idPasien);
}