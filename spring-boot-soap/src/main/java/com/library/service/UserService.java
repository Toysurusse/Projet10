package com.library.service;

import com.library.User;
import com.library.entity.Shoppinglist;
import com.library.mapper.UserMapper;
import com.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<com.library.User> findAll() {
        return userMapper.userListDtoE((List<com.library.entity.User>) userRepository.findAll());
    }

    @Override
    public com.library.User control(com.library.User user){
        List<com.library.User> userList = userMapper.userListDtoE((List<com.library.entity.User>) userRepository.findAll());

        User test= new User();

        for (int i=0;i<userList.size();i++){
            if(user.getPseudo().equals(userList.get(i).getPseudo())){
                test=userList.get(i);
            }
        }
        return test;
    }

    @Override
    public String add(com.library.User user) {
        userRepository.save(userMapper.convertEtoD(user));
        return "Ok";
    }

    @Override
    public void delete(com.library.User user) {
        this.add(user);
    }

    @Override
    public com.library.User findById(int id) {
        return optional(userRepository.findById(id));
    }

    private com.library.User optional(Optional<com.library.entity.User> book){
        com.library.entity.User userById=new com.library.entity.User(null,null,null,null,0,false);
        if (book.isPresent()){
            userById=book.get();
        }
        return userMapper.convertDtoE(userById);
    }
}
