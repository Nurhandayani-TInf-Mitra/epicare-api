package epicare_api.repository;

import epicare_api.entity.Perawat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PerawatRepository extends JpaRepository<Perawat, Long> {
    Optional<Perawat> findByIdUser(Long idUser);
}