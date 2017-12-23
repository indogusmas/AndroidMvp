package com.indo.app.androidmvp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.indo.app.androidmvp.R;
import com.indo.app.androidmvp.activities.MainActivity;
import com.indo.app.androidmvp.network.LoginApi;

/**
 * Created by indo on 23/12/17.
 */

public class LoginFragement extends Fragment {

    private EditText mUserNameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private LoginApi mLoginApi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        mUserNameEditText=(EditText)view.findViewById(R.id.Fragment_login_userbname);
        mPasswordEditText=(EditText) view.findViewById(R.id.Fragment_login_password);
        mLoginButton = (Button)view.findViewById(R.id.Fragment_login_btn_login);
        mLoginButton.setOnClickListener(mLoginButtonClickListener);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLoginApi = new LoginApi();
    }
    private View.OnClickListener mLoginButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String username = mUserNameEditText.getText().toString();
            if (username.isEmpty()){
                mUserNameEditText.setError(getString(R.string.empty_username));
                return;
            }

            String password = mPasswordEditText.getText().toString();
            if (password.isEmpty()){
                mPasswordEditText.setError(getString(R.string.empty_password_error));
            }

            if (mLoginApi.authenticate(username, password)){
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
                return;
            }
            Toast.makeText(getContext(), "Incorret", Toast.LENGTH_LONG).show();
        }
    };
}





























