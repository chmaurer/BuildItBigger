package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.v4.util.Pair;
import android.test.InstrumentationTestCase;

import com.example.JokeProvider;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by Christian on 12.04.2016.
 */
public class EndpointsAsyncTaskTest extends InstrumentationTestCase {
    public void testVerifyJokeResponse() throws Throwable {

        // create  a signal to let us know when our task is done.
        final CountDownLatch signal = new CountDownLatch(1);
        final EndpointsAsyncTask task = new EndpointsAsyncTask(true);

        runTestOnUiThread(new Runnable() {

            @Override
            public void run() {
                task.execute(new Pair<Context, String>(getInstrumentation().getContext(), null));
            }
        });
        signal.await(10, TimeUnit.SECONDS);
        assertTrue(task.getJoke() != null && task.getJoke().length() > 0);
        assertEquals(JokeProvider.getRandomJoke(), task.getJoke());
    }

}
