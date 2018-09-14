package com.javainuse.mapper;

import com.javainuse.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapper {

    public User convertEtoD (com.javainuse.User user) {
        User userEntity = new User(user.getPseudo(), user.getPassword(), user.getSalt(), user.getMail(),user.getRole());
        if (user.getGender().equals("Homme")){
            userEntity.setGender(true);
        }
        else {
            userEntity.setGender(false);
        }
        userEntity.setId(user.getUserid());
        return userEntity;
    }

    public com.javainuse.User convertDtoE (User user) {
        com.javainuse.User userEntity = new com.javainuse.User();

        userEntity.setUserid(user.getId());
        userEntity.setPseudo(user.getPseudo());
        userEntity.setPassword(user.getPassword());
        userEntity.setMail(user.getMail());
        userEntity.setRole(user.getRole());
        userEntity.setSalt(user.getSalt());

        if (user.isGender()){
            userEntity.setGender("Homme");
        }
        else {
            userEntity.setGender("Femme");
        }

        return userEntity;
    }

    public List<com.javainuse.User> userListDtoE(List<User> userData) {

        List<com.javainuse.User> usersE = new ArrayList<>();

        for (int i = 0; i < userData.size(); i++) {
            com.javainuse.User user =convertDtoE(userData.get(i));
            usersE.add(user);
        }
        return usersE;
    }

    public List<User> userListEtoD(List<com.javainuse.User> userEntity) {

        List<User> usersD = new ArrayList<>();

        for (int i = 0; i < userEntity.size(); i++) {
            User user = user=convertEtoD(userEntity.get(i));
            usersD.add(user);
        }
        return usersD;
    }
}
