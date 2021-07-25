package com.example.aquariummanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class WaterChange
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     private Date waterChanged;

    @JsonIgnore
    @ManyToOne
    private Aquarium aquarium;



    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Date getWaterChanged()
    {
        return waterChanged;
    }

    public void setWaterChanged(Date waterChanced)
    {
        this.waterChanged = waterChanced;
    }

    public Aquarium getAquarium()
    {
        return aquarium;
    }

    public void setAquarium(Aquarium aquarium)
    {
        this.aquarium = aquarium;
    }
}
