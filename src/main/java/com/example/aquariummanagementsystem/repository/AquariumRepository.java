package com.example.aquariummanagementsystem.repository;

import com.example.aquariummanagementsystem.model.Aquarium;
import com.example.aquariummanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AquariumRepository extends JpaRepository<Aquarium, Long>
{
    Aquarium findByName(String name);

    Aquarium findByUser(User user);

    Aquarium findByUserAndName(User user, String name);
}
