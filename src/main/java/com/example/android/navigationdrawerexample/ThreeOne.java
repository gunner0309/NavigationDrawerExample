package com.example.android.navigationdrawerexample;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ThreeOne extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_one);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container3, new PlaceholderFragment())
                    .commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.three_one, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public static class PlaceholderFragment extends Fragment {

        ArrayAdapter m2Adapter;
        public PlaceholderFragment(){
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_three_one, container, false);
            String[] subjects = {
                    "-Managerial Economics & Accountancy",
                    "-Software Engineering",
                    "-Digital Signal Processing",
                    "-Database Management Systems",
                    "-Operating Systems",
                    "-Theory Of Automata"
            };

            m2Adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_subject, R.id.list_item_subject_textview,subjects);
            ListView listview2 = (ListView) view.findViewById(R.id.list_three_one);
            listview2.setAdapter(m2Adapter);
            listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String subject = (String)m2Adapter.getItem(i);
                    if(subject.equals("-Managerial Economics & Accountancy")) {
                       // Intent intent = new Intent(getActivity(), TwoOne.class);
                        //startActivity(intent);
                        Toast toast = Toast.makeText(getActivity(), subject, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else if(subject.equals("-Software Engineering")){
                        Intent intent1 = new Intent(getActivity(),SoftwareEngineering.class);
                        startActivity(intent1);
                    }
                    else if(subject.equals("-Digital Signal Processing")){
                        //Intent intent2 = new Intent(getActivity(),ThreeOne.class);
                        //startActivity(intent2);
                        Toast toast = Toast.makeText(getActivity(), subject, Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else if(subject.equals("-Database Management Systems")){
                        Intent intent3 = new Intent(getActivity(),Dbms.class);
                        startActivity(intent3);
                        //Toast toast = Toast.makeText(getActivity(), subject, Toast.LENGTH_SHORT);
                        //toast.show();
                    }
                    else if(subject.equals("-Operating Systems")){
                        //Intent intent3 = new Intent(getActivity(),ThreeTwo.class);
                        //startActivity(intent3);
                        Toast toast = Toast.makeText(getActivity(), subject, Toast.LENGTH_SHORT);
                        toast.show();

                    }
                    else if(subject.equals("-Theory Of Automata")){
                        //Intent intent3 = new Intent(getActivity(),ThreeTwo.class);
                        //startActivity(intent3);
                        Toast toast = Toast.makeText(getActivity(), subject, Toast.LENGTH_SHORT);
                        toast.show();
                    }

                }
            });
            return view;
        }

    }
}
