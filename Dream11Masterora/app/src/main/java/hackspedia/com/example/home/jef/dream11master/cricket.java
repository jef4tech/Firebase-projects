package hackspedia.com.example.home.jef.dream11master;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.bumptech.glide.Glide;

public class cricket extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    TextView a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.sec );
        a=findViewById( R.id.a);
        b=findViewById( R.id.b);
        c=findViewById( R.id.c);
        // Read from the database
        a();
        b();
        c();
    }

    public void a()
    {

        DatabaseReference myRef = database.getReference("cricketA1");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                a.setText( value );
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }
    public void b()
    {

        DatabaseReference myRef = database.getReference("cricketA2");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                b.setText( value );
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }
    public void c()
    {

        DatabaseReference myRef = database.getReference("cricketA3");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                c.setText( value );
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    }
    public void d(View view)
    {

        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }

    public void e(View view) {

        Intent intent = new Intent(this, Main4Activity.class);
        startActivity(intent);
    }

    public void f(View view) {

        Intent intent = new Intent(this, Main5Activity.class);
        startActivity(intent);
    }
    }

