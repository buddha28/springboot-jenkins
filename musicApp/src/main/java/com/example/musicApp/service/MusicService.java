package com.example.musicApp.service;

import com.example.musicApp.model.User;
import com.example.musicApp.repository.UserRepository;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import java.util.*;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.Optional;

@Service
public class MusicService {
    @Autowired
    private UserRepository repo;
    private Object Iterable;
    //private Object Integer;

    public User add(User user) {
        User savedUser1 = repo.save(user);
        return savedUser1;

    }

    public User get(int id) {
        Optional<User> displayUser = repo.findById(id);
        return displayUser.get();
    }

    public List<User> getAll(){
    List<User> user=new ArrayList<>();
        Iterable<User> displayAll = repo.findAll();
        Iterator<User> iterator = displayAll.iterator();
        while(iterator.hasNext()){
            user.add(iterator.next());
        }
        System.out.println(displayAll);
        return user ;
    }
    public User update(User user){
       // int id=user.getTrack_id();

        User updatedUser = repo.save(user);
        return updatedUser;


    }
     public String deleteId(int id){
         repo.deleteById( id);
          return "deleted ";

     }

}
