package com.example.aquariummanagementsystem.service;

import com.example.aquariummanagementsystem.model.Aquarium;
import com.example.aquariummanagementsystem.model.Fish;
import com.example.aquariummanagementsystem.model.User;
import com.example.aquariummanagementsystem.repository.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FishService
{
    private final FishRepository fishRepository;
    private final UserService userService;
    private final AquariumService aquariumService;

    @Autowired
    public FishService(FishRepository fishRepository, UserService userService, AquariumService aquariumService)
    {
        this.fishRepository = fishRepository;
        this.userService = userService;
        this.aquariumService = aquariumService;
    }

    public Fish getQuantity(String name)
    {
        return fishRepository.findByName(name);
    }

    public void saveFish(String username, String aquariumName, Fish fish)
    {
        User user = userService.findByUsername(username);
        if(user != null)
        {
            Aquarium aquarium = aquariumService.findByUserAndName(user, aquariumName);
            if(aquarium != null)
            {
                aquarium.getFish().add(fish);
                fish.setAquarium(aquarium);
                aquariumService.save(aquarium);
                fishRepository.save(fish);
            }
        }
    }


}
