package com.example.demo.model;
import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product extends BaseModel<Product> {

    @Id
	private Integer id;

    @Column(name = "id_ref")
    private String uuid;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "inventory_id")
    private Integer inventoryId;

    @Column(name = "discount_id")
    private Integer discountId;

    @Column(name = "ref_desc")
    private String description;

    @Column(name = "ref_desc_en")
    private String descriptionEn;

    @Column(name = "photo")
    private String photo;

    @Column(name = "status")
    private Integer status;

    @Column(name = "price")
    private double price;

    @OneToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getInventoryId() {
        return this.inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getDiscountId() {
        return this.discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionEn() {
        return this.descriptionEn;
    }

    public void setDescriptionEn(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public Product updateWith(Product model) {
        Product updatedProduct = new Product();
        updatedProduct.setId(this.id);
        updatedProduct.setUuid(this.uuid);
        updatedProduct.setCategoryId(model.categoryId);
        updatedProduct.setInventoryId(model.inventoryId);
        updatedProduct.setDescription(model.description);
        updatedProduct.setDescriptionEn(model.descriptionEn);
        updatedProduct.setPrice(model.price);
        updatedProduct.setDiscountId(model.discountId);
        updatedProduct.setStatus(model.status);

        return updatedProduct;
    }

}
