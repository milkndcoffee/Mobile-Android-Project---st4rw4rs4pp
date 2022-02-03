package com.milkndcoffee.st4rw4rs4pp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.milkndcoffee.st4rw4rs4pp.Model.CreateName;
import com.milkndcoffee.st4rw4rs4pp.R;

public class MainActivity extends AppCompatActivity {

    private EditText mFirstNameEditText;
    private EditText mLastNameEditText;
    private EditText mMaidenNameEditText;
    private EditText mCityEditText;

    private TextView mAnswerPriorTextView;
    private TextView mAnswerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Widget -> Field Assignment
        mFirstNameEditText = findViewById(R.id.text_first_name);
        mLastNameEditText = findViewById(R.id.text_last_name);
        mMaidenNameEditText = findViewById(R.id.text_maiden_name);
        mCityEditText = findViewById(R.id.text_city_name);

        mAnswerPriorTextView = findViewById(R.id.text_view_before_answer);
        mAnswerTextView = findViewById(R.id.text_view_answer);

        //onclickListener
        Button createButton = (Button)findViewById(R.id.create_button);
        createButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                createClick(v);
            }
        });
    }

    public void createClick(View view){
        //Get Input Values
        String firstName;
        String lastName;
        String maidenName;
        String city;

        try{
            firstName = mFirstNameEditText.getText().toString();
            lastName = mLastNameEditText.getText().toString();
            maidenName = mMaidenNameEditText.getText().toString();
            city = mCityEditText.getText().toString();
        }catch (Exception e){
            firstName = " ";
            lastName = " ";
            maidenName = " ";
            city = " ";
        }

        //Toast
        if (firstName.length() <= 2 || lastName.length() <= 3 || maidenName.length() <= 2 || city.length() <= 3){
            Context context = getApplicationContext();
            CharSequence text = "Please fill all out fields and/or enter more than 3 letters.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else{
            //Basically runs CreateName and set result value to result
            CreateName createName = new CreateName(firstName, lastName, maidenName, city);

            //Make TextField Visible and display.
            mAnswerPriorTextView.setVisibility(View.VISIBLE);
            mAnswerTextView.setText(createName.getNewName());
        }

    }



}