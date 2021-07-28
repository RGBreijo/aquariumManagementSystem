package com.example.aquariummanagementsystem.controller;

import com.example.aquariummanagementsystem.model.Aquarium;
import com.example.aquariummanagementsystem.service.AquariumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("{username}/aquariums")
public class AquariumController
{
    private final AquariumService aquariumService;

    @Autowired
    public AquariumController(AquariumService aquariumService)
    {
        this.aquariumService = aquariumService;
    }

    @PostMapping
    public void createAquarium(@RequestBody Aquarium aquarium, @PathVariable String username)
    {
        aquariumService.createAquarium(aquarium, username);
    }

    @DeleteMapping("/{id}")
    public void deleteAquarium(@PathVariable Long id)
    {
        aquariumService.deleteAquarium(id);
    }

    @PutMapping()
    public void updateAquariumName(@RequestBody Aquarium aquarium) // include id, name
    {
        aquariumService.updateAquariumName(aquarium);
    }



}
