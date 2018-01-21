package org.parthapp.android.animalsinformation;

/**
 * Created by parth on 1/21/2018.
 */
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parthapp.android.animalsinformation.R;

public class MainActivity extends AppCompatActivity {
    private Button visit ;
    private MediaPlayer mp;

    @Override
    public void onPause() {
        mp.release();
        super.onPause();
    }
    @Override
    public void onResume() {
        mp = MediaPlayer.create(this, R.raw.forest);
        mp.start();
        mp.setLooping(true);

        super.onResume();
    }
    @Override
    public void onStop() {
        mp.release();
        super.onStop();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //referSecond();
        visit = (Button)findViewById(R.id.visit);
        visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent visit= new Intent(MainActivity.this,SecondActivity.class);
                startActivity(visit);
            }
        });
    }
    @Override
    public void onBackPressed(){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Do you want to Exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

}