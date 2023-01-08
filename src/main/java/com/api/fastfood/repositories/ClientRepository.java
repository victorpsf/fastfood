package com.api.fastfood.repositories;

import com.api.fastfood.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Integer> { }
