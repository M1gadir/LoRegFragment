package com.magad.loregfragment.fragmnet;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.magad.loregfragment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    @BindView(R.id.edt_firnam)
    TextInputEditText edtFirnam;
    @BindView(R.id.edt_lasnam)
    TextInputEditText edtLasnam;
    @BindView(R.id.edt_emreg)
    TextInputEditText edtEmreg;
    @BindView(R.id.edt_nohp)
    TextInputEditText edtNohp;
    @BindView(R.id.edt_pasreg)
    TextInputEditText edtPasreg;
    @BindView(R.id.edt_retpasreg)
    TextInputEditText edtRetpasreg;
    @BindView(R.id.rb_ml)
    RadioButton rbMl;
    @BindView(R.id.rb_fml)
    RadioButton rbFml;
    @BindView(R.id.spin_reggis)
    Spinner spinReggis;
    @BindView(R.id.btn_signup)
    Button btnSignup;

    Unbinder unbinder;
    FragmentManager fm;
    @BindView(R.id.btn_lognow)
    Button btnLognow;


    private String[] listkota = {
            "-pilih-", "Jakarta", "Banten", "Semarang", "Kalimantan", "Bogor", "MeiKarta", "Bekasi", "Jonggol", "Mars", "Jupiter"
    };

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        unbinder = ButterKnife.bind(this, view);
        ArrayAdapter<String> ign = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, listkota);
        spinReggis.setAdapter(ign);
        fm = getActivity().getSupportFragmentManager();
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_signup)
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.btn_signup:
                if (edtFirnam.getText().toString().trim().length() == 0 &&
                        edtLasnam.getText().toString().trim().length() == 0 &&
                        edtEmreg.getText().toString().trim().length() == 0 &&
                        edtNohp.getText().toString().trim().length() == 0 &&
                        edtPasreg.getText().toString().trim().length() == 0 &&
                        edtRetpasreg.getText().toString().trim().length() == 0
                && rbMl.isChecked() == false && rbFml.isChecked() == false) {
                    edtRetpasreg.setError("password jangan Kosong");
                    edtFirnam.setError("nama depan jangan Kosong");
                    edtEmreg.setError("Email jangan Kosong");
                    edtLasnam.setError("nama belakang jangan Kosong");
                    edtNohp.setError("no hp jangan Kosong");
                    edtPasreg.setError("password jangan Kosong");
                    rbMl.setError("Jangan kosong");
                    rbFml.setError("Jangan kosong");
                } else if (edtFirnam.getText().length() <= 3) {
                    edtFirnam.setError("Nama depan harus lebih dari 3 karakter");
                } else if (edtLasnam.getText().length() <= 3) {
                    edtLasnam.setError("nama belakang harus lebih dari 3 karakter");
                } else if (edtNohp.getText().length() <= 6) {
                    edtNohp.setError("no hp harus 13 angka");
                } else if (edtPasreg.getText().length() <= 8) {
                    edtPasreg.setError("password harus lebih dari 8 karakter");
                } else if (edtRetpasreg.getText() == edtPasreg) {
                    edtRetpasreg.setError("Password Tidak Sama");
                } else if (rbMl.isChecked()) {
                    Toast.makeText(getActivity(), "Laki Laki", Toast.LENGTH_SHORT).show();
                } else if (rbFml.isChecked()) {
                    Toast.makeText(getActivity(), "Laki Laki", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btn_lognow:
                fm.beginTransaction()
                        .add(R.id.layar, new LoginFragment())
                        .addToBackStack("")
                        // hide beguna untuk menyembunyikan suatu layout
                        .hide(RegisterFragment.this)
                        .commit();
                break;

        }
    }

}
