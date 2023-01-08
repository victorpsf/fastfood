package com.api.fastfood.services;

import com.api.fastfood.models.ClientModel;
import com.api.fastfood.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    final ClientRepository repository;

    public ClientService(ClientRepository _repository) {
        this.repository = _repository;
    }

    @Transactional
    public ClientModel save(ClientModel model) {
        return this.repository.save(model);
    }
}
