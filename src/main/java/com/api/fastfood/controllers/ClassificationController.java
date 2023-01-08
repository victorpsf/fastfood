package com.api.fastfood.controllers;

import com.api.fastfood.dtos.Classifications.ChangeClassificationDto;
import com.api.fastfood.dtos.Classifications.CreateClassificationDto;
import com.api.fastfood.dtos.Classifications.GetClassificationDto;
import com.api.fastfood.models.ClassificationModel;
import com.api.fastfood.services.ClassificationService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClassificationController {
    final ClassificationService service;

    public ClassificationController(ClassificationService _service) { this.service = _service; }

    @RequestMapping(value = "/classification/get", method = RequestMethod.POST)
    public ResponseEntity<List<ClassificationModel>> get(@RequestBody GetClassificationDto input) {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.get(input));
    }

    @RequestMapping(value = "/classification/save", method = RequestMethod.POST)
    public ResponseEntity<ClassificationModel> save(@RequestBody @Valid CreateClassificationDto input) {
        var output = new ClassificationModel();
        BeanUtils.copyProperties(input, output);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(output));
    }

    @RequestMapping(value = "/classification/save", method = RequestMethod.PUT)
    public ResponseEntity<ClassificationModel> save(@RequestBody @Valid ChangeClassificationDto input) {
        var output = new ClassificationModel();
        BeanUtils.copyProperties(input, output);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(output));
    }
}
