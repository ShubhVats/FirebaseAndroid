package com.example.assignment;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment.Adapters.RecyclerViewAdapter;
import com.example.assignment.Models.Transaction_Model;
import com.example.assignment.Models.getTransaction_Model;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Home_Screen extends AppCompatActivity {
    private ArrayList<Transaction_Model> transaction_modelArraylist;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users");

        ArrayList<Transaction_Model> transaction_models = new ArrayList<>();
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Iterable<DataSnapshot> value = dataSnapshot.getChildren();
                for (DataSnapshot values : value) {
                    getTransaction_Model note = values.getValue(getTransaction_Model.class);
                    Log.e("Here", String.valueOf(note.getTransactionID()));
                    Transaction_Model recyclerView_model = new Transaction_Model(note.getAmount(), note.getDate(), note.getEmail(), note.getTo_From(), note.getTransactionID());
                    Log.e("Here", String.valueOf(recyclerView_model.getTransactionID()));

                    transaction_modelArraylist.add(recyclerView_model);
                    RecyclerViewAdapter adapter = setAdapter();

                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });

        recyclerView = findViewById(R.id.RecyclerView);
        //creating ArrayList
        transaction_modelArraylist = new ArrayList<>();


    }

    private RecyclerViewAdapter setAdapter() {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(transaction_modelArraylist);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        return adapter;
    }
}
