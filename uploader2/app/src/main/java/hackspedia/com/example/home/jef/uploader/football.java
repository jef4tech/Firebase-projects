package hackspedia.com.example.home.jef.uploader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class football extends AppCompatActivity {

    private Button a,b,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football);


        a=findViewById( R.id.button3 );
        b=findViewById( R.id.button4 );
        c=findViewById( R.id.button5 );

    }

    public void fun(View v) {
        int i = v.getId();
        if (i == R.id.button3) {
            Intent intent = new Intent(this, footballa.class);
            startActivity(intent);
        } else if (i == R.id.button4) {
            Intent intent = new Intent(this, footballb.class);
            startActivity(intent);
        } else if (i == R.id.button5) {
            Intent intent = new Intent(this, footballc.class);
            startActivity(intent);
        }
    }}
