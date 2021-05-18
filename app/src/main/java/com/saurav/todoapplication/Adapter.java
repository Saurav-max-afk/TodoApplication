package com.saurav.todoapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {

    ArrayList<Modal> dataholder;

    public Adapter(ArrayList<Modal> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.name.setText(dataholder.get(position).getName());
        holder.contact.setText(dataholder.get(position).getContact());
        holder.email.setText(dataholder.get(position).getEmail());


    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class viewHolder extends RecyclerView.ViewHolder {

        TextView name,contact,email;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.displayname);
            contact=itemView.findViewById(R.id.displaycontact);
            email=itemView.findViewById(R.id.displayemail);

        }
    }
}
