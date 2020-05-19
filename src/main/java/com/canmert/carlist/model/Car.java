package com.canmert.carlist.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "car")
public class Car {

    public Car(){}

    public Car(CarBrand brand, CarModel model, int year, String transmission) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.transmission = transmission;
    }
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private CarBrand brand;
    @OneToOne 
    private CarModel model;

    @Column(nullable = true)
    private int year;

    @Column(nullable = true)
    private String transmission;


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

    public CarModel getModel() {
        return this.model;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTransmission() {
        return this.transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
    

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", brand='" + getBrand() + "'" +
            ", model='" + getModel() + "'" +
            ", year='" + getYear() + "'" +
            ", transmission='" + getTransmission() + "'" +
            "}";
    }
    

}
