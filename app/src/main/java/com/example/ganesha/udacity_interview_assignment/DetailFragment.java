package com.example.ganesha.udacity_interview_assignment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Ganesha on 1/9/2018.
 */

public class DetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.detail_fragment,container,false);

        TextView lastname=(TextView)v.findViewById(R.id.lastname);
        lastname.setText(getArguments().getString("lastname"));

        TextView firstname=(TextView)v.findViewById(R.id.firstname);
        firstname.setText(getArguments().getString("firstname"));

        TextView email=(TextView)v.findViewById(R.id.email);
        email.setText(getArguments().getString("email"));

        TextView company=(TextView)v.findViewById(R.id.company);
        company.setText(getArguments().getString("company"));

        TextView startDate=(TextView)v.findViewById(R.id.startdate);
        startDate.setText(getArguments().getString("startDate"));

        TextView bio=(TextView)v.findViewById(R.id.bio);
        bio.setText(getArguments().getString("bio"));

        ImageView imageView=(ImageView)v.findViewById(R.id.imageView);
        ImageLoadAsyncTask imageLoadAsyncTask=new ImageLoadAsyncTask(getArguments().getString("imageurl"),imageView);
        imageLoadAsyncTask.execute();
        //imageView.setImageResource();




        return v;
    }
}
