package com.upn.contactsapp.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upn.contactsapp.R;

import java.util.List;

public class ContactItemAdapter extends RecyclerView.Adapter<ContactItemAdapter.ContactItemViewHolder> {
    private List<String> mData;
    public ContactItemAdapter(List<String> data) {
        this.mData = data;
    }

    @NonNull
    @Override
    public ContactItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // definir que layout se debe usar
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_contact, parent, false);
        return new ContactItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactItemViewHolder holder, int position) {
        View view = holder.itemView;
        String data = mData.get(position);

        TextView tvContactName = view.findViewById(R.id.tvContactName);
        tvContactName.setText(data);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ContactItemViewHolder extends RecyclerView.ViewHolder {

        public ContactItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
