package hackspedia.com.example.home.jef.uploader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void fun(View v) {

        int i = v.getId();
        if (i == R.id.button3) {
            Intent intent = new Intent(this, cricket.class);
            startActivity(intent);
        } else if (i == R.id.button4) {
            Intent intent = new Intent(this, football.class);
            startActivity(intent);
        }
    }
}
