package com.canmert.carlist.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name = "carbrand")
public class CarBrand {

    public CarBrand() {}

    public CarBrand(String brand) {
        this.brand = brand;
    }
    public CarBrand(Long id){
        this.id = id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = true)
    private String brand;

    @OneToMany(mappedBy = "brand") 
    private List<CarModel> models =  new ArrayList<CarModel>();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }



    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", brand='" + getBrand() + "'" + "}";
    }

}
