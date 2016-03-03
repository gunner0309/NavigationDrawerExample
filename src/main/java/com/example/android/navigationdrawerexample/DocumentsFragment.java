package com.example.android.navigationdrawerexample;


import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DocumentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class DocumentsFragment extends Fragment {


    ArrayAdapter adp;
    public DocumentsFragment() {
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
        View view = inflater.inflate(R.layout.fragment_documents, container, false);
        String[] docs = {
                "1)Roger S.Pressman, Software Engineering:A Prc1actitioners Approach, Fifth Edition",
                "2)Pankaj Jalte, An Integrated Approach to Software Engineering, Third Edition",
        };

        adp = new ArrayAdapter<String>(getActivity(), R.layout.list_item_subject, R.id.list_item_subject_textview,docs);
        ListView listview = (ListView) view.findViewById(R.id.list_docs);
        listview.setAdapter(adp);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String subject = (String)adp.getItem(i);
                if(subject.equals("submit"))){

                    File pdfFile = new File("/mnt/sdcard/Pressman__Software_Engineering.pdf");
                    if(pdfFile.exists())
                    {
                        Uri path = Uri.fromFile(pdfFile);
                        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
                        pdfIntent.setDataAndType(path, "application/pdf");
                        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        try
                        {
                            startActivity(pdfIntent);
                        }
                        catch(ActivityNotFoundException e)
                        {
                            Toast.makeText(getActivity(), "No Application available to view pdf", Toast.LENGTH_LONG).show();
                        }
                    }
                }
                else if(subject.equals(getResources().getString(R.string.doc2))){

                    File pdfFile = new File("/mnt/sdcard/An integrated approach to SE by pankaj jalote.pdf");
                    if(pdfFile.exists())
                    {
                        Uri path = Uri.fromFile(pdfFile);
                        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
                        pdfIntent.setDataAndType(path, "application/pdf");
                        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        try
                        {
                            startActivity(pdfIntent);
                        }
                        catch(ActivityNotFoundException e)
                        {
                            Toast.makeText(getActivity(), "No Application available to view pdf", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
        return view;
    }


}
