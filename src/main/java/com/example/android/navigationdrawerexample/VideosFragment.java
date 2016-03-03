package com.example.android.navigationdrawerexample;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VideosFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class VideosFragment extends Fragment {
    ArrayAdapter adptr;
    public VideosFragment() {
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
                "1)Software Engineering By Harvard University",
                "2)NPTEL By IIT Bombay",
                "3)Introduction to Software Engineering By Colorado University",
                "4)Software Engineering By Saylor Academy",
                "5)Software Testing By UDEMY",
                "6)Video Lectures By Learnerstv",
        };
        View view = inflater.inflate(R.layout.fragment_videos, container, false);
        adptr = new ArrayAdapter<String>(getActivity(), R.layout.list_item_subject, R.id.list_item_subject_textview,vids);
        ListView listview = (ListView) view.findViewById(R.id.list_vids);
        listview.setAdapter(adptr);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String subject = (String) adptr.getItem(i);
                if (subject.equals(getResources().getString(R.string.cor1))) {
                    Uri uri = Uri.parse("http://www.extension.harvard.edu/professional-certificates/software-engineering-certificate");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if (subject.equals(getResources().getString(R.string.cor2))) {
                    Uri uri = Uri.parse("http://freevideolectures.com/Course/2318/Software-Engineering");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if (subject.equals(getResources().getString(R.string.cor3))) {
                    Uri uri = Uri.parse("http://www.online.colostate.edu/certificates/software-engineering/");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if (subject.equals(getResources().getString(R.string.cor4))) {
                    Uri uri = Uri.parse("http://www.saylor.org/courses/cs302/");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if (subject.equals(getResources().getString(R.string.cor5))) {
                    Uri uri = Uri.parse("https://www.udemy.com/software-testing-software-testing/?dtcode=htINxoU1NJlO");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if (subject.equals(getResources().getString(R.string.cor6))) {
                    Uri uri = Uri.parse("http://www.learnerstv.com/Free-Computer-Science-Video-lectures-ltv063-Page1.htm");
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            }
        });
        return view;
    }

}
