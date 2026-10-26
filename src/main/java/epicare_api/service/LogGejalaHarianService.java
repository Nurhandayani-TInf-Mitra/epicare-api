package epicare_api.service;

import epicare_api.entity.LogGejalaHarian;
import epicare_api.repository.LogGejalaHarianRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LogGejalaHarianService {
    private final LogGejalaHarianRepository repository;

    public LogGejalaHarianService(LogGejalaHarianRepository repository) {
        this.repository = repository;
    }

    public List<LogGejalaHarian> getAll() {
        return repository.findAll();
    }

    public Optional<LogGejalaHarian> getById(Long id) {
        return repository.findById(id);
    }

    public LogGejalaHarian create(LogGejalaHarian data) {
        data.setIdLogGejala(null);
        return repository.save(data);
    }

    public Optional<LogGejalaHarian> update(Long id, LogGejalaHarian data) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        data.setIdLogGejala(id);
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
