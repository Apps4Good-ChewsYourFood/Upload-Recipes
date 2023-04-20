package com.example.uploadrecipes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("MainActivity", "Value is: " + value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w("MainActivity", "Failed to read value.", error.toException());
            }
        });

    }

    /**
     * This method will be called in onCreate() and will move
     * the recipe data in the form of ingredients and recipes to Firebase
     */
    private void readRecipeData() {
        /*
        InputStream is = getResources().openRawResource(R.raw.trivia);

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line = "";
        try {
            while ((line = reader.readLine()) != null){
                String[] fields = line.split(",");
                Question q = new Question(fields[0], fields[1]);
                Log.v("MainActivity", q.getAnswer() + " " + q.getQuestion());
            }
        }
        catch(IOException e) {
            Log.wtf("MainActivity", "what a terrible failiure");
        }
        */
    }
}