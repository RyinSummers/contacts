package yaoyaoandus.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by LJY on 16/9/16.
 */
public class CardEditActivity extends Activity{

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardedit);
        Button savecard=(Button)findViewById(R.id.button_savecard);
        Button nosavecard=(Button)findViewById(R.id.button_nosavecard);

        savecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        nosavecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
