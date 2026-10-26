package epicare_api.repository;

import epicare_api.entity.KontakDarurat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface KontakDaruratRepository
        extends JpaRepository<KontakDarurat, Long> {

    List<KontakDarurat> findByIdPasien(Long idPasien);
}