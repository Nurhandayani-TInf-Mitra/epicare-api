package epicare_api.repository;

import epicare_api.entity.DokterFaskes;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DokterFaskesRepository
        extends JpaRepository<DokterFaskes, Long> {

    List<DokterFaskes> findByIdDokter(Long idDokter);
    List<DokterFaskes> findByIdFaskes(Long idFaskes);
}