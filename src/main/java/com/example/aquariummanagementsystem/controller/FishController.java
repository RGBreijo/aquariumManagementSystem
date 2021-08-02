package com.example.aquariummanagementsystem.controller;

import com.example.aquariummanagementsystem.model.Fish;
import com.example.aquariummanagementsystem.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/{username}/aquariums/{aquariumName}/fish")
public class FishController
{
    private final FishService fishService;

    @Autowired
    public FishController(FishService fishService)
    {
        this.fishService = fishService;
    }

    @PostMapping
    public void saveWaterTest(@RequestBody Fish fish, @PathVariable String username, @PathVariable String aquariumName)
    {
        fishService.saveFish(username, aquariumName, fish);
    }

    @GetMapping("/all")
    public List<Fish> getAllFish(@PathVariable String username, @PathVariable String aquariumName)
    {
        return fishService.getAllFish(username, aquariumName);
    }


}
