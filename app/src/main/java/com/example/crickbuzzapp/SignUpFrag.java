package com.example.crickbuzzapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFrag extends Fragment {

    Context context;
    EditText userName,userEmail,userPhone,userDOB,userPassword,userConfirm;
    Button singup;
    NavController navController;

    public SignUpFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        context = getActivity().getApplicationContext();
        navController = Navigation.findNavController(view);
        userName = view.findViewById(R.id.signup_userName);
        userEmail = view.findViewById(R.id.signup_userEmail);
        userPhone = view.findViewById(R.id.singup_userPhoneNo);
        userDOB = view.findViewById(R.id.signup_userDOB);
        userPassword = view.findViewById(R.id.signIn_userPassword);
        userConfirm = view.findViewById(R.id.signup_userConfirmPassword);
        singup = view.findViewById(R.id.singup_btn);
        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!userName.getText().toString().isEmpty()
                && !userEmail.getText().toString().isEmpty()
                && !userPhone.getText().toString().isEmpty()
                && !userDOB.getText().toString().isEmpty()
                && !userPassword.getText().toString().isEmpty()
                && !userConfirm.getText().toString().isEmpty())
                {
                    if(userPassword.getText().toString().equals(userConfirm.getText().toString()))
                    {
                        Toast.makeText(context,"Singup Successfully!",Toast.LENGTH_LONG).show();
                        navController.navigate(R.id.action_signUpFrag_to_homeFrag);
                    }
                    else
                    {
                        Toast.makeText(context,"Your Passwords are not same!",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(context,"Require Fields are missing!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
