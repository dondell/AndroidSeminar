package com.dmj.newworld.model.user;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserRepository userRepository;
    private final LiveData<List<UserModel>> mAllUsers;

    public UserViewModel(@NonNull @NotNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        mAllUsers = userRepository.getAll();
    }

    public LiveData<List<UserModel>> getAllUsers() {
        return mAllUsers;
    }

    public void insert(UserModel userModel) {
        userRepository.insert(userModel);
    }

    public void update(UserModel userModel) {
        userRepository.update(userModel);
    }

    public void delete(UserModel userModel) {
        userRepository.delete(userModel);
    }
    public void deleteUser(String email) {
        userRepository.deleteUser(email);
    }
}
