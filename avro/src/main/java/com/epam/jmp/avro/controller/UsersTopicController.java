package com.epam.jmp.avro.controller;

import com.epam.jmp.avro.User;
import com.epam.jmp.avro.producer.UserProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersTopicController {
    @Autowired
    private UserProducer userProducer;

    @PostMapping
    public void sendMessageToTopic(@RequestParam String name, @RequestParam int age) {
        userProducer.sendMessage(new User(name, age));
    }
}
