package yaoyaoandus.contacts;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.AlertDialog;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by LJY on 16/9/17.
 */
public class CardInfoActivity extends Activity {

    TextView cardname;
    TextView cardnumber;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardinfo);
        Button opencardedit=(Button)findViewById(R.id.button_opencardedit);
        Button deletecard=(Button)findViewById(R.id.button_deletecardinfo);
        cardname=(TextView)findViewById(R.id.textview_cardinfo_name);
        cardnumber=(TextView)findViewById(R.id.textview_cardinfo_number);
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
                startActivityForResult(intent,1);
            }
        });
        deletecard.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder IsDelete=new AlertDialog.Builder(CardInfoActivity.this);
                        IsDelete.setTitle("删除");
                        IsDelete.setMessage("是否确认删除？");
                        IsDelete.setCancelable(false);
                        IsDelete.setPositiveButton(R.string.dialog_ok,new DialogInterface.OnClickListener()
                                {
                                    public void onClick(DialogInterface dialog,int witch){

                                    }
                                }
                        );
                        IsDelete.setNegativeButton(R.string.dialog_no,new DialogInterface.OnClickListener(){
                            public void onClick(DialogInterface dialog,int witch){
                                dialog.dismiss();
                            }
                        });
                        IsDelete.show();
                    }
                }
        );

        FloatingActionButton button_call=(FloatingActionButton)findViewById(R.id.call);
        button_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+number.toString().trim()));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String newname = data.getStringExtra("name");
                    String newnumber= data.getStringExtra("number");
                    cardname.setText(newname);
                    cardnumber.setText(newnumber);
                }
                break;
            default:
        }
    }
}
