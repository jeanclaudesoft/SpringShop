package com.claudylab.shop.services;

import com.claudylab.shop.models.User;
import com.claudylab.shop.models.MyUserDetails;
import com.claudylab.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public MyUserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyUserDetails::new).get();
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public List<User> usersList(){
        return userRepository.findAll();
    }


    public void deleteUser(int categoryId){
        userRepository.deleteById(categoryId);
    }

}