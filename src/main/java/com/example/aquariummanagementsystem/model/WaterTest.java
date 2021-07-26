package com.example.aquariummanagementsystem.model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class WaterTest
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Aquarium aquarium;

    private Date conductedOn;

    private Double nitrateLvl;
    private Double nitriteLvl;
    private Double ammoniaLvl;
    private Double phLvl;


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Date getConductedOn()
    {
        return conductedOn;
    }

    public void setConductedOn(Date conducted)
    {
        this.conductedOn = conducted;
    }

    public Double getNitrateLvl()
    {
        return nitrateLvl;
    }

    public void setNitrateLvl(Double nitrateLvl)
    {
        this.nitrateLvl = nitrateLvl;
    }

    public Double getNitriteLvl()
    {
        return nitriteLvl;
    }

    public void setNitriteLvl(Double nitriteLvl)
    {
        this.nitriteLvl = nitriteLvl;
    }

    public Double getAmmoniaLvl()
    {
        return ammoniaLvl;
    }

    public void setAmmoniaLvl(Double ammoniaLvl)
    {
        this.ammoniaLvl = ammoniaLvl;
    }

    public Double getPhLvl()
    {
        return phLvl;
    }

    public void setPhLvl(Double phLvl)
    {
        this.phLvl = phLvl;
    }

    public void setAquarium(Aquarium user)
    {
        this.aquarium = user;
    }

    @Override
    public String toString()
    {
        return "WaterTest{" +
                "id=" + id +
                ", conductedOn=" + conductedOn +
                ", nitrateLvl=" + nitrateLvl +
                ", nitriteLvl=" + nitriteLvl +
                ", ammoniaLvl=" + ammoniaLvl +
                ", phLvl=" + phLvl +
                '}';
    }
}
