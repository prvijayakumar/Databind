package com.example.vijayakumar.databind;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;

import com.example.vijayakumar.databind.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Bindcontroller bindcontrol = new Bindcontroller();
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setTemp(bindcontrol);
        binding.setAction(this);

       bindcontrol.clear.set("Clear");  // Assigning value directly



//        ArrayAdapter<CharSequence> spinner_maritalStatus = new ArrayAdapter<CharSequence>(getBaseContext(), R.layout.spinner_style,getResources().getStringArray(R.array.martialstatus)){
//            @Override
//            public boolean isEnabled(int position){
//                return position != 0;
//            }
//            @Override
//            public View getDropDownView(int position, View convertView,
//                                        ViewGroup parent) {
//                View view = super.getDropDownView(position, convertView, parent);
//                TextView tv = (TextView) view;
//                if(position == 0){
//                    // Set the hint text color gray
//                    tv.setTextColor(Color.GRAY);     }
//                else {   tv.setTextColor(Color.BLACK);   }
//                return view;
//            }
//        };
//
//        spinner_maritalStatus.setDropDownViewResource(R.layout.spinner_dropdown_item);

        binding.txtMaritalStatus.setOnItemSelectedListener(this);

    }

    public void UserActions(View view) {
        switch (view.getId()) {
            case R.id.txt_submit_click:
                if(bindcontrol.edit_first_name.get()==null || bindcontrol.edit_first_name.get().equals("")){
                    binding.errFirstNameTxt.setVisibility(View.VISIBLE);
                    bindcontrol.err_first_name.set("Enter First Name"); // Assigning value directly
                }if(bindcontrol.edit_last_name.get()==null || bindcontrol.edit_last_name.get().equals("")){
                    binding.errLastNameTxt.setVisibility(View.VISIBLE);
                bindcontrol.err_last_name.set("Enter Last Name"); // Assigning value directly
                }else{
                    binding.errFirstNameTxt.setVisibility(View.GONE);
                    binding.errLastNameTxt.setVisibility(View.GONE);
                    Toast.makeText(this, "Submitted", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.txt_add_click:
                bindcontrol.edit_first_name.set("Vijayakumar");
                bindcontrol.edit_last_name.set("Palanisamy");
                break;
            case R.id.txt_clear_click:
                bindcontrol.edit_first_name.set("");
                bindcontrol.edit_last_name.set("");
                binding.errFirstNameTxt.setVisibility(View.GONE);
                binding.errLastNameTxt.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        switch (adapterView.getId()) {
            case R.id.txtMaritalStatus:
                if(adapterView.getSelectedItemPosition()>1){
                    bindcontrol.setChildrenvis(true);
                }else{
                    bindcontrol.setChildrenvis(false);
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
