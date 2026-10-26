package epicare_api.repository;

import epicare_api.entity.LogGejalaHarian;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LogGejalaHarianRepository
        extends JpaRepository<LogGejalaHarian, Long> {

    List<LogGejalaHarian> findByIdLog(Long idLog);

    List<LogGejalaHarian> findByIdPemulihanGejala(
            Long idPemulihanGejala);
}
