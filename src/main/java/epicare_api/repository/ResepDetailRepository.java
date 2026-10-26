package epicare_api.repository;

import epicare_api.entity.ResepDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResepDetailRepository
        extends JpaRepository<ResepDetail, Long> {

    List<ResepDetail> findByIdResep(Long idResep);

    List<ResepDetail> findByIdObat(Long idObat);
}
