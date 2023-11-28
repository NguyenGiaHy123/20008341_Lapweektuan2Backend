package com.example.nguyengiahy20008341labweektuan2.services;

import com.example.nguyengiahy20008341labweektuan2.models.IProductStatus;
import com.example.nguyengiahy20008341labweektuan2.models.Product;
import com.example.nguyengiahy20008341labweektuan2.repositories.OrderRespository;
import com.example.nguyengiahy20008341labweektuan2.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

public class ProductService {
    public ProductRepository productRepository;
    public ProductService(){
        this.productRepository=new ProductRepository();
    }
    public  boolean updateProduct(Product pd) {
        return productRepository.update(pd);
    }

    public boolean delete(long id) {
        Optional<Product> op =productRepository.findByID(Product.class,id);
        if (op.isPresent()) {
            Product product = op.get();
            product.setStatus(IProductStatus.TERMINATED);
            return true;
        }
        return false;

    }

    public Optional<Product> findByID(long id) {
        return productRepository.findByID(Product.class, id);
    }

    public boolean insert(Product product) {
        return productRepository.insert(product);
    }

    public List<Product> getGetProductsByKeyword(String key) {
        return productRepository.getProductsByKeyword(key);
    }

    public List<Product> getAllProduct() {
        return productRepository.getAllProduct();
    }

    public List<Product> getProductByPriceNewst() {
        return productRepository.getProductByPriceNewst();
    }
}
