package com.example.accelify;

import android.app.Application;
import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.appcheck.AppCheckProviderFactory;
import com.google.firebase.appcheck.debug.DebugAppCheckProviderFactory;

import com.google.firebase.appcheck.playintegrity.BuildConfig;
import com.google.firebase.appcheck.playintegrity.PlayIntegrityAppCheckProviderFactory;

public class AccelifyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Firebase
        FirebaseApp.initializeApp(this);

        // Set up Firebase App Check
        AppCheckProviderFactory appCheckProviderFactory = PlayIntegrityAppCheckProviderFactory.getInstance();

        // Enable App Check debug mode
        if (BuildConfig.DEBUG) {
            appCheckProviderFactory = DebugAppCheckProviderFactory.getInstance();
        }

        FirebaseAppCheck.getInstance().installAppCheckProviderFactory(appCheckProviderFactory);
    }
}
