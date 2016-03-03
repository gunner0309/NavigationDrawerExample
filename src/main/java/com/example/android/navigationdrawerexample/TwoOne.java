package com.example.android.navigationdrawerexample;

import android.app.Activity;
import android.app.Fragment;
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


public class TwoOne extends Activity {

 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_one);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.two_one, menu);
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

    public static class PlaceholderFragment extends Fragment{
        ArrayAdapter mAdapter;
        public PlaceholderFragment(){
        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.activity_two_one, container, false);
            String[] subjects = {
                    "-Discrete Mathematics",
                    "-Microelectronics",
                    "-Digital Electronics & Logic Design",
                    "-Data Structure",
                    "-Electrical Circuits & Machines",
                    "-Environmental Studies"
            };

            mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_subject, R.id.list_item_subject_textview,subjects);
            ListView listview = (ListView) view.findViewById(R.id.list_two_one);
            listview.setAdapter(mAdapter);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String subject = (String)mAdapter.getItem(i);
                    Toast toast = Toast.makeText(getActivity(), subject, Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
            return view;
        }

    }


}
