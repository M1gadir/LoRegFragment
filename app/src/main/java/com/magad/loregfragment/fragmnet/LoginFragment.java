package com.magad.loregfragment.fragmnet;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.magad.loregfragment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    @BindView(R.id.edtuser)
    TextInputEditText edtuser;
    @BindView(R.id.tiuser)
    TextInputLayout tiuser;
    @BindView(R.id.edtpas)
    TextInputEditText edtpas;
    @BindView(R.id.pasuser)
    TextInputLayout pasuser;
    @BindView(R.id.btnlogin)
    Button btnlogin;
    @BindView(R.id.btn_signup)
    Button btnSignup;
    Unbinder unbinder;
    FragmentManager fm;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        fm = getActivity().getSupportFragmentManager();
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btnlogin, R.id.btn_signup})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.btnlogin:
                if (edtuser.getText().toString().trim().length() == 0 && edtpas.getText().toString().trim().length() == 0){
                    edtuser.setError("Username Jangan Kosong");
                    edtpas.setError("Password Jangan Kosong");
                }else if (edtpas.getText().length() <= 6 ) {
                    edtpas.setError("password harus lebih dari 6 karakter");

            }
                break;
            case R.id.btn_signup:
                fm.beginTransaction()
                        .add(R.id.layar,new RegisterFragment())
                        .addToBackStack("")
                        .hide(LoginFragment.this)
                        .commit();
                break;
        }
    }

}
