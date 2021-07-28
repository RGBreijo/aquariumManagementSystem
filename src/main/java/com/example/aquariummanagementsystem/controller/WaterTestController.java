package com.example.aquariummanagementsystem.controller;

import com.example.aquariummanagementsystem.model.WaterTest;
import com.example.aquariummanagementsystem.service.WaterTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/{username}/aquariums/{aquariumName}/watertests")
public class WaterTestController
{
    private final WaterTestService waterTestService;


    @Autowired
    public WaterTestController(WaterTestService waterTestService)
    {
        this.waterTestService = waterTestService;
    }

    @PostMapping
    public void saveWaterTest(@RequestBody WaterTest waterTest, @PathVariable String username, @PathVariable String aquariumName)
    {
        waterTestService.saveWaterTest(waterTest, username, aquariumName);
    }

    @GetMapping("/all")
    public List<WaterTest> getAllWaterTest(@PathVariable String username, @PathVariable String aquariumName)
    {
        return waterTestService.getWaterTestHistory(username, aquariumName);
    }

    @GetMapping("/{id}}")
    public WaterTest getWaterTest(@PathVariable Long id)
    {
        return waterTestService.getWaterTest(id);
    }

    @PutMapping 
    public void updateWaterTest(@RequestBody WaterTest waterTest)
    {
        waterTestService.updateWaterTest(waterTest);
    }

    @DeleteMapping("/{id}")
    public void deleteWaterTest(@PathVariable Long id)
    {
        waterTestService.deleteWaterTest(id);
    }

}
