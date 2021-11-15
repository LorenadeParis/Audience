package com.audience.audience.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.audience.audience.entity.Audience;
import com.audience.audience.repository.AudienceRepository;

@Service
public class AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    public List<Audience> getAll() {
        return audienceRepository.getAll();
    }

    public Optional<Audience> getAudience(int id) {
        return audienceRepository.getAudience(id);
    }

    public Audience save(Audience audience) {
        if (audience.getId() == null) {
            return audienceRepository.save(audience);

        } else {
            Optional<Audience> consulta = audienceRepository.getAudience(audience.getId());
            if (consulta.isEmpty()) {
                return audienceRepository.save(audience);

            } else {
                return audience;
            }

        }
    }

    public Audience update(Audience audience) {
        if (audience.getId() != null) {
            Optional<Audience> consulta = audienceRepository.getAudience(audience.getId());
            if (!consulta.isEmpty()) {
                if (consulta.get().getName() != null) {
                    consulta.get().setName(audience.getName());
                }
                if (consulta.get().getOwner() != null) {
                    consulta.get().setOwner(audience.getOwner());
                }
                if (consulta.get().getCapacity() != null) {
                    consulta.get().setCapacity(audience.getCapacity());
                }
                if (consulta.get().getDescription() != null) {
                    consulta.get().setDescription(audience.getDescription());
                }
                return audienceRepository.save(consulta.get());
            }
        }
        return audience;
    }

    public void delete(int id) {
        Optional<Audience> consulta = audienceRepository.getAudience(id);
        if (!consulta.isEmpty()) {
            audienceRepository.delete(id);
        }
    }
}
