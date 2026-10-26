package epicare_api.repository;

import epicare_api.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByIdUser(Long idUser);
    List<UserRole> findByIdRole(Integer idRole);
}