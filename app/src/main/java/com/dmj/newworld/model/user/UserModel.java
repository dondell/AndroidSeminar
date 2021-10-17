package com.dmj.newworld.model.user;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserModel implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    public String firstname;
    public String lastname;
    public String email;

    public UserModel() {
    }

    public UserModel(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
    }

    public UserModel(String firstname) {
        this.firstname = firstname;
    }

    protected UserModel(Parcel in) {
        firstname = in.readString();
        lastname = in.readString();
        email = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstname);
        dest.writeString(lastname);
        dest.writeString(email);
    }
}
