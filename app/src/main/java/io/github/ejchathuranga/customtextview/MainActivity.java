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

        textView.setText("CustomTextView is a Customizable text view component that can use on AndroidCustomTextView is a Customizable text view component that can use on AndroidCustomTextView is a Customizable text view component that can use on AndroidCustomTextView is a Customizable text view component that can use on Android");

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                textView.setUnderlineDotWidthAndSpace(55f, 5f);
                textView.setUnderLineColor(0xFFFF00FF);
//                textView.setUnderlineThickness(20);
//                textView.setLineSpacing(5,2);
//                textView.setUnderlinePadding(30);


            }
        });
    }
}