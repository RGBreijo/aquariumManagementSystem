package com.example.aquariummanagementsystem.controller;

import com.example.aquariummanagementsystem.model.WaterTest;
import com.example.aquariummanagementsystem.service.WaterTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin
public class WaterTestController
{
    private final WaterTestService waterTestService;


    @Autowired
    public WaterTestController(WaterTestService waterTestService)
    {
        this.waterTestService = waterTestService;
    }

    @PostMapping ("/{username}/aquariums/{aquariumName}/watertests")
    public ResponseEntity<?> createWaterTest(@RequestBody WaterTest waterTest, @PathVariable String username, @PathVariable String aquariumName)
    {
        waterTestService.saveWaterTest(waterTest, username, aquariumName);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{username}/aquariums/{aquariumName}/watertests/all")
    public List<WaterTest> getAllWaterTest(@PathVariable String username, @PathVariable String aquariumName)
    {
        return waterTestService.getWaterTestHistory(username, aquariumName);
    }

    @GetMapping("/{username}/aquariums/{aquariumName}/watertests")
    public void getWaterTest(@RequestBody Date date, @PathVariable String username, @PathVariable String aquariumName)
    {
        waterTestService.getWaterTest(username, aquariumName, date);
    }

    @DeleteMapping("/{username}/aquariums/{aquariumName}/watertests")
    public void deleteWaterTest(@RequestBody Date date, @PathVariable String username, @PathVariable String aquariumName)
    {
       waterTestService.deleteWaterTest(username, aquariumName, date);
    }
}
