package com.example.aquariummanagementsystem.controller;

import com.example.aquariummanagementsystem.model.WaterChange;
import com.example.aquariummanagementsystem.service.WaterChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// set the next water change
// add a water change

@RestController
public class WaterChangeController
{

    private final WaterChangeService waterChangeService;

    @Autowired
    public WaterChangeController(WaterChangeService waterChangeService)
    {
        this.waterChangeService = waterChangeService;
    }

    @GetMapping("/{username}/aquariums/{aquariumName}/waterChange")
    List<WaterChange> waterChangeHistory(@PathVariable String username, @PathVariable String aquariumName)
    {
        return waterChangeService.getWaterChangeHistory(username, aquariumName);
    }

    @PostMapping("/{username}/aquariums/{aquariumName}/waterChange")
    void saveWaterChange(@RequestBody WaterChange waterChange, @PathVariable String username, @PathVariable String aquariumName)
    {
         waterChangeService.saveWaterChange(username, aquariumName, waterChange);
    }


}