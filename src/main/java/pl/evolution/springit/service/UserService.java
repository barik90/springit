package pl.evolution.springit.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.evolution.springit.domain.Role;
import pl.evolution.springit.domain.User;
import pl.evolution.springit.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleService roleService;
    private final MailService mailService;

    public UserService(UserRepository userRepository, RoleService roleService, MailService mailService) {

        this.userRepository = userRepository;
        this.roleService = roleService;
        this.mailService = mailService;
        encoder = new BCryptPasswordEncoder();
    }

    public User register(User user){
        //take the password from the form and encode
        String secret = "{bcypt}" + encoder.encode(user.getPassword());
        user.setPassword(secret);

        //confirm password
        user.setConfirmPassword(secret);

        //assign a role to this user
        user.addRole(roleService.findByname("ROLE_USER"));

        //set an activatio code
        String uuid = UUID.randomUUID().toString();
        user.setActivationCode(uuid);
        System.out.println("uuid" + uuid);
        //disable the user

        //save user
        save(user);

        //send the activation email
        sendActivationEmail(user);

        //return user
        return user;
    }

    public User save(User user){
        return userRepository.save(user);
    }

    @Transactional
    public void saveUsers(User... users){
        for(User user : users){
            logger.info("Saving User: " + user.getEmail());
            userRepository.save(user);
        }
    }

    public void sendActivationEmail(User user){
        mailService.sendActivationEmail(user);
    }

    public void sendWelcomeEmail(User user){
        mailService.sendWelcomeEmail(user);
    }

    public Optional<User> findByEmailAndActivationCode(String email, String activationCode){
        return userRepository.findByEmailAndActivationCode(email, activationCode);
    }
}
