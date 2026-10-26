package epicare_api.service;

import epicare_api.entity.UserRole;
import epicare_api.repository.UserRepository;
import epicare_api.repository.RoleRepository;
import epicare_api.repository.UserRoleRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository, UserRepository userRepository,
                           RoleRepository roleRepository) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<UserRole> getAll() { return userRoleRepository.findAll(); }
    public Optional<UserRole> getById(Long id) { return userRoleRepository.findById(id); }
    public List<UserRole> getByUserId(Long idUser) { return userRoleRepository.findByIdUser(idUser); }
    public List<UserRole> getByRoleId(Integer idRole) { return userRoleRepository.findByIdRole(idRole); }

    public UserRole create(UserRole input) {
        validateReferences(input);
        input.setIdUserRole(null);
        return userRoleRepository.save(input);
    }

    public Optional<UserRole> update(Long id, UserRole input) {
        validateReferences(input);
        return userRoleRepository.findById(id).map(existing -> {
            existing.setIdUser(input.getIdUser());
            existing.setIdRole(input.getIdRole());
            return userRoleRepository.save(existing);
        });
    }

    public boolean delete(Long id) {
        return userRoleRepository.findById(id).map(existing -> {
            userRoleRepository.delete(existing);
            return true;
        }).orElse(false);
    }

    private void validateReferences(UserRole input) {
        if (input.getIdUser() == null || !userRepository.existsById(input.getIdUser()))
            throw new IllegalArgumentException("idUser tidak ditemukan.");
        if (input.getIdRole() == null || !roleRepository.existsById(input.getIdRole()))
            throw new IllegalArgumentException("idRole tidak ditemukan.");
    }
}
