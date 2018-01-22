package org.parthapp.android.animalsinformation;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.parthapp.android.animalsinformation.R;

public class SecondActivity extends AppCompatActivity {

    int[] images = {R.drawable.zoo, R.drawable.cobra, R.drawable.flamingo, R.drawable.peacock,
            R.drawable.tiger, R.drawable.zebra,R.drawable.elephant};
    int currentImage = 1;
    int sound_click, sound_cobra, sound_flamingo, sound_peacock, sound_tiger, sound_zebra,sound_elephant;
    int num_sounds_loaded;
    boolean sounds_loaded;
    private ImageView imageToDisplay;
    private Button prev, next, info;
    private SoundPool sp;

    @Override
    public void onPause() {
        sp.release();
        super.onPause();
    }

    @Override
    public void onResume() {

        num_sounds_loaded = 0;
        sounds_loaded = false;

        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        sp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                num_sounds_loaded++;
                if (num_sounds_loaded == 1)
                    sounds_loaded = true;

            }
        });
        sound_click = sp.load(this, R.raw.click, 1);
        sound_cobra = sp.load(this, R.raw.cobra, 2);
        sound_flamingo = sp.load(this, R.raw.flamingo, 3);
        sound_peacock = sp.load(this, R.raw.peacock, 4);
        sound_tiger = sp.load(this, R.raw.tiger, 5);
        sound_zebra = sp.load(this, R.raw.zebra, 6);
        sound_elephant=sp.load(this,R.raw.elephant,7);
        super.onResume();

    }

    @Override
    public void onStop() {
        super.onStop();
        sp.release();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        imageToDisplay = (ImageView) findViewById(R.id.imageToDisplay);
        prev = (Button) findViewById(R.id.prev);
        next = (Button) findViewById(R.id.next);
        info = (Button) findViewById(R.id.info);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sounds_loaded) {
                    sp.play(sound_click, 1, 1, 0, 0, 1);
                }


                if (currentImage == 6) {
                    currentImage = 1;
                    imageToDisplay.setImageResource(images[currentImage]);
                    setName(currentImage);
                    return;
                } else {
                    currentImage = currentImage + 1;
                    imageToDisplay.setImageResource(images[currentImage]);
                    setName(currentImage);
                    return;
                }
            }


        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sounds_loaded) {
                    sp.play(sound_click, 1, 1, 0, 0, 1);
                }

                if (currentImage == 1) {
                    currentImage = 6;
                    imageToDisplay.setImageResource(images[currentImage]);
                    setName(currentImage);
                    return;
                } else {
                    currentImage = currentImage - 1;
                    imageToDisplay.setImageResource(images[currentImage]);
                    setName(currentImage);
                    return;
                }
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentImage == 1) {
                    Intent intent = new Intent(SecondActivity.this, InfoActivity.class);
                    intent.putExtra("URL","https://en.wikipedia.org/wiki/Cobra");
                    startActivity(intent);
                }
                if (currentImage == 2) {
                    Intent intent = new Intent(SecondActivity.this, InfoActivity.class);
                    intent.putExtra("URL","https://en.wikipedia.org/wiki/Flamingo");
                    startActivity(intent);
                }
                if (currentImage == 3) {
                    Intent intent = new Intent(SecondActivity.this, InfoActivity.class);
                    intent.putExtra("URL","https://en.wikipedia.org/wiki/Peafowl");
                    startActivity(intent);
                }
                if (currentImage == 4) {
                    Intent intent = new Intent(SecondActivity.this, InfoActivity.class);
                    intent.putExtra("URL","https://en.wikipedia.org/wiki/Tiger");
                    startActivity(intent);
                }
                if (currentImage == 5) {
                    Intent intent = new Intent(SecondActivity.this, InfoActivity.class);
                    intent.putExtra("URL","https://en.wikipedia.org/wiki/Zebra");
                    startActivity(intent);
                }
                if (currentImage == 6) {
                    Intent intent = new Intent(SecondActivity.this, InfoActivity.class);
                    intent.putExtra("URL","https://en.wikipedia.org/wiki/Elephant");
                    startActivity(intent);
                }

            }
        });

        imageToDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (currentImage == 1) {
                    sp.play(sound_cobra, 1, 1, 0, 0, 1);
                    sp.stop(sound_cobra);
                    Toast.makeText(SecondActivity.this, "Histling", Toast.LENGTH_LONG).show();

                }
                if (currentImage == 2) {
                    sp.play(sound_flamingo, 1, 1, 0, 0, 1);
                    sp.stop(sound_flamingo);
                    Toast.makeText(SecondActivity.this, "Gabbling", Toast.LENGTH_SHORT).show();

                }
                if (currentImage == 3) {
                    sp.play(sound_peacock, 1, 1, 0, 0, 1);
                    sp.stop(sound_peacock);
                    Toast.makeText(SecondActivity.this, "Screaming", Toast.LENGTH_SHORT).show();
                }
                if (currentImage == 4) {
                    sp.play(sound_tiger, 1, 1, 0, 0, 1);
                    sp.stop(sound_tiger);
                    Toast.makeText(SecondActivity.this, "Growling", Toast.LENGTH_SHORT).show();
                }
                if (currentImage == 5) {
                    sp.play(sound_zebra, 1, 1, 0, 0, 1);
                    sp.stop(sound_zebra);
                    Toast.makeText(SecondActivity.this, "Whinning", Toast.LENGTH_SHORT).show();
                }
                if (currentImage == 6) {
                    sp.play(sound_elephant, 1, 1, 0, 0, 1);
                    sp.stop(sound_elephant);
                    Toast.makeText(SecondActivity.this, "Trumpet", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void setName(int currentImage) {
            if(currentImage==1){getSupportActionBar().setTitle("Cobra");}
            if(currentImage==2){getSupportActionBar().setTitle("Flamingo");}
            if(currentImage==3){getSupportActionBar().setTitle("Peacock");}
            if(currentImage==4){getSupportActionBar().setTitle("Tiger");}
            if(currentImage==5){getSupportActionBar().setTitle("Zebra");}
            if(currentImage==6){getSupportActionBar().setTitle("Elephant");}
    }

}
