package epicare_api.service;

import epicare_api.entity.Resep;
import epicare_api.repository.ResepRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ResepService {
    private final ResepRepository repository;

    public ResepService(ResepRepository repository) {
        this.repository = repository;
    }

    public List<Resep> getAll() {
        return repository.findAll();
    }

    public Optional<Resep> getById(Long id) {
        return repository.findById(id);
    }

    public Resep create(Resep data) {
        data.setIdResep(null);
        return repository.save(data);
    }

    public Optional<Resep> update(Long id, Resep data) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        data.setIdResep(id);
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
