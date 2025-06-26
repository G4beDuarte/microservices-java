package br.edu.atitus.product_service.dtos;

public record ProductDTO(
        String description_product,
        String brand_product,
        String model_product,
        String currency_product,
        double price_product,
        String imageUrl) {
}
