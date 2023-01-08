package com.api.fastfood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.fastfood.models.ClassificationModel;

public interface ClassificationRepository extends JpaRepository<ClassificationModel, Integer> { }
