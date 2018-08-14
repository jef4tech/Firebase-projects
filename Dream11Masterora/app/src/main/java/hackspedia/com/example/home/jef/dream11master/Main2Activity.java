package hackspedia.com.example.home.jef.dream11master;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Button a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
        a=findViewById( R.id.button );

        /*if(isOnline()){
            findViewById(R.id.no_internet).setVisibility(View.INVISIBLE) // Online
        }else {
            findViewById( R.id.no_internet ).setVisibility( View.VISIBLE ) // Disconnected
        }`*/
    }
    public void buttonAction(View view) {

        //instantiate an object
        ConnectivityManager cm=(ConnectivityManager)getApplicationContext().getSystemService( Context.CONNECTIVITY_SERVICE);

        //get all networks information
        NetworkInfo networkInfo[]=cm.getAllNetworkInfo();

        int i;

        //checking internet connectivity
        for(i=0;i<networkInfo.length;++i){
            if(networkInfo[i].getState()==NetworkInfo.State.CONNECTED){

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }

        if(i==networkInfo.length){
            Toast.makeText(getApplicationContext(),"Internet Not Connected",Toast.LENGTH_LONG).show();

        }
    }

}

