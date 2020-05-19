package com.canmert.carlist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "carmodel")
public class CarModel {

    public CarModel() {
    }

    public CarModel(CarBrand brandId, String model) {
        this.brandId = brandId;
        this.model = model;
    }
    public CarModel(Long id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "brand_id")
    private CarBrand brandId;

    private String model;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarBrand getBrandId() {
        return this.brandId;
    }

    public void setBrandId(CarBrand brandId) {
        this.brandId = brandId;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", brandId='" + getBrandId() + "'" +
            ", model='" + getModel() + "'" +
            "}";
    }
   

}
