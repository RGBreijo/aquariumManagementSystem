package com.example.aquariummanagementsystem.repository;

import com.example.aquariummanagementsystem.model.Aquarium;
import com.example.aquariummanagementsystem.model.WaterChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WaterChangeRepository extends JpaRepository<WaterChange, Long>
{
    List<WaterChange> findAllByAquarium(Aquarium aquarium);
}
