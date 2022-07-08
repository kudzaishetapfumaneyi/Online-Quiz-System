package co.startech.co.quizeonlinesystem.service;

import co.startech.co.quizeonlinesystem.model.User;

public interface UserService {
    public void saveUser(User user);
    public boolean isUserPresent(User user);
}
