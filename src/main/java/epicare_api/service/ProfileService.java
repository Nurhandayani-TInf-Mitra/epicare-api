package epicare_api.service;

import epicare_api.entity.Profile;
import epicare_api.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {
    private final ProfileRepository repository;

    public ProfileService(ProfileRepository repository) {
        this.repository = repository;
    }

    public List<Profile> getAll() {
        return repository.findAll();
    }

    public Optional<Profile> getById(Long id) {
        return repository.findById(id);
    }

    public Profile create(Profile data) {
        data.setIdProfile(null);
        return repository.save(data);
    }

    public Optional<Profile> update(Long id, Profile data) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        data.setIdProfile(id);
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
