package epicare_api.service;

import epicare_api.entity.Perawat;
import epicare_api.repository.PerawatRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PerawatService {
    private final PerawatRepository repository;

    public PerawatService(PerawatRepository repository) {
        this.repository = repository;
    }

    public List<Perawat> getAll() {
        return repository.findAll();
    }

    public Optional<Perawat> getById(Long id) {
        return repository.findById(id);
    }

    public Perawat create(Perawat data) {
        data.setIdPerawat(null);
        return repository.save(data);
    }

    public Optional<Perawat> update(Long id, Perawat data) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        data.setIdPerawat(id);
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
