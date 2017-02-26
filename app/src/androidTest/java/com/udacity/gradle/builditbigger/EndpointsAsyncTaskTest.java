package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Created by abhi on 2/25/17.
 */

public class EndpointsAsyncTaskTest {
    @Test
    public void testDoInBackground() throws Exception {
        MainActivityFragment fragment = new MainActivityFragment();
        MainActivityFragment.test = true;
        new MainActivity.EndpointsAsyncTask();
        AsyncTask.execute((Runnable) fragment);
        Thread.sleep(5000);
        assertTrue("Error: " + MainActivityFragment.getJoke, MainActivityFragment.getJoke != null);
    }
}
