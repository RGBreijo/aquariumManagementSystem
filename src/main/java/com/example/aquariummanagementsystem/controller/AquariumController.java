package com.example.aquariummanagementsystem.controller;

import com.example.aquariummanagementsystem.model.Aquarium;
import com.example.aquariummanagementsystem.service.AquariumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AquariumController
{
    private final AquariumService aquariumService;

    @Autowired
    public AquariumController(AquariumService aquariumService)
    {
        this.aquariumService = aquariumService;
    }

    @PostMapping("{username}/aquarium")
    public ResponseEntity<?> createAquarium(@RequestBody Aquarium aquarium, @PathVariable String username)
    {
        aquariumService.createAquarium(aquarium, username);
        return new ResponseEntity<> (HttpStatus.CREATED);
    }
}
