package com.example.assignment.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.Models.Transaction_Model;
import com.example.assignment.R;
import com.example.assignment.Result_Screen;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ArrayList<Transaction_Model> transaction_modelList;

    public RecyclerViewAdapter(ArrayList<Transaction_Model> transaction_modelList) {
        this.transaction_modelList = transaction_modelList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView Text1;
        private TextView Text2;
        private TextView Text3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Text1 = itemView.findViewById(R.id.text1);
            Text2 = itemView.findViewById(R.id.text2);
            Text3 = itemView.findViewById(R.id.text3);
        }
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        Transaction_Model recyclerView_model = transaction_modelList.get(position);
        holder.Text1.setText("Rs " + recyclerView_model.getAmount() + "/-");
        holder.Text2.setText(recyclerView_model.getTo_From());
        holder.Text3.setText(recyclerView_model.getDate());
        holder.Text1.setOnClickListener(view -> {
            Intent i = new Intent(holder.itemView.getContext(), Result_Screen.class);
            i.putExtra("Text1", "Rs " + recyclerView_model.getAmount() + "/-");
            i.putExtra("Text2", recyclerView_model.getTo_From());
            i.putExtra("Text3", recyclerView_model.getDate());
            i.putExtra("Text4", recyclerView_model.getEmail());
            i.putExtra("Text5", recyclerView_model.getTransactionID().toString());
            holder.itemView.getContext().startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return transaction_modelList.size();
    }
}
