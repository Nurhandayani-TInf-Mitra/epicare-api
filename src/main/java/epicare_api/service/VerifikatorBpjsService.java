package epicare_api.service;

import epicare_api.entity.VerifikatorBpjs;
import epicare_api.repository.VerifikatorBpjsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VerifikatorBpjsService {
    private final VerifikatorBpjsRepository repository;

    public VerifikatorBpjsService(VerifikatorBpjsRepository repository) {
        this.repository = repository;
    }

    public List<VerifikatorBpjs> getAll() {
        return repository.findAll();
    }

    public Optional<VerifikatorBpjs> getById(Long id) {
        return repository.findById(id);
    }

    public VerifikatorBpjs create(VerifikatorBpjs data) {
        data.setIdVerifikator(null);
        return repository.save(data);
    }

    public Optional<VerifikatorBpjs> update(Long id, VerifikatorBpjs data) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        data.setIdVerifikator(id);
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
