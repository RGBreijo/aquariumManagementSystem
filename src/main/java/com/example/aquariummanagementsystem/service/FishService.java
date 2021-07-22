package com.example.aquariummanagementsystem.service;

import com.example.aquariummanagementsystem.model.Fish;
import com.example.aquariummanagementsystem.repository.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FishService
{
    private final FishRepository fishRepository;

    @Autowired
    public FishService(FishRepository fishRepository)
    {
        this.fishRepository = fishRepository;
    }

    public Fish getQuantity(String name)
    {
        return fishRepository.findByName(name);
    }
}
