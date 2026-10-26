package epicare_api.service;

import epicare_api.entity.PasienPerawat;
import epicare_api.repository.PasienPerawatRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PasienPerawatService {
    private final PasienPerawatRepository repository;

    public PasienPerawatService(PasienPerawatRepository repository) {
        this.repository = repository;
    }

    public List<PasienPerawat> getAll() {
        return repository.findAll();
    }

    public Optional<PasienPerawat> getById(Long id) {
        return repository.findById(id);
    }

    public PasienPerawat create(PasienPerawat data) {
        data.setIdPasienPerawat(null);
        return repository.save(data);
    }

    public Optional<PasienPerawat> update(Long id, PasienPerawat data) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        data.setIdPasienPerawat(id);
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
