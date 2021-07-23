package com.example.aquariummanagementsystem.controller;

import com.example.aquariummanagementsystem.model.WaterTest;
import com.example.aquariummanagementsystem.service.WaterTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class WaterTestController
{
    private WaterTestService waterTestService;

    @Autowired
    public WaterTestController(WaterTestService waterTestService)
    {
        this.waterTestService = waterTestService;
    }

    @PostMapping("/{username}/watertests")
    public void saveWaterTest(@RequestBody WaterTest waterTest, @PathVariable String username)
    {
        System.out.println();
        waterTestService.saveWaterTest(waterTest, username);
    }

    @GetMapping("/{username}/watertests")
    public List<WaterTest> getAllWaterTest(@PathVariable String username)
    {
        return waterTestService.getWaterTestHistory(username);
    }



    // username/watertests/1
}
