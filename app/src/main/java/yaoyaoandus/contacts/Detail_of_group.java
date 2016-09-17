package yaoyaoandus.contacts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lenovo on 2016/9/16.
 */

public class Detail_of_group extends Activity {

    ImageButton add_member = null;
    Button exit_group = null;
    TextView name_of_group,detail_of_group;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_of_group);
        add_member = (ImageButton) findViewById(R.id.add_member);
        exit_group = (Button) findViewById(R.id.exit_group);
        name_of_group=(TextView)findViewById(R.id.group_name);
        detail_of_group=(TextView)findViewById(R.id.detail_of_group);

        add_member.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Detail_of_group.this, "添加新成员", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        exit_group.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        Toast.makeText(Detail_of_group.this, "退出该群", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        final View view1;
        view1= getLayoutInflater().inflate(R.layout.change_dialog,null);
        String oldName=name_of_group.getText().toString();
        final EditText mEditText1 ;
        mEditText1=(EditText)view1.findViewById(R.id.edit);
        mEditText1.setText(oldName);
     name_of_group.setOnLongClickListener(
             new View.OnLongClickListener(){
                 public boolean onLongClick(View v){
//                     LayoutInflater layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                  AlertDialog change_group_name=new AlertDialog.Builder(Detail_of_group.this)
                          .setTitle("修改群昵称")
                          .setView(view1)
                           .setPositiveButton(
                                   getResources().getString(R.string.dialog_ok),new DialogInterface.OnClickListener(){
                                       public void onClick(DialogInterface dialog,int which){
                                           String newName=mEditText1.getText().toString();
                                           Toast.makeText(Detail_of_group.this,newName,Toast.LENGTH_SHORT);
                                           mEditText1.setText(newName);
                                           name_of_group.setText(newName);
                                       }
                                   }
                           )
                          .setNegativeButton(
                             getResources().getString(R.string.dialog_no),new DialogInterface.OnClickListener(){
                                      public void onClick(DialogInterface dialog,int witch)
                                      {
                                          dialog.dismiss();
                                      }
                                  }
                          )
                          .create();
                     change_group_name.show();
                     return false;
                 }
             }
     );
        final View view2;
        view2= getLayoutInflater().inflate(R.layout.change_dialog,null);
        String oldDetail;
        oldDetail=name_of_group.getText().toString();
        final EditText mEditText2=(EditText)view2.findViewById(R.id.edit);
        mEditText2.setText(oldDetail);
        detail_of_group.setOnLongClickListener(
                new View.OnLongClickListener(){
                    public boolean onLongClick(View v){
//                        LayoutInflater layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                        final View view= getLayoutInflater().inflate(R.layout.change_dialog,null);

                        AlertDialog change_group_detail=new AlertDialog.Builder(Detail_of_group.this)
                                .setTitle("修改群简介")
                                .setView(view2)
                                .setPositiveButton(
                                        getResources().getString(R.string.dialog_ok),new DialogInterface.OnClickListener(){
                                            public void onClick(DialogInterface dialog,int which){

                                                String newDetail=mEditText2.getText().toString();
//                                           TODO：用setText方法放入
                                                mEditText2.setText(newDetail);
                                                detail_of_group.setText(newDetail);
                                            }
                                        }
                                )
                                .setNegativeButton(
                                        getResources().getString(R.string.dialog_no),new DialogInterface.OnClickListener(){
                                            public void onClick(DialogInterface dialog,int witch)
                                            {
                                                dialog.dismiss();
                                            }
                                        }
                                )
                                .create();
                        change_group_detail.show();
                        return false;
                    }
                }
        );

    }
}
