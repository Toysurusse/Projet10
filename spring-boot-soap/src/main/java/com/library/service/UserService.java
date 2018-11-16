package com.library.service;

import com.library.User;
import com.library.mapper.UserMapper;
import com.library.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<com.library.User> findAll() {
        LOGGER.info("User Service : findall");
        return userMapper.userListDtoE((List<com.library.entity.User>) userRepository.findAll());
    }

    @Override
    public com.library.User control(com.library.User user){
        LOGGER.info("User Service : control");
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
        LOGGER.info("User Service : add");
        userRepository.save(userMapper.convertEtoD(user));
        return "Ok";
    }

    @Override
    public void delete(com.library.User user) {
        LOGGER.info("User Service : delete / User.isDelete : "+ user.isDelete());
        this.add(user);
    }

    @Override
    public com.library.User findById(int id) {
        LOGGER.info("User Service : findById");
        return userMapper.convertDtoE(userRepository.findOne(id));
    }
}
