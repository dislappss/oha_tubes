package com.example.dsluzki.oha_tubes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

       // setTheme(android.R.style.Theme_Material );

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void get_imageButton_Click(View view) {
        ImageView image;


        int id = getResources().getIdentifier("call", "mipmap", getPackageName());

        image = (ImageView) findViewById(R.id.imageView1);
        image.setImageResource(id); //R.mipmap.call2);
        image.refreshDrawableState();






        Toast.makeText(this, "Get image...Success", Toast.LENGTH_SHORT).show();

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView=null;

            int _fragment_no = getArguments().getInt(ARG_SECTION_NUMBER);

            if(_fragment_no == 1) {
                rootView = inflater.inflate(R.layout.fragment_main, container, false);

                TextView textView = (TextView) rootView.findViewById(R.id.section_label);
                textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            }
            else if(_fragment_no == 2)
            {
                rootView = inflater.inflate(R.layout.fragment_users, container, false);

                // Construct the data source
                ArrayList<User> arrayOfUsers = new ArrayList<User>();
                // Create the adapter to convert the array to views
                UsersAdapter adapter = new UsersAdapter(this.getActivity(), arrayOfUsers);

                // TEST
                // Add item to adapter

                User newUser = new User("Nathan", "San Diego");
                adapter.add(newUser);

                newUser = new User("Dima", "Dnepr");
                adapter.add(newUser);

                newUser = new User("Sonja", "Nürnberg");
                adapter.add(newUser);


                // Attach the adapter to a ListView
                 ListView _listView = (ListView)rootView.findViewById(R.id.lvItems);
                if(_listView != null)
                    _listView.setAdapter(adapter);
                else
                    Toast.makeText(this.getActivity(), "LIST VIEW is NULL !!!", Toast.LENGTH_SHORT).show();

                // Attach the adapter to a Spinner
                // Spinner adapter
                Spinner spinner = (Spinner) rootView.findViewById(R.id.spinItems);



                spinner.setOnItemSelectedListener(new ItemSelectedListener());


                /*
                spinner.setOnItemSelectedListener().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                });
                */
                UsersSpinnerAdapter _spinner_adapter = new UsersSpinnerAdapter(this.getActivity(), arrayOfUsers); // adapter;

                       // ArrayAdapter.createFromResource(rootView.getContext(), R.array.media_names, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
               // spinner.setPrompt(getString(R.string.select_item));

                spinner.setAdapter(
                        new NothingSelectedSpinnerAdapter(
                                _spinner_adapter,
                                R.layout.contact_spinner_row_nothing_selected,
                                // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                                rootView.getContext()));

            }




            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
