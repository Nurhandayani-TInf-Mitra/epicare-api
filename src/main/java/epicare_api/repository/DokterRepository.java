package epicare_api.repository;

import epicare_api.entity.Dokter;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DokterRepository extends JpaRepository<Dokter, Long> {
    Optional<Dokter> findByIdUser(Long idUser);
}