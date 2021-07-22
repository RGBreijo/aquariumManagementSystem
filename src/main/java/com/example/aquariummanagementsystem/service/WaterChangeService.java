package com.example.aquariummanagementsystem.service;

import com.example.aquariummanagementsystem.model.User;
import com.example.aquariummanagementsystem.model.WaterChange;
import com.example.aquariummanagementsystem.repository.UserRepository;
import com.example.aquariummanagementsystem.repository.WaterChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterChangeService
{
    private final WaterChangeRepository waterChangeRepository;
    private final UserRepository userRepository;

    @Autowired
    public WaterChangeService(WaterChangeRepository waterChangeRepository, UserRepository userRepository)
    {
        this.waterChangeRepository = waterChangeRepository;
        this.userRepository = userRepository;
    }

    public List<WaterChange> getWaterChangeHistory()
    {
        return waterChangeRepository.findAll();
    }
}
