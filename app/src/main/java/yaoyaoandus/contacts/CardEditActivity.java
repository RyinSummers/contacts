package yaoyaoandus.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        Intent intent=getIntent();
        final String name=intent.getStringExtra("name");
        String number=intent.getStringExtra("number");
        final EditText editTextname=(EditText)findViewById(R.id.edittext_name_cardedit);
        final EditText editTextnum=(EditText)findViewById(R.id.edittext_num_cardedit);
        editTextname.setText(name);
        editTextnum.setText(number);

        savecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_new=editTextname.getText().toString();
                String num_new=editTextnum.getText().toString();
//                new DatabaseUtils(CardEditActivity.this,"myuser.db",1).getReadableDatabase()
//                .execSQL("update cards set DNAME= where DNAME  ");
                Intent intent1=new Intent();
                intent1.putExtra("name",name_new);
                intent1.putExtra("number",num_new);
                setResult(RESULT_OK,intent1);
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
