package com.example.video;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button button2;
    Button button3;
    Button button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

//الروابط لا تعمل داخل التطبيق فقط رابط واحد اشتغل
        
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videoURL="https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4";
               // String videoURL="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4";
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("url",videoURL);
                startActivity(i);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videoURL="https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4";
                // String videoURL="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4";
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("url",videoURL);
                startActivity(i);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videoURL="https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4";
                // String videoURL="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4";
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("url",videoURL);
                startActivity(i);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videoURL="https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4";
               // String videoURL="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4";
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                i.putExtra("url",videoURL);
                startActivity(i);
            }
        });
    }
}