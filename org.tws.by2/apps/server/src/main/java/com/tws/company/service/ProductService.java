package com.tws.company.service;

import com.tws.company.domain.Product;
import com.tws.company.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends AbstractUuidCrudService<Product> {

    public ProductService(ProductRepository repository) {
        super(repository);
    }
}
