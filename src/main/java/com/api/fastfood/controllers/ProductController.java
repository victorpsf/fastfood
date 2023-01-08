package com.api.fastfood.controllers;

import com.api.fastfood.dtos.Pagination;
import com.api.fastfood.dtos.Products.CreateProductDto;
import com.api.fastfood.dtos.Products.GetProductDto;
import com.api.fastfood.models.ProductModel;
import com.api.fastfood.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {
    final ProductService service;

    public ProductController(ProductService _service) { this.service = _service; }

    @RequestMapping(value = "/product/get", method = RequestMethod.POST)
    public ResponseEntity<List<ProductModel>> get(@RequestBody Pagination<GetProductDto> input) {
        if (input.getModel() == null) input.setModel(new GetProductDto());
        return ResponseEntity.status(HttpStatus.OK).body(this.service.get(input));
    }

    @RequestMapping(value = "/product/create", method = RequestMethod.POST)
    public ResponseEntity<ProductModel> save(@RequestBody @Valid CreateProductDto input) {
        var output = new ProductModel();
        BeanUtils.copyProperties(input, output);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(output, input.getClassifications()));
    }
}
