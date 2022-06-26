package com.turgayyilmaz.InterProbeHW1.controller;

import com.turgayyilmaz.InterProbeHW1.dao.UserDao;
import com.turgayyilmaz.InterProbeHW1.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserDao userDao;

    @PostMapping
    public User save(@RequestBody User user){
        return userDao.save(user);
    }

    @GetMapping
    public List<User> getAll(){
        return userDao.findAll();
    }
}
