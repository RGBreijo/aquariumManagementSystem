package com.example.aquariummanagementsystem.repository;

import com.example.aquariummanagementsystem.model.User;
import com.example.aquariummanagementsystem.model.WaterTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface WaterTestRepository extends JpaRepository<WaterTest, Long>
{
    WaterTest findByConductedOn(LocalDate conductedOn);
    List<WaterTest> findAllByUser(User user);
}
