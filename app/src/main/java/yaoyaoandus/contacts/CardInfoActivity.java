package yaoyaoandus.contacts;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
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
        final TextView cardname=(TextView)findViewById(R.id.textview_cardinfo_name);
        TextView cardnumber=(TextView)findViewById(R.id.textview_cardinfo_number);
        Intent intent=getIntent();
        final String name=intent.getStringExtra("name");
        final String number=intent.getStringExtra("number");
        cardname.setText(name);
        cardnumber.setText(number);
        opencardedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CardInfoActivity.this,CardEditActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("number",number);
                startActivity(intent);
            }
        });
        Button button_call=(Button)findViewById(R.id.button_makecall);
        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+number.toString().trim()));
                startActivity(intent);
            }
        });
    }
}
