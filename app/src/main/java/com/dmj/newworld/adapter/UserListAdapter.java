package com.dmj.newworld.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.dmj.newworld.R;
import com.dmj.newworld.model.UserModel;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private ArrayList<UserModel> userModelArrayList;

    public UserListAdapter(ArrayList<UserModel> userModelArrayList) {
        this.userModelArrayList = userModelArrayList;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserListAdapter.UserViewHolder holder, int position) {
        UserModel userModel = userModelArrayList.get(position);
        holder.firstname.setText(userModel.firstname);
        holder.lastname.setText(userModel.lastname);
        holder.email.setText(userModel.email);
    }

    @Override
    public int getItemCount() {
        return (userModelArrayList == null || userModelArrayList.size() == 0) ? 0 : userModelArrayList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        private TextView firstname;
        private TextView lastname;
        private TextView email;

        public UserViewHolder(View itemView) {
            super(itemView);

            firstname = itemView.findViewById(R.id.textViewFirstnameVal);
            lastname = itemView.findViewById(R.id.textViewLastnameVal);
            email = itemView.findViewById(R.id.textViewEmailVal);
        }
    }
}
