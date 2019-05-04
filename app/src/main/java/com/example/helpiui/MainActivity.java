package com.example.helpiui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.nightonke.boommenu.Animation.BoomEnum;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.nightonke.boommenu.Util;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BoomMenuButton bmb = findViewById(R.id.bmb);
        bmb.setButtonEnum(ButtonEnum.TextOutsideCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_4_1);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_4_1);
        bmb.setBoomEnum(BoomEnum.RANDOM);
        bmb.setDraggable(true);
        TextOutsideCircleButton.Builder admin = new TextOutsideCircleButton.Builder()
                .isRound(false).buttonCornerRadius(Util.dp2px(20))
                .normalColor(Color.BLUE).normalText("Admin")
                .normalImageRes(R.drawable.ic_admin_with_cogwheels)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        Intent i = new Intent(MainActivity.this, LoginActivity.class);
                        i.putExtra("type", "admin");
                        startActivity(i);
                    }
                });
        bmb.addBuilder(admin);
        TextOutsideCircleButton.Builder customer = new TextOutsideCircleButton.Builder()
                .isRound(false).buttonCornerRadius(Util.dp2px(20))
                .normalColor(Color.RED).normalText("Customer")
                .normalImageRes(R.drawable.ic_man_user)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        Intent i = new Intent(MainActivity.this, LoginActivity.class);
                        i.putExtra("type", "user");
                        startActivity(i);
                    }
                });
        bmb.addBuilder(customer);
        TextOutsideCircleButton.Builder feature = new TextOutsideCircleButton.Builder()
                .isRound(false).buttonCornerRadius(Util.dp2px(20))
                .normalColor(Color.GREEN).normalText("Features")
                .normalImageRes(R.drawable.ic_features)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        Toast.makeText(MainActivity.this, "Clicked " + index, Toast.LENGTH_SHORT).show();
                    }
                });
        bmb.addBuilder(feature);
        TextOutsideCircleButton.Builder chat = new TextOutsideCircleButton.Builder()
                .isRound(false).buttonCornerRadius(Util.dp2px(20))
                .normalColor(Color.YELLOW).normalText("Chat")
                .normalImageRes(R.drawable.ic_chat)
                .listener(new OnBMClickListener() {
                    @Override
                    public void onBoomButtonClick(int index) {
                        Intent i = new Intent(MainActivity.this, ChatActivity.class);
                        startActivity(i);
                    }
                });
        bmb.addBuilder(chat);
    }
}
