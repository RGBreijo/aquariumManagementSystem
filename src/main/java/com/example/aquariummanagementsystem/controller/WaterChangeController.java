package com.example.aquariummanagementsystem.controller;

import com.example.aquariummanagementsystem.model.WaterChange;
import com.example.aquariummanagementsystem.service.WaterChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/{username}/aquariums/{aquariumName}/waterchanges")
public class WaterChangeController
{

    private final WaterChangeService waterChangeService;

    @Autowired
    public WaterChangeController(WaterChangeService waterChangeService)
    {
        this.waterChangeService = waterChangeService;
    }

    @GetMapping("/all")
    public List<WaterChange> waterChangeHistory(@PathVariable String username, @PathVariable String aquariumName)
    {
        return waterChangeService.getWaterChangeHistory(username, aquariumName);
    }

    @GetMapping("/{id}")
    public WaterChange getWaterChange(@PathVariable Long id)
    {
        return waterChangeService.getWaterChange(id);
    }

    @PostMapping
    public void saveWaterChange(@RequestBody WaterChange waterChange, @PathVariable String username, @PathVariable String aquariumName)
    {
         waterChangeService.saveWaterChange(username, aquariumName, waterChange);
    }

    @DeleteMapping("/{id}")
    public void deleteWaterChange(@PathVariable Long id)
    {
        waterChangeService.deleteWaterChange(id);
    }

    @PutMapping
    public void updateWaterChange(@RequestBody WaterChange waterChange)
    {
        waterChangeService.updateWaterChange(waterChange);
    }
}
