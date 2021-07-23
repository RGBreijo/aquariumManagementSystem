package com.example.aquariummanagementsystem.controller;

import com.example.aquariummanagementsystem.model.WaterTest;
import com.example.aquariummanagementsystem.service.WaterTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class WaterTestController
{
    private final WaterTestService waterTestService;


    @Autowired
    public WaterTestController(WaterTestService waterTestService)
    {
        this.waterTestService = waterTestService;
    }

    @PostMapping ("/{username}/aquariums/{aquariumName}/watertests")
    public void saveWaterTest(@RequestBody WaterTest waterTest, @PathVariable String username, @PathVariable String aquariumName)
    {
        waterTestService.saveWaterTest(waterTest, username, aquariumName);
    }

    @GetMapping("/{username}/aquariums/{aquariumName}/watertests")
    public List<WaterTest> getAllWaterTest(@PathVariable String username, @PathVariable String aquariumName)
    {
        return waterTestService.getWaterTestHistory(username, aquariumName);
    }



    // username/watertests/1
}
