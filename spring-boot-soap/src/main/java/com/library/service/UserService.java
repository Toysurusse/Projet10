package com.library.service;

import com.library.User;
import com.library.mapper.UserMapper;
import com.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<com.library.User> findAll() {
        List<com.library.User> obj = userMapper.userListDtoE((List<com.library.entity.User>) userRepository.findAll());
        return obj;
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
        String result="Ok";

            userRepository.save(userMapper.convertEtoD(user));

        return result;
    }

    @Override
    public void delete(com.library.User user) {
        userRepository.delete(userMapper.convertEtoD(user));
    }

    @Override
    public com.library.User findById(int id) {
        com.library.User obj = userMapper.convertDtoE(userRepository.findOne(id));
        return obj;
    }
}
