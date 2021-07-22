package com.example.aquariummanagementsystem.service;

import com.example.aquariummanagementsystem.model.User;
import com.example.aquariummanagementsystem.model.WaterTest;
import com.example.aquariummanagementsystem.repository.UserRepository;
import com.example.aquariummanagementsystem.repository.WaterTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class WaterTestService
{
    private final WaterTestRepository waterTestRepository;
    private final UserRepository userRepository;

    @Autowired
    public WaterTestService(WaterTestRepository waterChangeRepository, UserRepository userRepository)
    {
        this.waterTestRepository = waterChangeRepository;
        this.userRepository = userRepository;
    }


    public List<WaterTest> getWaterTestHistory(String username)
    {
        User user = userRepository.findByUsername(username); // test username not null

        return waterTestRepository.findAllByUser(user);
    }

    public WaterTest getWaterTest(LocalDate date)
    {
        return waterTestRepository.findByConductedOn(date);
    }


    public void saveWaterTest(WaterTest waterTest, String username)
    {
        User user = userRepository.findByUsername(username); // security make sure username matches

        if(user != null) // username.length() check?
        {
            user.getWaterTests().add(waterTest);
            waterTest.setUser(user);

            userRepository.save(user);
            waterTestRepository.save(waterTest);

        }else
        {
            System.out.println("User not found");
        }
    }

}
