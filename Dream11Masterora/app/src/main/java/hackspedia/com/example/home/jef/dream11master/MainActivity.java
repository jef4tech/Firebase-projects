package hackspedia.com.example.home.jef.dream11master;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
// [SNIPPET load_banner_ad]
// Load an ad into the AdView.
// [START load_banner_ad]
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
// [START_EXCLUDE]
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
// [END_EXCLUDE]

public class MainActivity extends AppCompatActivity  {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("notes");

    TextView mt;

    private static final String TAG = "MainActivity";

    private AdView mAdView;
    // [START_EXCLUDE]
    private InterstitialAd mInterstitialAd;
    private Button mLoadInterstitialButton,b,c;
    // [END_EXCLUDE]

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7423464429819498~7574115766");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        b=findViewById( R.id.two );
        c=findViewById( R.id.three );

        mt=findViewById( R.id.hh);

        buttonAction();

        // [END load_banner_ad]

        // AdMob ad unit IDs are not currently stored inside the google-services.json file.
        // Developers using AdMob can store them as custom values in a string resource file or
        // simply use constants. Note that the ad units used here are configured to return only test
        // ads, and should not be used outside this sample.

        // [START instantiate_interstitial_ad]
        // Create an InterstitialAd object. This same object can be re-used whenever you want to
        // show an interstitial.
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        // [END instantiate_interstitial_ad]

        // [START create_interstitial_ad_listener]
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }

            @Override
            public void onAdLoaded() {
                // Ad received, ready to display
                // [START_EXCLUDE]
                if (mLoadInterstitialButton != null) {
                    mLoadInterstitialButton.setEnabled(true);
                }
                // [END_EXCLUDE]
            }

            @Override
            public void onAdFailedToLoad(int i) {
                // See https://goo.gl/sCZj0H for possible error codes.

                Toast.makeText( MainActivity.this, "first activity fail", Toast.LENGTH_SHORT ).show();

                Log.w(TAG, "onAdFailedToLoad:" + i);
            }
        });
        // [END create_interstitial_ad_listener]

        // [START display_interstitial_ad]
        mLoadInterstitialButton = findViewById(R.id.load_interstitial_button);

        // [END display_interstitial_ad]

        // Disable button if an interstitial ad is not loaded yet.
        mLoadInterstitialButton.setEnabled(mInterstitialAd.isLoaded());
        a();
    }

    /**
     * Load a new interstitial ad asynchronously.
     */
    // [START request_new_interstitial]
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
    // [END request_new_interstitial]



    // [START add_lifecycle_methods]
    /** Called when leaving the activity */
    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
        if (!mInterstitialAd.isLoaded()) {
            requestNewInterstitial();
        }
    }

    /** Called before the activity is destroyed */
    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
    // [END add_lifecycle_methods]

    @VisibleForTesting
    AdView getAdView() {
        return mAdView;
    }



    public void fun(View v) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        int i = v.getId();
        if (i == R.id.load_interstitial_button) {
            Intent intent = new Intent(this, cricket.class);
            startActivity(intent);
        } else if (i == R.id.two) {
            Intent intent = new Intent(this, football.class);
            startActivity(intent);
        } else if (i == R.id.three) {
            Intent intent = new Intent(this, skill.class);
            startActivity(intent);
        }
    }
}

    public void buttonAction() {

        //instantiate an object
        ConnectivityManager cm=(ConnectivityManager)getApplicationContext().getSystemService( Context.CONNECTIVITY_SERVICE);

        //get all networks information
        NetworkInfo networkInfo[]=cm.getAllNetworkInfo();

        int i;

        //checking internet connectivity
        for(i=0;i<networkInfo.length;++i){
            if(networkInfo[i].getState()==NetworkInfo.State.CONNECTED){
                Toast.makeText(getApplicationContext(),"Internet Connected",Toast.LENGTH_LONG).show();
                break;
            }
        }

        if(i==networkInfo.length){
            Toast.makeText(getApplicationContext(),"Internet Not Connected",Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
            }
    }
    public void a()
    {
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                mt.setText( value );
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }}
