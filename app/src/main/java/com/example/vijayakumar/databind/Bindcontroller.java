package com.example.vijayakumar.databind;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;


/**
 * Created by vijayakumar on 18-12-2017.
 */

public class Bindcontroller extends BaseObservable {

    public  String title="DETAILS";
    public  String title_firstname="First Name";
    public  String title_lastname="Last Name";
    public  String title_martialstatus="Martial Status";
    public  String title_no_of_child="No. of Children";


    public  String submit="Submit";
    public  String add="Add";

    public boolean childrenvis;


    public final ObservableField<String> edit_first_name = new ObservableField<>();
    public final ObservableField<String> edit_last_name =  new ObservableField<>();

    public final ObservableField<String> err_first_name =  new ObservableField<>();
    public final ObservableField<String> err_last_name =  new ObservableField<>();

    public final ObservableField<String> clear =  new ObservableField<>();


    void setChildrenvis(boolean visibility){
        this.childrenvis=visibility;
        notifyPropertyChanged(BR._all);
    }

}
