package epicare_api.service;

import epicare_api.entity.PasienDokter;
import epicare_api.repository.PasienDokterRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PasienDokterService {
    private final PasienDokterRepository repository;

    public PasienDokterService(PasienDokterRepository repository) {
        this.repository = repository;
    }

    public List<PasienDokter> getAll() {
        return repository.findAll();
    }

    public Optional<PasienDokter> getById(Long id) {
        return repository.findById(id);
    }

    public PasienDokter create(PasienDokter data) {
        data.setIdPasienDokter(null);
        return repository.save(data);
    }

    public Optional<PasienDokter> update(Long id, PasienDokter data) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        data.setIdPasienDokter(id);
        return Optional.of(repository.save(data));
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
