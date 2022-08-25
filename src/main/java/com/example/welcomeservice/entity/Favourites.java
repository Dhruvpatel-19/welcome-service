package com.example.welcomeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Favourites {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favId;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToMany(targetEntity = Property.class , cascade = CascadeType.ALL)
    @JoinTable( name = "favourite_property" , joinColumns = { @JoinColumn(name = "favId") } ,  inverseJoinColumns = { @JoinColumn(name = "propertyId") } )
    private List<Property> properties;

}
