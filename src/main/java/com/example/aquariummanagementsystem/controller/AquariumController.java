package com.example.aquariummanagementsystem.controller;

import com.example.aquariummanagementsystem.model.Aquarium;
import com.example.aquariummanagementsystem.service.AquariumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AquariumController
{
    private final AquariumService aquariumService;

    @Autowired
    public AquariumController(AquariumService aquariumService)
    {
        this.aquariumService = aquariumService;
    }

    @PostMapping("{username}/aquarium")
    public void createAquarium(@RequestBody Aquarium aquarium, @PathVariable String username)
    {
        aquariumService.createAquarium(aquarium, username);
    }
}
