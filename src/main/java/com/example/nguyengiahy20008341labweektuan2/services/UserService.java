package com.example.nguyengiahy20008341labweektuan2.services;

import com.example.nguyengiahy20008341labweektuan2.models.User;
import com.example.nguyengiahy20008341labweektuan2.repositories.UserRepository;

public class UserService {
    public UserRepository userRepository;
    public UserService(){
        this.userRepository=new UserRepository();
    }

    public boolean insertUser(User user){
        return userRepository.insert(user);

   }
}
