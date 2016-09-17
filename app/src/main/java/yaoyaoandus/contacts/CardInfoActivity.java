package yaoyaoandus.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by LJY on 16/9/17.
 */
public class CardInfoActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardinfo);
        Button opencardedit=(Button)findViewById(R.id.button_opencardedit);
        Button deletecard=(Button)findViewById(R.id.button_deletecardinfo);
        TextView cardname=(TextView)findViewById(R.id.textview_cardinfo_name);
        TextView cardnumber=(TextView)findViewById(R.id.textview_cardinfo_number);
        Intent intent=getIntent();
        cardname.setText(intent.getStringExtra("name"));
        cardnumber.setText(intent.getStringExtra("number"));
        opencardedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CardInfoActivity.this,CardEditActivity.class));
            }
        });
    }
}
