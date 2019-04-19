package com.example.myapplication;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    public static final String UPDATE_MEETING_ACTION = "android.appwidget.action.APPWIDGET_UPDATE";

    public static final String EXTRA_ITEM = "com.example.edockh.EXTRA_ITEM";
    private static final String MyOnClick = "myOnClickTag";


//    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
//                                int appWidgetId) {
//
//        CharSequence widgetText = context.getString(R.string.appwidget_text);
//        // Construct the RemoteViews object
//        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
//        views.setTextViewText(R.id.appwidget_text, widgetText);
////        views.set
//
//
//        // Instruct the widget manager to update the widget
//        appWidgetManager.updateAppWidget(appWidgetId, views);
//    }


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
//        for (int appWidgetId : appWidgetIds) {
//            updateAppWidget(context, appWidgetManager, appWidgetId);
//        }
        // update each of the app widgets with the remote adapter

        for (int i = 0; i < appWidgetIds.length; ++i) {
            // Set up the intent that starts the ListViewService, which will
            // provide the views for this collection.
            Intent intent = new Intent(context, ListViewWidgetService.class);
            // Add the app widget ID to the intent extras.
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
            intent.setData(Uri.parse(intent.toUri(Intent.URI_INTENT_SCHEME)));
            // Instantiate the RemoteViews object for the app widget layout.
            RemoteViews rv = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
            // Set up the RemoteViews object to use a RemoteViews adapter.
            // This adapter connects
            // to a RemoteViewsService  through the specified intent.
            // This is how you populate the data.
            rv.setRemoteAdapter(appWidgetIds[i], R.id.list_view, intent);
            // Trigger listview item click
            Intent startActivityIntent = new Intent(context,MainActivity.class);
            PendingIntent startActivityPendingIntent = PendingIntent.getActivity(context, 0, startActivityIntent, 0);
            rv.setPendingIntentTemplate(R.id.list_view, startActivityPendingIntent);


//            Intent intent1 = new Intent(context, SettingsActivity.class);
//            // Add the app widget ID to the intent extras.
//            intent1.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetIds[i]);
//            intent1.setData(Uri.parse(intent1.toUri(Intent.URI_INTENT_SCHEME)));
//
//            Intent startActivityIntent1 = new Intent(context,SettingsActivity.class);
//            PendingIntent startActivityPendingIntent1 = PendingIntent.getActivity(context, 0, startActivityIntent1, PendingIntent.FLAG_UPDATE_CURRENT);
//            rv.setPendingIntentTemplate(R.id.browse_more, startActivityPendingIntent1);


            Intent configIntent = new Intent(context, MainActivity.class);
            PendingIntent configPendingIntent = PendingIntent.getActivity(context, 0, configIntent, 0);
            rv.setOnClickPendingIntent(R.id.browse_more, configPendingIntent);

            // The empty view is displayed when the collection has no items.
            // It should be in the same layout used to instantiate the RemoteViews  object above.
//            rv.setEmptyView(R.id.list_view, R.id.empty_view);
            //
            // Do additional processing specific to this app widget...
            //


            rv.setOnClickPendingIntent(R.id.button_apply, getPendingSelfIntent(context, MyOnClick));
            appWidgetManager.updateAppWidget(appWidgetIds[i], rv);
        }

        super.onUpdate(context, appWidgetManager, appWidgetIds);

    }


    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created

//        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.list_item);
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        AppWidgetManager mgr = AppWidgetManager.getInstance(context);

        if (intent.getAction().equals(UPDATE_MEETING_ACTION)) {
            int appWidgetIds[] = mgr.getAppWidgetIds(new ComponentName(context,NewAppWidget.class));
            Log.e("received", "1st log");
            mgr.notifyAppWidgetViewDataChanged(appWidgetIds, R.id.list_view);
        }
         if (MyOnClick.equals(intent.getAction())){
            Log.e("received","hi this is internshala");
            Toast.makeText(context, "Button1", Toast.LENGTH_SHORT).show();
        }
        super.onReceive(context, intent);
    }


    protected PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }

}

