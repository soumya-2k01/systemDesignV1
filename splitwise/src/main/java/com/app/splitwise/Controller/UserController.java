package com.app.splitwise.Controller;

import com.app.splitwise.Model.UserRequest;
import com.app.splitwise.Service.UserService;
import com.app.splitwise.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserRequest userRequest) {
        userService.addUser(userRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/addFriends/{user_id}")
        public ResponseEntity addFriends(@PathVariable(value = "user_id") Integer userId, @RequestBody List<User> users) {
        userService.addFriends(userId, users);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
