package com.course.tech_services.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@Valid
public class ServiceDTO {

    @JsonProperty("id")
    @Positive
    long id;
    @JsonProperty("name")
    String name;
    @JsonProperty("description")
    String description;
    @JsonProperty("price")
    @Positive
    Double price;

    public ServiceDTO(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null) {
            this.name = name;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description != null) {
            this.description = description;
        }
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        if(price != null) {
            this.price = price;
        }
    }
}
