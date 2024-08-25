package com.app.splitwise.Controller;

import com.app.splitwise.Service.GroupService;
import com.app.splitwise.entity.Group;
import com.app.splitwise.entity.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @PostMapping("/create/{user_id}")
    public ResponseEntity createGroup(@PathVariable(value = "user_id") Integer userId, @RequestBody Group group) {
        groupService.createGroup(userId, group);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addMembers")
    public ResponseEntity addMembersToGroup(@RequestParam(value = "group_id") Integer groupId,
                                                @RequestParam(value = "member_list")List<User> members) {
        groupService.addFriendsToGroup(groupId, members);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getMembers")
    public List<User> getMembersByGroup(@RequestParam(value = "group_id") Integer groupId) {
        return groupService.getFriendsOfGroup(groupId);
    }
}
