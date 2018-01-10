package com.example.ganesha.udacity_interview_assignment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ArrayList<Card> arrayList=new ArrayList<Card>();
    PagerAdapter pagerAdapter;
    Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getJsonData();
        viewPager=(ViewPager)findViewById(R.id.pager);
        pagerAdapter= new PagerAdapter(getSupportFragmentManager(),arrayList);
        Log.d("TAG",String.valueOf(arrayList.size()));
        //viewPager.setAdapter(pagerAdapter);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),String.valueOf(arrayList.size()),Toast.LENGTH_SHORT).show();
               // Log.d("TAG",String.valueOf(arrayList.size()));
                //viewPager=(ViewPager)findViewById(R.id.pager);
               // pagerAdapter= new PagerAdapter(getSupportFragmentManager(),arrayList);
                viewPager.setAdapter(pagerAdapter);
            }
        },1000);




    }

    private void getJsonData() {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        String url="https://s3-us-west-2.amazonaws.com/udacity-mobile-interview/CardData.json";
        StringRequest jsonrequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray=new JSONArray(response);
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);
                        Card card=new Card();
                        card.setLastname(jsonObject.getString("lastName"));
                        Log.d("TAG",jsonObject.getString("startDate"));
                        card.setFirstname(jsonObject.getString("firstName"));
                        card.setEmail(jsonObject.getString("email"));
                        card.setCompany(jsonObject.getString("company"));
                        card.setStartdate(jsonObject.getString("startDate"));
                        card.setBio(jsonObject.getString("bio"));
                        card.setImageurl(jsonObject.getString("avatar"));
                        arrayList.add(card);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error","jsonerrot");
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonrequest);
    }
}
