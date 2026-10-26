package epicare_api.service;

import epicare_api.entity.PasienCaregiver;
import epicare_api.repository.PasienCaregiverRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PasienCaregiverService {
    private final PasienCaregiverRepository repository;

    public PasienCaregiverService(PasienCaregiverRepository repository) {
        this.repository = repository;
    }

    public List<PasienCaregiver> getAll() {
        return repository.findAll();
    }

    public Optional<PasienCaregiver> getById(Long id) {
        return repository.findById(id);
    }

    public PasienCaregiver create(PasienCaregiver data) {
        data.setIdCaregiver(null);
        return repository.save(data);
    }

    public Optional<PasienCaregiver> update(Long id, PasienCaregiver data) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        data.setIdCaregiver(id);
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
