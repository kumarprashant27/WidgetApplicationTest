package com.example.myapplication;


import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Models.DataItem;

import static android.content.Context.MODE_PRIVATE;

class ListViewRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    private Context mContext;
//    private ArrayList<String> records;
    private ArrayList<DataItem> listData;
    private DataItem dataItem;
    public static String ACTION_MENU_CLICKED = "MenuClicked";

    public static final String MY_PREFS_NAME = "MyPrefsFile";


    private static final int[] appliedInternships = new int[5];

    public ListViewRemoteViewsFactory(Context context, Intent intent) {
        mContext = context;
    }
    // Initialize the data set.
    public void onCreate() {
        // In onCreate() you set up any connections / cursors to your data source. Heavy lifting,
        // for example downloading or creating content etc, should be deferred to onDataSetChanged()
        // or getViewAt(). Taking more than 20 seconds in this call will result in an ANR.

//        records = new ArrayList<String>();

        SharedPreferences.Editor editor = mContext.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("name", "Elena");
        editor.putInt("idName", 12);
        editor.apply();




        listData = this.addDummyData();

    }
    // Given the position (index) of a WidgetItem in the array, use the item's text value in
    // combination with the app widget item XML file to construct a RemoteViews object.
    public RemoteViews getViewAt(int position) {
        // position will always range from 0 to getCount() - 1.
        // Construct a RemoteViews item based on the app widget item XML file, and set the
        // text based on the position.
        RemoteViews rv = new RemoteViews(mContext.getPackageName(), R.layout.widget_item);
        // feed row
        DataItem data = listData.get(position);
//        LinearLayout ll = (LinearLayout)
//        ll.get
        rv.setTextViewText(R.id.i_title, data.getTitle());
        rv.setTextViewText(R.id.i_company, data.getCompany());
        rv.setTextViewText(R.id.i_stipend, "Rs "+data.getSalary());
        rv.setTextViewText(R.id.i_duration, ""+data.getDuration()+ " Months");
        rv.setTextViewText(R.id.i_location, data.getLocation());
        Log.e("iddd", data.getId()+"");
        Log.e("position", position+"");
//        if(data.getApplied() && false){
            rv.setTextViewText(R.id.button_apply, "Applied");
//            rv.setInt(R.id.button_apply, "setBackgroundColor",
//                    R.drawable.btn_bg_fill_disabled);
//        } else{
//            rv.setTextViewText(R.id.button_apply, "Apply");
//            rv.setInt(R.id.button_apply, "setBackgroundColor",
//                    R.drawable.btn_bg_fill);
//        }


        SharedPreferences prefs = mContext.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        String restoredText = prefs.getString("text", null);
        if (restoredText != null) {
            String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
            int idName = prefs.getInt("idName", 0); //0 is the default value.
            Log.e("shared", idName+" "+name);
        }
//
//        try {
//            JSONArray array1 = new JSONArray(array);
//            Log.e("json", array1.toString());
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        //get from shared preferences ids,


//        rv.setViewVisibility(R.id.i_title, View.GONE);
        // end feed row
        // Next, set a fill-intent, which will be used to fill in the pending intent template
        // that is set on the collection view in ListViewWidgetProvider.
        Bundle extras = new Bundle();
        extras.putInt(NewAppWidget.EXTRA_ITEM, position);
        extras.putInt("internship_id", data.getId());
        extras.putString("internship_title", data.getTitle() + " for " + data.getCompany());
        Intent fillInIntent = new Intent();
        fillInIntent.putExtra("homescreen_meeting",data.getId());
        fillInIntent.putExtras(extras);
        // Make it possible to distinguish the individual on-click
        // action of a given item
        rv.setOnClickFillInIntent(R.id.button_apply, fillInIntent);

        Intent intent = new Intent(mContext, NewAppWidget.class);
        intent.setAction(ACTION_MENU_CLICKED);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, 0, intent, 0);

//        RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.widget_layout);
// Return the RemoteViews object.
        return rv;
    }

    private ArrayList<DataItem> addDummyData(){
        listData = new ArrayList<DataItem>();
        String[] titles = {"Marketing", "Digital Marketing", "Business Development (Sales)"};
        String[] companies = {"Uber Co.", "Tech Mahindra", "OYO Rooms PVT LTD"};
        String[] locations = {"Delhi", "Mumbai", "Pune"};


        for(int i = 1; i<4; i++){
            String title = titles[i-1];
            String company = companies[i-1];
            String location = locations[i-1];
            if(i == 3){
                dataItem = new DataItem(i,title, company, 1000*i, i, location, true);
            }else {
                dataItem = new DataItem(i,title, company, 1000*i, i, location, false);
            }
            listData.add(dataItem);
        }
        return listData;
    }

    public int getCount(){
//        Log.e("size=",records.size()+"");
//        return records.size();
        return listData.size();
    }

    public void onDataSetChanged(){
        // Fetching JSON data from server and add them to records arraylist
    }

    public int getViewTypeCount(){
        return 1;
    }

    public long getItemId(int position) {
        return position;
    }

    public void onDestroy(){
//        records.clear();
        listData.clear();
    }

    public boolean hasStableIds() {
        return true;
    }

    public RemoteViews getLoadingView() {
        return null;
    }

}
