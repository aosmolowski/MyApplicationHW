package osmolowski.aleksandr.myapplicationhw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //получим самый верхний Layout
        LinearLayout actMainLayout = (LinearLayout) findViewById(R.id.activity_main);

        //получим левый вложенный Layout и его параметры
        LinearLayout leftLinLayout = (LinearLayout) findViewById(R.id.leftIncLayout);
        LinearLayout.LayoutParams leftLinLayoutParams =
                (LinearLayout.LayoutParams) leftLinLayout.getLayoutParams();

        //создадим правый вложенный Layout и зададим ему параметры
        LinearLayout rigthLinLoyout = new LinearLayout(this);
        rigthLinLoyout.setOrientation(LinearLayout.VERTICAL);
        rigthLinLoyout.setBackgroundResource(R.color.colorVertLL);
        rigthLinLoyout.setPadding(leftLinLayout.getPaddingLeft(), leftLinLayout.getPaddingTop(),
                leftLinLayout.getPaddingRight(), leftLinLayout.getPaddingBottom());
        LinearLayout.LayoutParams rightLinLayoutParam =
                new LinearLayout.LayoutParams(leftLinLayoutParams);
        rightLinLayoutParam.setMarginStart((int) getResources().getDimension(R.dimen.activity_horizontal_margin));

        //добавляем правый вложенный Layout в верхний
        actMainLayout.addView(rigthLinLoyout, rightLinLayoutParam);

        //определим Layout-параметры для текстовых блоков
        LinearLayout.LayoutParams txtParams =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);
        txtParams.setMargins(0, 0, 0, (int) getResources().getDimension(R.dimen.activity_vertical_margin));
        //цикл добавления 4 элементов TextView
        for (int i = 0; i < 4; i++) {
            TextView currTxtView = new TextView(this); //создаём TextView
            currTxtView.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_launcher, 0, 0, 0); //мконка слева
            currTxtView.setText(R.string.some_txt); //надпись
            currTxtView.setBackgroundResource(R.color.colorTxtView); //цвет фона

            //вставляем текстовый блок в правый встроенный Layout
            rigthLinLoyout.addView(currTxtView, txtParams);
        }

    }
}
