package epicare_api.repository;

import epicare_api.entity.VerifikatorBpjs;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface VerifikatorBpjsRepository
        extends JpaRepository<VerifikatorBpjs, Long> {

    Optional<VerifikatorBpjs> findByIdUser(Long idUser);
}