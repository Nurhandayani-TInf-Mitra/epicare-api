package epicare_api.service;

import epicare_api.entity.Dokter;
import epicare_api.repository.DokterRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DokterService {
    private final DokterRepository repository;

    public DokterService(DokterRepository repository) {
        this.repository = repository;
    }

    public List<Dokter> getAll() {
        return repository.findAll();
    }

    public Optional<Dokter> getById(Long id) {
        return repository.findById(id);
    }

    public Dokter create(Dokter data) {
        data.setIdDokter(null);
        return repository.save(data);
    }

    public Optional<Dokter> update(Long id, Dokter data) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        data.setIdDokter(id);
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
