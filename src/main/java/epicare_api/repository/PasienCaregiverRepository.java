package epicare_api.repository;

import epicare_api.entity.PasienCaregiver;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PasienCaregiverRepository
        extends JpaRepository<PasienCaregiver, Long> {

    List<PasienCaregiver> findByIdPasien(Long idPasien);
}