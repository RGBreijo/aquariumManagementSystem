package com.example.aquariummanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
public class Aquarium
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Aquarium()
    {
    }

    private String name;

    @OneToMany(mappedBy = "aquarium")
    private List<WaterTest> waterTests;

    @OneToMany(mappedBy = "aquarium")
    private List<Fish> fish;

    @OneToMany(mappedBy = "aquarium")
    private List<WaterChange> waterChanges;

    @JsonIgnore
    @ManyToOne
    private User user;


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public List<WaterTest> getWaterTests()
    {
        return waterTests;
    }

    public void setWaterTests(List<WaterTest> waterTests)
    {
        this.waterTests = waterTests;
    }

    public List<Fish> getFish()
    {
        return fish;
    }

    public void setFish(List<Fish> fish)
    {
        this.fish = fish;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public List<WaterChange> getWaterChanges()
    {
        return waterChanges;
    }

    public void setWaterChanges(List<WaterChange> waterChanges)
    {
        this.waterChanges = waterChanges;
    }
}
