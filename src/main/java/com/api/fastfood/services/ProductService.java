package com.api.fastfood.services;

import com.api.fastfood.dtos.Pagination;
import com.api.fastfood.dtos.Products.GetProductDto;
import com.api.fastfood.models.ProductModel;
import com.api.fastfood.repositories.ClassificationRepository;
import com.api.fastfood.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    final ProductRepository repository;
    final ClassificationRepository classificationRepository;

    public ProductService(
            ProductRepository _repository,
            ClassificationRepository _classificationRepository
    ) {
        this.repository = _repository;
        this.classificationRepository = _classificationRepository;
    }

    public List<ProductModel> get(Pagination<GetProductDto> input) {
        var model = input.getModel();
        return this.repository.findProduct(input.getLimit(), input.getLastId(), model.getId(), model.getName(), model.getClassifications());
    }

    @Transactional
    public ProductModel save(ProductModel model, Integer[] classifications) {
        if (classifications != null) {
            for (Integer classificationId : classifications) {
                var classification = this.classificationRepository.findById(classificationId);
                if (classification.isEmpty()) continue;
                model.getClassifications().add(classification.get());
            }
        }

        return this.repository.findById(this.repository.save(model).getId()).get();
    }
}
