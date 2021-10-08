package io.github.ejchathuranga.customtextview;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import io.github.ejchathuranga.ctv.CustomTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final AlphaAnimation buttonClick = new AlphaAnimation(1F, 0.2F);
        final CustomTextView textView = findViewById(R.id.tv);

        textView.setText("CustomTextView is a Customizable text view component that can use on Android");


        Button buttonSetUnderLineColor = findViewById(R.id.buttonSetUnderLineColor);
        Button buttonSetUnderlineDotWidthAndSpace = findViewById(R.id.buttonSetUnderlineDotWidthAndSpace);
        Button buttonSetUnderlineThickness = findViewById(R.id.buttonSetUnderlineThickness);
        Button buttonStUnderlinePadding = findViewById(R.id.buttonStUnderlinePadding);
        Button buttonReset = findViewById(R.id.buttonReset);

        buttonSetUnderLineColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                textView.setUnderLineColor(0xFFFF00FF);
            }
        });

        buttonSetUnderlineDotWidthAndSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                textView.setUnderlineDotWidthAndSpace(55f, 5f);
            }
        });


        buttonSetUnderlineThickness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                textView.setUnderlineThickness(55);
            }
        });


        buttonStUnderlinePadding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                textView.setUnderlinePadding(30);
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(buttonClick);
                textView.reset();
            }
        });


    }
}