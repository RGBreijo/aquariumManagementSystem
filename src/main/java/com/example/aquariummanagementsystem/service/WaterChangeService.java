package com.example.aquariummanagementsystem.service;

import com.example.aquariummanagementsystem.model.Aquarium;
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
    private final UserService userService;
    private final AquariumService aquariumService;

    @Autowired
    public WaterChangeService(WaterChangeRepository waterChangeRepository, UserService userService, AquariumService aquariumService)
    {
        this.waterChangeRepository = waterChangeRepository;
        this.userService = userService;
        this.aquariumService = aquariumService;
    }

    public void saveWaterChange(String username, String aquariumName, WaterChange waterChange)
    {
        User user = userService.findByUsername(username);
        if(user != null)
        {
            Aquarium aquarium = aquariumService.findByUserAndName(user, aquariumName);
            if(aquarium != null)
            {
                aquarium.getWaterChanges().add(waterChange); // do I need to save it or is it saved without it?
                waterChange.setAquarium(aquarium);
                aquariumService.save(aquarium);
                waterChangeRepository.save(waterChange);
            }
        }
    }

    public List<WaterChange> getWaterChangeHistory(String username, String aquariumName)
    {
        User user = userService.findByUsername(username);
        if(user != null)
        {
            Aquarium aquarium = aquariumService.findByUserAndName(user, aquariumName);
            if(aquarium != null)
            {
                return waterChangeRepository.findAllByAquarium(aquarium);
            }
        }
        return null;
    }
}
