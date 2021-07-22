package com.example.aquariummanagementsystem.repository;

import com.example.aquariummanagementsystem.model.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishRepository extends JpaRepository<Fish, Long>
{
    Fish findByName(String name);
}
