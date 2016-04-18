package com.example.dsluzki.oha_tubes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by disl on 16.04.2016.
 */
public class UsersSpinnerAdapter extends ArrayAdapter<User> {
    // View lookup cache
    private static class ViewHolder {
        TextView name;
    }

    public UsersSpinnerAdapter(Context context, ArrayList<User> users) {
        super(context, R.layout.contact_spinner_row_nothing_selected, users);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.contact_spinner_row_nothing_selected, parent, false);
            //viewHolder.name = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.name = (TextView) convertView.findViewById(R.id.text1);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.name.setText(user.toString());
        // Return the completed view to render on screen
        return convertView;
    }
}
