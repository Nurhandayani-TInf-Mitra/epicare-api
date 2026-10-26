package epicare_api.repository;

import epicare_api.entity.PemulihanGejala;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PemulihanGejalaRepository
        extends JpaRepository<PemulihanGejala, Long> {
                
List<PemulihanGejala> findByIdPemulihan(Long idPemulihan);

}