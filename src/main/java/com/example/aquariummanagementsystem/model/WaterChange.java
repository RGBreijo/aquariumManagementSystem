package com.example.aquariummanagementsystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class WaterChange
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate waterChanced;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public LocalDate getWaterChanced()
    {
        return waterChanced;
    }

    public void setWaterChanced(LocalDate waterChanced)
    {
        this.waterChanced = waterChanced;
    }
}
