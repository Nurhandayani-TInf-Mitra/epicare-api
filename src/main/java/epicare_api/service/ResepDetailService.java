package epicare_api.service;

import epicare_api.entity.ResepDetail;
import epicare_api.repository.ResepDetailRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ResepDetailService {
    private final ResepDetailRepository repository;

    public ResepDetailService(ResepDetailRepository repository) {
        this.repository = repository;
    }

    public List<ResepDetail> getAll() {
        return repository.findAll();
    }

    public Optional<ResepDetail> getById(Long id) {
        return repository.findById(id);
    }

    public ResepDetail create(ResepDetail data) {
        data.setIdResepDetail(null);
        return repository.save(data);
    }

    public Optional<ResepDetail> update(Long id, ResepDetail data) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        data.setIdResepDetail(id);
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
