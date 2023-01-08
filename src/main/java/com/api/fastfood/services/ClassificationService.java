package com.api.fastfood.services;

import com.api.fastfood.dtos.Classifications.GetClassificationDto;
import com.api.fastfood.models.ClassificationModel;
import com.api.fastfood.repositories.ClassificationRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationService {
    final ClassificationRepository repository;

    public ClassificationService(ClassificationRepository _repository) { this.repository = _repository; }

    public ClassificationModel save(ClassificationModel model) {
        return this.repository.save(model);
    }

    public List<ClassificationModel> get(GetClassificationDto input) {
        var query = new ClassificationModel();

        if (input.getId() != null) query.setId(input.getId());
        if (input.getName() != null) query.setName(input.getName());

        Example<ClassificationModel> ex = Example.of(query);
        return this.repository.findAll(ex);
    }
}
