package com.library.mapper;

import com.library.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserMapper {

    public User convertEtoD (com.library.User user) {
        boolean bol=true;
        User userEntity = new User(user.getPseudo(), user.getPassword(), user.getSalt(), user.getMail(),user.getRole(), user.isDelete());
        if (user.getGender().equals("Homme")){
            userEntity.setGender(true);
        }
        else {
            userEntity.setGender(false);
        }
        userEntity.setId(user.getUserid());
        return userEntity;
    }

    public com.library.User convertDtoE (User user) {
        com.library.User userEntity = new com.library.User();

        userEntity.setUserid(user.getId());
        userEntity.setPseudo(user.getPseudo());
        userEntity.setPassword(user.getPassword());
        userEntity.setMail(user.getMail());
        userEntity.setRole(user.getRole());
        userEntity.setSalt(user.getSalt());
        userEntity.setDelete(user.isDelete());

        if (user.isGender()){
            userEntity.setGender("Homme");
        }
        else {
            userEntity.setGender("Femme");
        }

        return userEntity;
    }

    public List<com.library.User> userListDtoE(List<User> userData) {

        List<com.library.User> usersE = new ArrayList<>();

        for (User anUserData : userData) {
            com.library.User user = convertDtoE(anUserData);
            usersE.add(user);
        }
        return usersE;
    }

    public List<User> userListEtoD(List<com.library.User> userEntity) {

        List<User> usersD = new ArrayList<>();

        for (com.library.User anUserEntity : userEntity) {
            User user = convertEtoD(anUserEntity);
            usersD.add(user);
        }
        return usersD;
    }
}
