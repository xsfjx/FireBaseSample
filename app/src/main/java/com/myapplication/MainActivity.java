package com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.firebase.analytics.FirebaseAnalytics;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private Tracker tracker;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        //Button btn = findViewById(R.id.btn);
        tracker = MyApplication.getDefaultTracker();
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Button crashButton = findViewById(R.id.crashButton);
        crashButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Crashlytics.getInstance().crash(); // Force a crash
            }
        });


        initM();


    }

    private void initM() {
        //        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                tracker.send(new HitBuilders.EventBuilder()
//                        .setCategory("Action")
//                        .setAction("Share")
//                        .build());
//            }
//        });

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "2");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Saeed");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    @Override
    protected void onResume() {
        super.onResume();
        tracker.setScreenName("Main : onResume");
        tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }
}
