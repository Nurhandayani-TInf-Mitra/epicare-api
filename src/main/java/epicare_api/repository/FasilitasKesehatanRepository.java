package epicare_api.repository;

import epicare_api.entity.FasilitasKesehatan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FasilitasKesehatanRepository
        extends JpaRepository<FasilitasKesehatan, Long> {
}