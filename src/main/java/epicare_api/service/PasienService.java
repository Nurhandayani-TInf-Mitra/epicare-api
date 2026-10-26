package epicare_api.service;

import epicare_api.entity.Pasien;
import epicare_api.repository.PasienRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PasienService {
    private final PasienRepository repository;

    public PasienService(PasienRepository repository) {
        this.repository = repository;
    }

    public List<Pasien> getAll() {
        return repository.findAll();
    }

    public Optional<Pasien> getById(Long id) {
        return repository.findById(id);
    }

    public Pasien create(Pasien data) {
        data.setIdPasien(null);
        return repository.save(data);
    }

    public Optional<Pasien> update(Long id, Pasien data) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        data.setIdPasien(id);
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
