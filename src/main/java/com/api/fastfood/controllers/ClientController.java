package com.api.fastfood.controllers;

import com.api.fastfood.dtos.ClientDto;
import com.api.fastfood.models.ClientModel;
import com.api.fastfood.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/client")
public class ClientController {
    final ClientService service;

    public ClientController (ClientService _service) {
        this.service = _service;
    }

    @PostMapping
    public ResponseEntity<ClientModel> save(@RequestBody @Valid ClientDto input) {
        var output = new ClientModel();
        BeanUtils.copyProperties(input, output);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(output));
    }
}
