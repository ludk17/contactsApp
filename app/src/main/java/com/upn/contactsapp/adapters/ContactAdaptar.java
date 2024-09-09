package com.upn.contactsapp.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upn.contactsapp.R;
import com.upn.contactsapp.entities.Contact;

import java.util.List;

public class ContactAdaptar extends RecyclerView.Adapter<ContactAdaptar.ContactViewHolder> {

    private final List<Contact> data;

    public ContactAdaptar(List<Contact> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_contact, parent, false);

        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        View view = holder.itemView;

        Contact item = data.get(position);

        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvNumber = view.findViewById(R.id.tvNumber);

        tvName.setText(item.name);
        tvNumber.setText(item.phone);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(view.getContext(), );
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {

     public ContactViewHolder(@NonNull View itemView) {
         super(itemView);
     }
    }
}
