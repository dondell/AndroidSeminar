package com.dmj.newworld.model.user;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.dmj.newworld.database.AppDatabase;

import java.util.List;

public class UserRepository {
    private UserDao userDao;
    private LiveData<List<UserModel>> mAllUsers;

    public UserRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        userDao = db.userDao();
        mAllUsers = userDao.getAll();
    }

    LiveData<List<UserModel>> getAll() {
        return mAllUsers;
    }

    void insert(UserModel userModel) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            userDao.insertAll(userModel);
        });
    }

    void update(UserModel userModel) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            userDao.update(userModel);
        });
    }

    void delete(UserModel userModel) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            userDao.delete(userModel);
        });
    }
    void deleteUser(String email) {
        AppDatabase.databaseWriteExecutor.execute(() -> {
            userDao.deleteUser(email);
        });
    }
}
