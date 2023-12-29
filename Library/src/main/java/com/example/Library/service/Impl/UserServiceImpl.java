package com.example.Library.service.Impl;

import com.example.Library.dto.UserDto;
import com.example.Library.model.Users;
import com.example.Library.repository.UserRepository;
import com.example.Library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Users findByAccount(String username, String password) {
        Users user = userRepository.findByUsername(username);
        if (user == null) {
            return null;
        }

        String passEncode = user.getPassword();
        if (passwordEncoder.matches(password, passEncode)) {
            return user;
        } else {
            return null;
        }
    }


    @Override
    public Users addUser(UserDto userDto) throws ParseException {
        long dateNow = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(dateNow);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Users user = new Users();
        user.setFullname(userDto.getFullname());
        user.setAddress(userDto.getAddress());
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());
        user.setBirthdate(dateFormat.parse(userDto.getBirthdate()));
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setCreate_time(timestamp);
        return userRepository.save(user);
    }

    @Override
    public Users getEmailByUserName(String name) {
        return userRepository.findEmailByUsername(name);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Users> findEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Timestamp convertToDate(String date){
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dateObject = inputFormat.parse(date);
            Timestamp timestamp = new Timestamp(dateObject.getTime());
            return timestamp;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
