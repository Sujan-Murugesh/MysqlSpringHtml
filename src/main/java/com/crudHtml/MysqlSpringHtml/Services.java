package com.crudHtml.MysqlSpringHtml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class Services {
    @Autowired
    private UserRepository userRepo;

    public List<User> getAllUsers(){
       return (List<User>) userRepo.findAll();
    }

    public void addUser(User u) {
        userRepo.save(u);
    }

    public void delete(int id) {
        userRepo.deleteById(id);
    }

    public User get(int id) {
        return userRepo.findById(id).get();
    }
}
