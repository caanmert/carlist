package com.canmert.carlist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

    public CarModel(CarBrand brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    public CarModel(Long id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private CarBrand brand;

    private String model;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarBrand getBrand() {
        return this.brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
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
            ", brand='" + getBrand() + "'" +
            ", model='" + getModel() + "'" +
            "}";
    }
   

}
