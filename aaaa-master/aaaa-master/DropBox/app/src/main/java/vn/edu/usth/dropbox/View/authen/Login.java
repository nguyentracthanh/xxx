package vn.edu.usth.dropbox.View.authen;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import vn.edu.usth.dropbox.R;
import vn.edu.usth.dropbox.View.home.HomeActivity;
import vn.edu.usth.dropbox.common.Common;
import vn.edu.usth.dropbox.model.request.User;

public class Login extends AppCompatActivity {
    Button btnSignin;
    EditText editphone,editpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editphone = findViewById(R.id.input_phone);
        editpass = findViewById(R.id.input_pass);
        btnSignin = findViewById(R.id.btnsignin2);

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_user=database.getReference("User");
        btnSignin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {


                final ProgressDialog mDialog=new ProgressDialog(Login.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();
                table_user.addListenerForSingleValueEvent(new ValueEventListener(){

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //check user exits or not
                        if (dataSnapshot.child(editphone.getText().toString()).exists()) {

                            //Get information
                            mDialog.dismiss();

                            User user = dataSnapshot.child(editphone.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(editpass.getText().toString())) {
                                {
                                    Intent homeIntent = new Intent(Login.this, HomeActivity.class);
                                    Common.currentUser = user;
                                    startActivity(homeIntent);
                                    finish();
                                }
                            } else {
                                Toast.makeText(Login.this, "Sign in false!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(Login.this, "User is not existed!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }


}
