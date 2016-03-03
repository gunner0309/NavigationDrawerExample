package com.example.android.navigationdrawerexample;



import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideosFragment1#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class VideosFragment1 extends Fragment {

    ArrayAdapter adapter;
    public VideosFragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String[] vids = {
                "",
                "video 2",
                "video 3",
                "video 4"
        };
        View view = inflater.inflate(R.layout.fragment_videos_fragment1, container, false);
        adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_subject, R.id.list_item_subject_textview,vids);
        ListView listview = (ListView) view.findViewById(R.id.list_vids1);
        listview.setAdapter(adapter);
        return view;
    }


}
