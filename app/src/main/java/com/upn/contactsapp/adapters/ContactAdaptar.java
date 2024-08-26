package com.upn.contactsapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upn.contactsapp.R;
import java.util.List;

public class ContactAdaptar extends RecyclerView.Adapter<ContactAdaptar.ContactViewHolder> {

    private List<String> data;

    public ContactAdaptar(List<String> data) {
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
        String item = data.get(position);
        View view = holder.itemView;

        TextView tvName = view.findViewById(R.id.tvName);
        tvName.setText(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {

     public ContactViewHolder(@NonNull View itemView) {
         super(itemView);
     }
 }
}
