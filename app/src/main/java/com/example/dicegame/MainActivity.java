package com.example.dicegame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ImageView xucxac;
    private TextView count, total;
    private Button random, reset;
    private int remain = 3;
    private int all = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        xucxac = findViewById(R.id.xucxac);
        random = findViewById(R.id.random);
        count = findViewById(R.id.count);
        total = findViewById(R.id.total);
        reset = findViewById(R.id.reset);
        count.setText("Count: " + remain);
        total.setText("Total: " + all);

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomint = (int) (Math.random() * 6 + 1);
                if (randomint == 1) {
                    xucxac.setImageResource(R.drawable.mat1);
                } else if (randomint == 2) {
                    xucxac.setImageResource(R.drawable.mat2);
                } else if (randomint == 3) {
                    xucxac.setImageResource(R.drawable.mat3);
                } else if (randomint == 4) {
                    xucxac.setImageResource(R.drawable.mat4);
                } else if (randomint == 5) {
                    xucxac.setImageResource(R.drawable.mat5);
                } else {
                    xucxac.setImageResource(R.drawable.mat6);
                }
                all += randomint;
                total.setText("Total: " + all);
                remain--;
                count.setText("Count: " + remain);
                if(remain == 0) {
                    random.setVisibility(View.GONE);
                    reset.setVisibility(View.VISIBLE);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remain = 3;
                all = 0;
                count.setText("Count: " + remain);
                total.setText("Total: " + all);
                xucxac.setImageResource(R.drawable.mat1);
                random.setVisibility(View.VISIBLE);
                reset.setVisibility(View.GONE);
            }
        });
    }

}