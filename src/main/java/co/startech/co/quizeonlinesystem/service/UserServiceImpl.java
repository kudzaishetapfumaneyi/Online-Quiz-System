//package co.startech.co.quizeonlinesystem.service;
//
//import co.startech.co.quizeonlinesystem.model.Roles;
//import co.startech.co.quizeonlinesystem.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import co.startech.co.quizeonlinesystem.repository.RoleRepository;
//import co.startech.co.quizeonlinesystem.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.Arrays;
//import java.util.HashSet;
//
//@Component
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    BCryptPasswordEncoder encoder;
//
//    @Autowired
//    RoleRepository roleRepository;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Override
//    public void saveUser(User user) {
//        user.setPassword(encoder.encode(user.getPassword()));
//        user.setStatus("VERIFIED");
//        Roles userRole = roleRepository.findByRole("SITE_USER");
//        user.setRoles(new HashSet<Roles>(Arrays.asList(userRole)));
//        userRepository.save(user);
//    }
//
//    @Override
//    public boolean isUserPresent(User user) {
//        boolean userExists = false;
//        User existingUser = userRepository.findByEmail(user.getEmail());
//        if(existingUser!=null){
//            userExists = true;
//        }
//        return userExists;
//    }
//
//
//}
