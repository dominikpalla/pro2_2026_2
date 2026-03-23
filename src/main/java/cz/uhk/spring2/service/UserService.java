package cz.uhk.spring2.service;

import cz.uhk.spring2.model.User;
import cz.uhk.spring2.model.dto.UserBasicsDTO;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    void saveUser(User user);
    User getUser(long id);
    void deleteUser(long id);
    List<User> getAllUsers();

    UserBasicsDTO getDTObyEmail(String mail);
}
