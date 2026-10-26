
package epicare_api.repository;

import epicare_api.entity.LogPemantauanHarian;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LogPemantauanHarianRepository
        extends JpaRepository<LogPemantauanHarian, Long> {

    List<LogPemantauanHarian> findByIdPemulihan(Long idPemulihan);
}
