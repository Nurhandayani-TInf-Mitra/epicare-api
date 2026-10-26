package epicare_api.service;

import epicare_api.entity.LogPemantauanHarian;
import epicare_api.repository.LogPemantauanHarianRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LogPemantauanHarianService {
    private final LogPemantauanHarianRepository repository;

    public LogPemantauanHarianService(LogPemantauanHarianRepository repository) {
        this.repository = repository;
    }

    public List<LogPemantauanHarian> getAll() {
        return repository.findAll();
    }

    public Optional<LogPemantauanHarian> getById(Long id) {
        return repository.findById(id);
    }

    public LogPemantauanHarian create(LogPemantauanHarian data) {
        data.setIdLog(null);
        return repository.save(data);
    }

    public Optional<LogPemantauanHarian> update(Long id, LogPemantauanHarian data) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        data.setIdLog(id);
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
