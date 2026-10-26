package epicare_api.service;

import epicare_api.entity.Role;
import epicare_api.repository.RoleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public List<Role> getAll() {
        return repository.findAll();
    }

    public Optional<Role> getById(Integer id) {
        return repository.findById(id);
    }

    public Role create(Role data) {
        data.setIdRole(null);
        return repository.save(data);
    }

    public Optional<Role> update(Integer id, Role data) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        data.setIdRole(id);
        return Optional.of(repository.save(data));
    }

    public boolean delete(Integer id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
