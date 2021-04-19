package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="territories")
public class Territory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TerritoryID")
    private int id;
    @Column(name = "territoryDescription")
    private String description;

}
