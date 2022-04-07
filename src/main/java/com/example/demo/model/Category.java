package com.example.demo.model;
import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseModel<Category> {

    @Id
	private Integer id;

    @Column(name = "id_ref")
    private String uuid;

    @Column(name = "ref_desc")
    private String description;

    @Column(name = "ref_desc_en")
    private String descriptionEn;

    @Column(name = "photo")
    private String photo;

    @Column(name = "status")
    private Integer status;


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

    @Override
    public Category updateWith(Category model) {
        Category updatedCategory = new Category();
        updatedCategory.setId(this.id);
        updatedCategory.setUuid(this.uuid);
        updatedCategory.setDescription(model.description);
        updatedCategory.setDescriptionEn(model.descriptionEn);
        updatedCategory.setPhoto(model.photo);
        updatedCategory.setStatus(model.status);

        return updatedCategory;
    }

}
