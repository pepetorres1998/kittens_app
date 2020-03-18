package com.example.makemyday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static boolean isSongPlaying = false;
    ImageView kittenImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        kittenImage = findViewById(R.id.kittenImage);

        Toast.makeText(MainActivity.this,
                "Click on kitten for more :3", Toast.LENGTH_LONG).show();

        kittenImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float width = kittenImage.getWidth();
                float height = kittenImage.getHeight();
                String toastString = "Width: " +
                        String.valueOf(width) +
                        ", Height: " +
                        String.valueOf(height);

                Toast.makeText(MainActivity.this,
                        toastString,
                        Toast.LENGTH_SHORT).show();

                if (isSongPlaying) {
                    Intent intent = new Intent(getApplicationContext(), GetCatService.class);
                    stopService(intent);
                    isSongPlaying = false;
                } else {
                    Intent intent = new Intent(getApplicationContext(), GetCatService.class);
                    startService(intent);
                    isSongPlaying = true;
                }
            }
        });
    }
}
