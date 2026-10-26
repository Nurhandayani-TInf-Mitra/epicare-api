package epicare_api.repository;

import epicare_api.entity.Pasien;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PasienRepository extends JpaRepository<Pasien, Long> {
    Optional<Pasien> findByIdUser(Long idUser);
}