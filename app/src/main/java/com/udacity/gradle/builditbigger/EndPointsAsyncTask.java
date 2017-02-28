package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import com.example.abhi.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * this class uses Async task to get jokes from jokes provider
 */

public class EndpointsAsyncTask extends AsyncTask<Pair<Context,MainActivityFragment>, Void, String> {
    private MyApi myApiService = null;
    private Context context;
    private MainActivityFragment fragment;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        MainActivityFragment.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(Pair<Context,MainActivityFragment>... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokeapp-159804.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        context = params[0].first;
        fragment = params[0].second;

        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        fragment.getJoke = result;
        fragment.launchJokerActivity();
    }




}
