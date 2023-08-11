package org.qam.service;

import org.qam.entity.SampleEntity;
import org.qam.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    private final SampleRepository repository;

    @Autowired
    public SampleService(SampleRepository repository) {
        this.repository = repository;
    }

    public SampleEntity saveEntity(SampleEntity entity) {
        return repository.save(entity);
    }

    public SampleEntity getEntityById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
