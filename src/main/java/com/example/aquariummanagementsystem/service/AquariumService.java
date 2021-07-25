package com.example.aquariummanagementsystem.service;

import com.example.aquariummanagementsystem.model.Aquarium;
import com.example.aquariummanagementsystem.model.User;
import com.example.aquariummanagementsystem.repository.AquariumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AquariumService
{
    private final AquariumRepository aquariumRepository;
    private final UserService userService;


    @Autowired
    public AquariumService(AquariumRepository aquariumRepository, UserService userService)
    {
        this.aquariumRepository = aquariumRepository;
        this.userService = userService;
    }

    public void createAquarium(Aquarium aquarium, String username)
    {
        User user = userService.findByUsername(username);
        if(user != null)
        {
            user.getAquariums().add(aquarium);
            aquarium.setUser(user);

            userService.save(user);
            aquariumRepository.save(aquarium);
        }
    }


    // if same id save overrides
    public void save(Aquarium aquarium)
    {
        aquariumRepository.save(aquarium);
    }

    public Aquarium findByUserAndName(User user, String aquariumName)
    {
        return aquariumRepository.findByUserAndName(user, aquariumName);
    }
}
