package com.dev.journalApp.controller;

import com.dev.journalApp.entity.JournalEntry;
import com.dev.journalApp.entity.User;
import com.dev.journalApp.repository.UserRepository;
import com.dev.journalApp.service.JournalEntryService;
import com.dev.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.saveEntry(user);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        User userInDB = userService.findByUserName(user.getUserName());
        if(userInDB != null){
            userInDB.setPassword(user.getPassword());
            userInDB.setUserName(user.getUserName());
            userService.saveEntry(userInDB);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

