package com.dmj.newworld.model.user;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    LiveData<List<UserModel>> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<UserModel> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE firstname LIKE :first AND lastname LIKE :last LIMIT 1")
    UserModel findByName(String first, String last);

    @Insert
    void insertAll(UserModel... users);

    @Delete
    void delete(UserModel user);

    @Query("DELETE FROM user WHERE email = :email ")
    void deleteUser(String email);

    @Update
    void update(UserModel user);

}
