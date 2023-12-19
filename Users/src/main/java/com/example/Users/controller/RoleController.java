package com.example.Users.controller;

import com.example.Library.dto.RoleDto;
import com.example.Library.model.Role;
import com.example.Library.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping("/role")
    public String newRole(@RequestBody RoleDto roleDto) {
        Role role = roleService.newRole(roleDto);
        if(role == null) {
            return "Create new role fail!";
        }
        return "Create new role successful!";
    }
    @PostMapping("user/{userId}/role/{roleId}")
    public String addUserToRole(@PathVariable("userId") Long userId,
                                 @PathVariable("roleId") Long roleId) {
        String user = roleService.addUserToRoles(userId, roleId);
        return user;
    }
}
