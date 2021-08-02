package com.example.aquariummanagementsystem.service;

import com.example.aquariummanagementsystem.model.Aquarium;
import com.example.aquariummanagementsystem.model.User;
import com.example.aquariummanagementsystem.repository.AquariumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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



    public void updateAquariumName(Aquarium updatedAquarium)
    {
        Aquarium aquarium = aquariumRepository.findById(updatedAquarium.getId()).orElse(null);

        if(aquarium != null)
        {
            aquarium.setName(updatedAquarium.getName());
            aquariumRepository.save(aquarium);
        }

    }

    public void deleteAquarium(Long id)
    {
        aquariumRepository.deleteById(id);
    }

    public Aquarium getAquarium(Long id)
    {
        return aquariumRepository.findById(id).orElse(null);
    }

    public Aquarium findByUserAndName(User user, String aquariumName)
    {
        return aquariumRepository.findByUserAndName(user, aquariumName);
    }

    public List<Aquarium> getAllAquarium(String username)
    {
        User user = userService.findByUsername(username);
        if(user != null)
        {
           return aquariumRepository.findAllByUser(user);
        }

        return null;
    }

    public void save(Aquarium aquarium)
    {
        aquariumRepository.save(aquarium);
    }

}
