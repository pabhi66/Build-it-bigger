package com.udacity.gradle.builditbigger;


import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v7.app.NotificationCompat;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.abhi.android.jokerprovider.JokerProvider;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Button button;
    static ProgressBar progressBar;
    public String getJoke = null;
    public boolean test = false;



    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);


        if(!BuildConfig.EXTRA_FEATURES) {

            AdView mAdView = (AdView) root.findViewById(R.id.adView);
            // Create an ad request. Check logcat output for the hashed device ID to
            // get test ads on a physical device. e.g.
            // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();
            mAdView.loadAd(adRequest);
        }


        //get progress bar and button
        button = (Button) root.findViewById(R.id.jokeButton);
        progressBar = (ProgressBar) root.findViewById(R.id.progressBar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeAsyncTask();
            }
        });


        return root;
    }



    private void executeAsyncTask(){
        new EndpointsAsyncTask().execute(new Pair<Context, MainActivityFragment>(getContext(), this));
    }

    public void launchJokerActivity(){
        if(!test) {
            MainActivityFragment.progressBar.setVisibility(View.GONE);
            Intent intent = new Intent(getContext(), JokerProvider.class);
            intent.putExtra(Intent.EXTRA_TEXT, getJoke);

            PendingIntent pendingIntent =
                    TaskStackBuilder.create(getContext())
                            // add all of DetailsActivity's parents to the stack,
                            // followed by DetailsActivity itself
                            .addNextIntentWithParentStack(intent)
                            .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext());
            builder.setContentIntent(pendingIntent);



            getContext().startActivity(intent);
        }
    }


}
