package com.example.helpiui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nightonke.boommenu.Animation.BoomEnum;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.TextInsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BoomMenuButton bmb = findViewById(R.id.bmb);
        bmb.setButtonEnum(ButtonEnum.TextInsideCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_4_2);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_4_2);
        bmb.setBoomEnum(BoomEnum.RANDOM);
        TextInsideCircleButton.Builder admin = new TextInsideCircleButton.Builder()
                .normalColor(Color.BLUE)
                .normalImageRes(R.drawable.ic_admin_with_cogwheels);
        bmb.addBuilder(admin);
        TextInsideCircleButton.Builder customer = new TextInsideCircleButton.Builder()
                .normalColor(Color.RED)
                .normalImageRes(R.drawable.ic_man_user);
        bmb.addBuilder(customer);
        TextInsideCircleButton.Builder feature = new TextInsideCircleButton.Builder()
                .normalColor(Color.GREEN)
                .normalImageRes(R.drawable.ic_features);
        bmb.addBuilder(feature);
        TextInsideCircleButton.Builder chat = new TextInsideCircleButton.Builder()
                .normalColor(Color.YELLOW)
                .normalImageRes(R.drawable.ic_chat);
        bmb.addBuilder(chat);
    }
}
