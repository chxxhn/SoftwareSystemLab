package com.example.digitclassifier.draw;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.divyanshu.draw.widget.DrawView;
import com.example.digitclassifier.R;
import com.example.digitclassifier.tflite.Classifier;

import java.io.IOException;
import java.util.Locale;

public class DrawActivity extends AppCompatActivity {
    Classifier cls;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        DrawView drawView = findViewById(R.id.drawView);
        drawView.setStrokeWidth(100.0f);
        drawView.setBackgroundColor(Color.BLACK);
        drawView.setColor(Color.WHITE);

        TextView resultView = findViewById(R.id.resultView);
        cls = new Classifier(this);
        try {
            cls.init();
        } catch (IOException ioe) {
            Log.d("DigitClassifier", "failed to init Classifier", ioe);
        }

        // cls 변수가 null인지 확인
        if (cls == null) {
            Log.e("DrawActivity", "Classifier initialization failed.");
            // 적절한 예외 처리 또는 오류 메시지 표시
        }
        Button classifyBtn = findViewById(R.id.classifyBtn);
        classifyBtn.setOnClickListener(view -> {
            Bitmap image = drawView.getBitmap();
            Pair<Integer,Float> res = cls.classify(image);
            String outStr = String.format(
                    Locale.ENGLISH,
                    "%d,%.0f%%",
                    res.first,
                    res.second*100.0f);
            resultView.setText(outStr);

        });
        Button clearBtn = findViewById(R.id.clearBtn);
        clearBtn.setOnClickListener(v->{
            drawView.clearCanvas();
        });
        cls = new Classifier(this);
        try{
            cls.init();
        } catch (IOException ioe){
            Log.d("DigitClassifier","failed to init Classifier",ioe);
        }
    }
    @Override
    protected void onDestroy(){
        cls.finish();
        super.onDestroy();
    }
}
