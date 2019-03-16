package com.team15.foodhack19;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.team15.foodhack19.objectClass.Receipe;

public class addRecipeActivity extends Activity {

    private EditText title;
    private EditText author;
    private EditText desc;

    DatabaseReference mRef;
    DatabaseReference mCondition;

    public void addClicked(View view){
        String titleString = title.getText().toString();
        String authorString = author.getText().toString();
        String descString = desc.getText().toString();
        if (titleString.trim().length() == 0 || authorString.trim().length() == 0 || descString.trim().length() == 0){
            Toast toast = new Toast(this);
            toast.setText("You still have empty field to complete!");
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        Receipe r = new Receipe(null, null, authorString, "", 0, titleString, descString, null);
        mCondition.push().setValue(r);

    }

    public void cancelClicked(View view){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        title = findViewById(R.id.editText_title);
        author = findViewById(R.id.editText_author);
        desc = findViewById(R.id.editText_desc);

        mRef= FirebaseDatabase.getInstance().getReference();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mCondition = mRef.child("receipes");
        mCondition.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                data.add(dataSnapshot.getValue(ForecastStatus.class));
//                itemsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
