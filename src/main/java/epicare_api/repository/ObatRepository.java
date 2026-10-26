package epicare_api.repository;

import epicare_api.entity.Obat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObatRepository extends JpaRepository<Obat, Long> {
}