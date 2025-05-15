package br.edu.atitus.product_service.controllers;


import br.edu.atitus.product_service.entities.ProductEntity;
import br.edu.atitus.product_service.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class OpenProductController {

    private final ProductRepository repository;

    @Value("${server.port}")
    private String port;

    public OpenProductController(ProductRepository repository) {
        super();
        this.repository = repository;
    }

    @GetMapping("/{idProduct}/{targetCurrency}")
    public ProductEntity getProductById(
            @PathVariable long idProduct,
            @PathVariable String targetCurrency) {
        Optional<ProductEntity> productOpt = repository.findById(idProduct);
        if (productOpt.isEmpty()) {
            throw new RuntimeException("Produto não encontrado");
        }

        ProductEntity product = productOpt.get();
        product.setConvertedPrice(product.getPrice());
        product.setEnvironment("Product-Service rodando na porta " + port);
        return product;
    }

}
