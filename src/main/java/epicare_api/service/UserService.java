package epicare_api.service;

import epicare_api.entity.User;
import epicare_api.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAll() { return userRepository.findAll(); }
    public Optional<User> getById(Long id) { return userRepository.findById(id); }

    public User create(User user) {
        user.setIdUser(null);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> update(Long id, User input) {
        return userRepository.findById(id).map(existing -> {
            existing.setUsername(input.getUsername());
            existing.setEmail(input.getEmail());
            existing.setNoHp(input.getNoHp());
            existing.setStatusAkun(input.getStatusAkun());
            if (input.getPassword() != null && !input.getPassword().isBlank()) {
                existing.setPassword(passwordEncoder.encode(input.getPassword()));
            }
            return userRepository.save(existing);
        });
    }

    public boolean delete(Long id) {
        return userRepository.findById(id).map(existing -> {
            userRepository.delete(existing);
            return true;
        }).orElse(false);
    }
}
