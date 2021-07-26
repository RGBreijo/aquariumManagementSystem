package com.example.aquariummanagementsystem.service;

import com.example.aquariummanagementsystem.model.Aquarium;
import com.example.aquariummanagementsystem.model.User;
import com.example.aquariummanagementsystem.model.WaterTest;
import com.example.aquariummanagementsystem.repository.WaterTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class WaterTestService
{
    private final WaterTestRepository waterTestRepository;
    private final UserService userService;
    private final AquariumService aquariumService;

    @Autowired
    public WaterTestService(WaterTestRepository waterTestRepository, UserService userService, AquariumService aquariumService)
    {
        this.waterTestRepository = waterTestRepository;
        this.userService = userService;
        this.aquariumService = aquariumService;
    }





    public List<WaterTest> getWaterTestHistory(String username, String aquariumName)
    {
        User user = userService.findByUsername(username);

        if(user != null)
        {
            Aquarium aquarium = aquariumService.findByUserAndName(user, aquariumName);

            if(aquarium != null)
            {
                return aquarium.getWaterTests();
            }
        }
            return null;
    }

    public void updateWaterTest(WaterTest waterTest, String username, String aquariumName)
    {
        User user = userService.findByUsername(username);

        if(user != null)
        {
            Aquarium aquarium = aquariumService.findByUserAndName(user, aquariumName);

            if(aquarium != null)
            {

                // find the water test
            }
        }
    }

    public void saveWaterTest(WaterTest waterTest, String username, String aquariumName)
    {
        User user = userService.findByUsername(username);

        if(user != null)
        {
            Aquarium aquarium = aquariumService.findByUserAndName(user, aquariumName);

            if(aquarium != null)
            {
                aquarium.getWaterTests().add(waterTest);
                waterTest.setAquarium(aquarium);

                aquariumService.save(aquarium);
                waterTestRepository.save(waterTest);
            }
        }
    }


    public void deleteWaterTest(String username, String aquariumName, Date date)
    {
        User user = userService.findByUsername(username);

        if(user != null)
        {
            Aquarium aquarium = aquariumService.findByUserAndName(user, aquariumName);
            if(aquarium != null && date != null)
            {
                waterTestRepository.deleteByConductedOnAndAquarium(date, aquarium);
            }
        }
    }

    public WaterTest getWaterTest(String username, String aquariumName, Date date)
    {
        User user = userService.findByUsername(username);

        if(user != null)
        {
            Aquarium aquarium = aquariumService.findByUserAndName(user, aquariumName);
            if(aquarium != null && date != null)
            {
                return waterTestRepository.findByConductedOnAndAquarium(date, aquarium);
            }
        }

        return null;
    }
}
