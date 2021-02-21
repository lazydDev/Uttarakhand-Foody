package com.decentcafe.uttarakhandifoody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressBar signUpLoading;
    EditText txtUsername, txtEmail, txtPass;
    Button btnSignup;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        progressDialog = new ProgressDialog(Register.this);
        progressDialog.setTitle("Creating User...");
        progressDialog.setMessage("Please wait we are creating your account" +
                "We are creating your Account...");

        signUpLoading = findViewById(R.id.signUpLoading);

        txtUsername = findViewById(R.id.txtUsername);
        txtEmail = findViewById(R.id.txtEmail);
        txtPass = findViewById(R.id.txtPass);
        btnSignup = findViewById(R.id.btnSignup);

    }

    public void onClick(View v) {

        progressDialog.show();

        String email = txtEmail.getText().toString().trim();
        String pass = txtPass.getText().toString().trim();
//        String status = txtStatus.getText().toString().trim();
        String user = txtUsername.getText().toString().trim();

        if (email.isEmpty()) {
            progressDialog.dismiss();
            txtEmail.setError("E-Mail Address is Required!");
            txtEmail.requestFocus();
            return;
        }

        if (user.isEmpty()) {
            progressDialog.dismiss();
            txtUsername.setError("Username is Required");
            txtUsername.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            progressDialog.dismiss();
            txtPass.setError("Password is Required");
            txtPass.requestFocus();
            return;
        }

//        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            txtEmail.setError("Please provide a Valid Email!");
//            txtEmail.requestFocus();
//            return;
//        }

        if (pass.length() < 8) {
            progressDialog.dismiss();
            txtPass.setError("Length of of Password should be more than 8 characters!");
            txtPass.requestFocus();
            return;
        }

        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    User user = new User(email, pass);
                    String id = task.getResult().getUser().getUid();
                    database.getReference().child("Users").child(id).setValue(user);
                    Snackbar snackbar
                            = Snackbar
                            .make(
                                    v,
                                    "Your Account Has been Created! You can Continue using the now!",
                                    Snackbar.LENGTH_LONG)
                            .setAction(
                                    "Start App",

                                    // If the Undo button
                                    // is pressed, show
                                    // the message using Toast
                                    new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view)
                                        {
                                            startActivity(new Intent(Register.this, MainActivity.class));
                                        }
                                    });

                    snackbar.show();
                } else {
                    Snackbar.make(v, "User not created due to an fatal error!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });



    }

}