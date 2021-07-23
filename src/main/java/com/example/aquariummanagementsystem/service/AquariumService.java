package com.example.aquariummanagementsystem.service;

import com.example.aquariummanagementsystem.model.Aquarium;
import com.example.aquariummanagementsystem.model.User;
import com.example.aquariummanagementsystem.repository.AquariumRepository;
import com.example.aquariummanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AquariumService
{
    private final AquariumRepository aquariumRepository;
    private final UserRepository userRepository;


    public AquariumService(AquariumRepository aquariumRepository, UserRepository userRepository)
    {
        this.aquariumRepository = aquariumRepository;
        this.userRepository = userRepository;
    }

    public void createAquarium(Aquarium aquarium, String username)
    {
        User user = userRepository.findByUsername(username);
        if(user != null)
        {
            user.getAquariums().add(aquarium);
            aquarium.setUser(user);

            userRepository.save(user);
            aquariumRepository.save(aquarium);
            System.out.println("Inside");
        }
        System.out.println("Outside");
    }
}
