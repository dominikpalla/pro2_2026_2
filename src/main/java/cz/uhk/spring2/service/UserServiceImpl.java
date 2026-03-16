package cz.uhk.spring2.service;

import cz.uhk.spring2.model.User;
import cz.uhk.spring2.model.dto.UserBasicsDTO;
import cz.uhk.spring2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(long id) {
        User u = getUser(id);
        if(u != null){
            userRepository.delete(u);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserBasicsDTO getDTObyEmail(String mail) {
        return userRepository.findByEmail(mail);
    }
}
