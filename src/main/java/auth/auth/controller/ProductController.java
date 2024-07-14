package auth.auth.controller;

import auth.auth.domain.product.Product;
import auth.auth.domain.product.ProductDTO;
import auth.auth.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository repository;
    @GetMapping
    public ResponseEntity getAllProduct() {
        List< Product> productList = repository.findAll();
        return ResponseEntity.ok(productList);
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid ProductDTO body) {
        Product newProduct = new Product(body);

        repository.save(newProduct);
        return ResponseEntity.ok().build();

    }

}
