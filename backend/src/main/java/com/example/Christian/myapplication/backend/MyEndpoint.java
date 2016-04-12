/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.Christian.myapplication.backend;

import com.example.JokeProvider;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.Christian.example.com",
                ownerName = "backend.myapplication.Christian.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "getRandomJoke")
    public MyJoke getRandomJoke() {
        String randomJoke = JokeProvider.getRandomJoke();
        MyJoke response = new MyJoke();
        response.setData(randomJoke);
        return response;
    }

}
