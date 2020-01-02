package vn.edu.usth.dropbox.View.authen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import vn.edu.usth.dropbox.R;
import vn.edu.usth.dropbox.model.request.User;

public class Signup extends AppCompatActivity {

    Button btnSignup;
    EditText editFirtname, editLastname, editEmail, editPassword,editPhone;
    TextView wfirstname,wemail,wphone,wpass;
    CheckBox checkBox;
    TextView sigin_text;
    Integer id;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    final DatabaseReference table_user=database.getReference("User");
    Integer i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnSignup=findViewById(R.id.btnSignup);
        editFirtname=findViewById(R.id.edit_first_name);
        editLastname=findViewById(R.id.edit_last_name);
        editEmail=findViewById(R.id.edit_email);
        editPassword=findViewById(R.id.edit_password);
        sigin_text=findViewById(R.id.sign_in_text);
        editPhone=findViewById(R.id.edit_phone);
        checkBox=findViewById(R.id.checkbox);
        wemail=findViewById(R.id.wemail);
        wfirstname=findViewById(R.id.wfirstname);
        wpass=findViewById(R.id.wpass);
        wphone=findViewById(R.id.wphone);
        wemail.setVisibility(View.GONE);
        wphone.setVisibility(View.GONE);
        wpass.setVisibility(View.GONE);
        wfirstname.setVisibility(View.GONE);


        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_user=database.getReference("User");

        sigin_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Signup.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
        checker();

    }

    private void checker() {
        btnSignup.setOnClickListener(v -> {
            String username = editFirtname.getText().toString();
            String password = editPassword.getText().toString();
            String email = editEmail.getText().toString();
            String phone = editPhone.getText().toString();
            if (username.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                wfirstname.setVisibility(View.VISIBLE);
                wpass.setVisibility(View.VISIBLE);
                wemail.setVisibility(View.VISIBLE);
                wphone.setVisibility(View.VISIBLE);

            }


            signup();

        });
    }

    private void signup() {
        btnSignup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(Signup.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();
                table_user.addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        {
                            if (dataSnapshot.child(editPhone.getText().toString()).exists()) {
                                mDialog.dismiss();
                            } else {
                                mDialog.dismiss();
                                User user = new User(editFirtname.getText().toString(), editLastname.getText().toString(),
                                        editPassword.getText().toString(), editEmail.getText().toString());
                                table_user.child(editPhone.getText().toString()).setValue(user);
                                finish();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }


        });
    }
    // Firebase





}
