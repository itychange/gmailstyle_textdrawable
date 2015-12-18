package com.itychange.gmailstyle_textdrawable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;



//url:https://github.com/amulyakhare/TextDrawable
public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    GmailAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        recyclerView = (RecyclerView) findViewById(R.id.image_list);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        List<String> listData = new ArrayList<String>();
        int ct = 0;
        String data[]={getString(R.string.tv_area),"B","C","D","E","F","H"};
        for (int i = 0; i <data.length * 3; i++) {
            listData.add(data[ct]);
            ct++;
            if (ct == data.length) {
                ct = 0;
            }
        }


        if (adapter == null) {
            adapter = new GmailAdapter(this, listData);
            recyclerView.setAdapter(adapter);
        }
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }


        return super.onOptionsItemSelected(item);
    }
}