package com.example.nguyengiahy20008341labweektuan2.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private long id;
    @Column(length = 200,nullable = false)
    private String name;
    @Column(length = 300,nullable = false)
    private String description;
    @Column(length = 20,nullable = false)
    private String unit;
    @Column(name="manufacturer_name",length = 50,nullable = false)
    private String manufacturer;
    @Column(nullable = false,columnDefinition = "int")
    private IProductStatus status;
    @OneToMany(mappedBy = "product")
    private List<ProductImage> productImages;

    public Product(long id, String name, String description, String unit, String manufacturer, IProductStatus status, List<ProductImage> productImages) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.unit = unit;
        this.manufacturer = manufacturer;
        this.status = status;
        this.productImages = productImages;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public IProductStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", status=" + status +
                ", productImages=" + productImages +
                '}';
    }

    public void setStatus(IProductStatus status) {
        this.status = status;
    }

    public List<ProductImage> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        this.productImages = productImages;
    }


}
