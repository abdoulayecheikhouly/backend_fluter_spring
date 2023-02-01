package com.sn.dev.backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.minidev.json.annotate.JsonIgnore;
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
public class Category {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private  String name;
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Article> articles;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
