package com.example.aquariummanagementsystem.service;

import com.example.aquariummanagementsystem.model.Aquarium;
import com.example.aquariummanagementsystem.model.User;
import com.example.aquariummanagementsystem.model.WaterTest;
import com.example.aquariummanagementsystem.repository.AquariumRepository;
import com.example.aquariummanagementsystem.repository.UserRepository;
import com.example.aquariummanagementsystem.repository.WaterTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class WaterTestService
{
    private final WaterTestRepository waterTestRepository;
    private final UserRepository userRepository;
    private final AquariumRepository aquariumRepository;


    @Autowired
    public WaterTestService(WaterTestRepository waterTestRepository, UserRepository userRepository, AquariumRepository aquariumRepository)
    {
        this.waterTestRepository = waterTestRepository;
        this.userRepository = userRepository;
        this.aquariumRepository = aquariumRepository;
    }



    public List<WaterTest> getWaterTestHistory(String username, String aquariumName)
    {
        User user = userRepository.findByUsername(username);

        if(user != null)
        {
            Aquarium aquarium = aquariumRepository.findByUserAndName(user, aquariumName);

            if(aquarium != null)
            {
                return aquarium.getWaterTests();
            }
        }
            return null;
    }

    public WaterTest getWaterTest(Date date)
    {
        return waterTestRepository.findByConductedOn(date);
    }


    public void saveWaterTest(WaterTest waterTest, String username, String aquariumName)
    {
        User user = userRepository.findByUsername(username);

        if(user != null)
        {
            Aquarium aquarium = aquariumRepository.findByUserAndName(user, aquariumName);

            if(aquarium != null)
            {
                aquarium.getWaterTests().add(waterTest);
                waterTest.setAquarium(aquarium);

                aquariumRepository.save(aquarium);
                waterTestRepository.save(waterTest);
            }
        }
    }
}
