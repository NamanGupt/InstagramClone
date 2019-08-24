package gupta.naman.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("CW8cIy2u4I5x9ZfcwKUjXgXpL5KSvwjwF6beP0jX")
                // if defined
                .clientKey("SmoM6urJTkUh3gtiIKLlzD8wboRBBULiSNCOaJi8")
                .server("https://parseapi.back4app.com/")
                .build()
        );
    }
}
