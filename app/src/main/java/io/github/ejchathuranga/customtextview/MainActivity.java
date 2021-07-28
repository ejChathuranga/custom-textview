package io.github.ejchathuranga.customtextview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import io.github.ejchathuranga.ctv.CustomTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final CustomTextView textView = findViewById(R.id.tv);

//        String aa = "a";
//
//        for (int i=0; i <2000; i++){
//            aa = aa + "a";
//            textView.setText(aa);
//        }

        textView.setText("CustomTextView is a Customizable text view component that can use on Android");

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setUnderLineColor(R.color.colorAccent);
                textView.setUnderlineWidth(5f);
            }
        });
    }
}