package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Created by abhi on 2/25/17.
 */

public class EndpointsAsyncTaskTest {
    @Test
    public void testDoInBackground() throws Exception {
        MainActivityFragment fragment = new MainActivityFragment();
        fragment.test = true;
        new EndpointsAsyncTask().execute(new Pair<Context, MainActivityFragment>(fragment.getContext(),fragment));
        Thread.sleep(5000);
        assertTrue("Error: " + fragment.getJoke, fragment.getJoke != null);
    }
}
