package com.example.dsluzki.oha_tubes;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by disl on 17.04.2016.
 */
public class ItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        if(parent != null) {

            Object _item = parent.getItemAtPosition(pos);
            if(_item != null) {
                Toast.makeText(parent.getContext(),
                        "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }
}
