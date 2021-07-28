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

    public void updateWaterTest(WaterTest updatedWaterTest)
    {
        WaterTest waterTest = waterTestRepository.findById(updatedWaterTest.getId()).orElse(null);

        if(waterTest != null)
        {
            // Not Ideal
            waterTest.setAmmoniaLvl(updatedWaterTest.getAmmoniaLvl());
            waterTest.setPhLvl(updatedWaterTest.getPhLvl());
            waterTest.setNitrateLvl(updatedWaterTest.getNitrateLvl());
            waterTest.setNitriteLvl(updatedWaterTest.getNitriteLvl());
            waterTest.setConductedOn(updatedWaterTest.getConductedOn());
            waterTestRepository.save(waterTest);
        }
//        waterTestRepository.save(updatedWaterTest);
    }

    public void deleteWaterTest(Long waterTestId)
    {
        waterTestRepository.deleteById(waterTestId);
    }


    public WaterTest getWaterTest(Long waterTestId)
    {
      return waterTestRepository.findById(waterTestId).orElse(null);
    }
}
