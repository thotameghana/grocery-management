package com.project.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.ProductRepository;
import com.project.model.Product;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public Product addProduct(Product product) {
        if (product.getProductName() == null || product.getProductName().trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        return productRepo.save(product);
    }

    public Product updateProduct(int id, Product updatedProduct) {
        Product existing = productRepo.findById(id).orElseThrow();
        existing.setPrice(updatedProduct.getPrice());
        existing.setStockQuantity(updatedProduct.getStockQuantity());
        return productRepo.save(existing);
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }
    
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

}
