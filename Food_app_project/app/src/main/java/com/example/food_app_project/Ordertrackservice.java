package com.example.food_app_project;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.widget.Toast;

public class Ordertrackservice extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int sleepTime = intent.getIntExtra("sleepTime", 1);
        new MyAsyncTask().execute(sleepTime);
        return START_STICKY;
    }

    // @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent("com.example.food_app_project");
        intent.putExtra("startServiceResult","Food is out for Delivery");
        Toast.makeText(getApplicationContext(), "Food is out for Delivery", Toast.LENGTH_SHORT).show();
        sendBroadcast(intent);
    }

    class MyAsyncTask extends AsyncTask<Integer, String, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Integer... params) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            stopSelf();
        }
    }
}
