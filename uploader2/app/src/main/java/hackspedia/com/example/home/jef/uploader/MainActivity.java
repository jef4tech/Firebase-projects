package hackspedia.com.example.home.jef.uploader;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("password1");


    private Button a,b,c;
    EditText ht;
    String result="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = findViewById(R.id.button2);

        a=findViewById( R.id.button3 );
        b=findViewById( R.id.button4 );
        ht=findViewById(R.id.editText3);

            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // This method is called once with the initial value and again
                    // whenever data at this location is updated.
                    final String value = dataSnapshot.getValue(String.class);
                        button.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {


                                 String k = ht.getText().toString();
                              if (value.equals(k))
                            {
                                k();
                            }}
                        });


                    }



                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
                }
            });


    }

    public void k(){

        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }




}