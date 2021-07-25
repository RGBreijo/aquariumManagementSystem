package com.example.aquariummanagementsystem.controller;

import com.example.aquariummanagementsystem.model.Fish;
import com.example.aquariummanagementsystem.model.WaterTest;
import com.example.aquariummanagementsystem.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FishController
{
    private final FishService fishService;

    @Autowired
    public FishController(FishService fishService)
    {
        this.fishService = fishService;
    }

    @PostMapping("/{username}/aquariums/{aquariumName}/fish")
    public void saveWaterTest(@RequestBody Fish fish, @PathVariable String username, @PathVariable String aquariumName)
    {
        fishService.saveFish(username, aquariumName, fish);
    }
}
