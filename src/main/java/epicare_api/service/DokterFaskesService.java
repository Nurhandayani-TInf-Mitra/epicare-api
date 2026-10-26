package epicare_api.service;

import epicare_api.entity.DokterFaskes;
import epicare_api.repository.DokterFaskesRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DokterFaskesService {
    private final DokterFaskesRepository repository;

    public DokterFaskesService(DokterFaskesRepository repository) {
        this.repository = repository;
    }

    public List<DokterFaskes> getAll() {
        return repository.findAll();
    }

    public Optional<DokterFaskes> getById(Long id) {
        return repository.findById(id);
    }

    public DokterFaskes create(DokterFaskes data) {
        data.setIdDokterFaskes(null);
        return repository.save(data);
    }

    public Optional<DokterFaskes> update(Long id, DokterFaskes data) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        data.setIdDokterFaskes(id);
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
