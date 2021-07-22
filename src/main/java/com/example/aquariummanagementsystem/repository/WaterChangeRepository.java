package com.example.aquariummanagementsystem.repository;

import com.example.aquariummanagementsystem.model.WaterChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WaterChangeRepository extends JpaRepository<WaterChange, Long>
{
}
