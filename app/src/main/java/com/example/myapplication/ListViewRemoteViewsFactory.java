package com.example.myapplication;


import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;

import Models.DataItem;

class ListViewRemoteViewsFactory implements RemoteViewsService.RemoteViewsFactory {

    private Context mContext;
//    private ArrayList<String> records;
    private ArrayList<DataItem> listData;
    private DataItem dataItem;
    public static String ACTION_MENU_CLICKED = "MenuClicked";


    public ListViewRemoteViewsFactory(Context context, Intent intent) {
        mContext = context;
    }
    // Initialize the data set.
    public void onCreate() {
        // In onCreate() you set up any connections / cursors to your data source. Heavy lifting,
        // for example downloading or creating content etc, should be deferred to onDataSetChanged()
        // or getViewAt(). Taking more than 20 seconds in this call will result in an ANR.

//        records = new ArrayList<String>();
        listData = this.addDummyData();

//        records.add("asdasasdasdas");
//        records.add("asdasa");
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
        rv.setViewVisibility(R.id.i_title, View.GONE);
        // end feed row
        // Next, set a fill-intent, which will be used to fill in the pending intent template
        // that is set on the collection view in ListViewWidgetProvider.
        Bundle extras = new Bundle();
        extras.putInt(NewAppWidget.EXTRA_ITEM, position);
        Intent fillInIntent = new Intent();
        fillInIntent.putExtra("internship_id",data.getId());
        fillInIntent.putExtras(extras);
        // Make it possible to distinguish the individual on-click
        // action of a given item
        rv.setOnClickFillInIntent(R.id.button_apply, fillInIntent);


        Intent intent = new Intent(mContext, NewAppWidget.class);
        intent.setAction(ACTION_MENU_CLICKED);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(mContext, 0, intent, 0);

        RemoteViews views = new RemoteViews(mContext.getPackageName(), R.layout.widget_layout);

        views.setOnClickPendingIntent(R.id.button_jd, pendingIntent);






        // Return the RemoteViews object.
        return rv;
    }

    private ArrayList<DataItem> addDummyData(){
        listData = new ArrayList<DataItem>();
        for(int i = 1; i<10; i++){
            int duration = (int)(Math.random() * 50 + 1);
            dataItem = new DataItem(i,"new title", "new company", 1000*i, duration);
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
