package com.example.dsluzki.oha_tubes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by disl on 16.04.2016.
 */
public class UsersAdapter extends ArrayAdapter<User> {
    // View lookup cache
    private static class ViewHolder {
        TextView name;
        TextView home;
    }

    public UsersAdapter(Context context, ArrayList<User> users) {
        super(context, R.layout.item_user, users);
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
            convertView = inflater.inflate(R.layout.item_user, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.tvName);
            viewHolder.home = (TextView) convertView.findViewById(R.id.tvHome);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // Populate the data into the template view using the data object
        viewHolder.name.setText(user.name);
        viewHolder.home.setText(user.hometown);
        // Return the completed view to render on screen
        return convertView;
    }
}
