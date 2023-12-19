package com.example.Library.service.Impl;

import com.example.Library.dto.RoleDto;
import com.example.Library.model.Role;
import com.example.Library.model.Users;
import com.example.Library.repository.RoleRepository;
import com.example.Library.repository.UserRepository;
import com.example.Library.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Optional<Role> findById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role;
    }

    @Override
    public Role newRole(RoleDto roleDto) {
        Role role = new Role();
        role.setName(roleDto.getName());
        return roleRepository.save(role);
    }

    @Override
    public String addUserToRoles(Long userId, Long roleId) {
        Optional<Users> userOptional = userRepository.findById(userId);
        Optional<Role> roleOptional = roleRepository.findById(roleId);

        if (userOptional.isPresent() && roleOptional.isPresent()) {
            Users user = userOptional.get();
            Role role = roleOptional.get();

            Collection<Role> roles = user.getRoles();
            if (!roles.contains(role)) {
                roles.clear();
                roles.add(role);
                userRepository.save(user);
                return "Add successful user role!";
            } else {
                // Role already exists for this user
                return "The role already exists for this user.";
            }
        }
        // Handle the case where either user or role is not found
        return "User or role not found.";
    }



    @Override
    public Role updateRole(Long id, RoleDto roleDto) {
        return null;
    }

    @Override
    public void deleteRole(Long id) {

    }

    @Override
    public List<Role> getAll() {
        return null;
    }
}
