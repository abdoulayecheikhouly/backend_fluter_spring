package com.sn.dev.backend.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import java.util.List;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductSize {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  String name;
    @OneToMany(mappedBy = "productSize")
    private List<Stock> stocks;


    public Long getId() {
        return id;
    }
}
