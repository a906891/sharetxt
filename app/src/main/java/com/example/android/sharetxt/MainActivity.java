package com.example.android.sharetxt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////STRING AS NAME ARRAY //
        String[] cars = {"hero honda","maruti","me"};
        /////TO VIEW STRING  NAME IN LISTVIEW////
        ListView listview = (ListView) findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_expandable_list_item_1,cars);
        listview.setAdapter(adapter);

        //////WHAT WILL HAPPEN IF ON OF THE LIST NAME IS CLICKED////
        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ///SHOWS A MEASSAGE IN LOG FILE///////////
                Log.v(TAG,"*******You are at******"+position);
            }
        };
        listview.setOnItemClickListener(onItemClickListener);

    }

    public void Click(View view){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,"Hello");
        intent.setType("text/plain");
        startActivity(intent);
    }
}
