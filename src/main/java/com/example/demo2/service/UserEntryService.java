package com.example.demo2.service;

import com.example.demo2.entity.User;
import com.example.demo2.repository.UserEntryRepo;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class UserEntryService {

    @Autowired
    private UserEntryRepo userEntryRepo;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//    private static final Logger logger = LoggerFactory.getLogger(UserEntryService.class);

    public boolean saveNewUser(User user){
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userEntryRepo.save(user);
            log.info("User created successfully");
            return true;
        }
        catch (Exception e){
            log.error("{} is already created",user.getUserName());
            return false;
        }
    }

    public void saveUser(User user){
        userEntryRepo.save(user);
    }


    public List<User> getAll(){
        return userEntryRepo.findAll();
    }

    public Optional<User> findById(ObjectId id) {
        return userEntryRepo.findById(id);
    }

    public void deleteById(ObjectId id) {
        userEntryRepo.deleteById(id);
    }

    public User findByUserName(String userName) {
        return userEntryRepo.findByUserName(userName);
    }


    public void createAdmin(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        userEntryRepo.save(user);
    }

}
