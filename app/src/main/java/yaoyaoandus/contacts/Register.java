package yaoyaoandus.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by lenovo on 2016/9/18.
 */
//TODO：数据库内容待完成
public class Register extends Activity{
    Button regist;
    ImageView choose_img;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        regist=(Button)findViewById(R.id.Isregist);
        choose_img=(ImageView)findViewById(R.id.regist_img);
        choose_img.setImageResource(R.drawable.defaultheader);
        regist.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        //Toast.makeText(Register.this, "用户注册", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this,MainActivity.class));
                        MainActivity.haslogin=true;
                        finish();
                    }
                }
        );

        choose_img.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view) {
                        //Toast.makeText(Register.this, "选择头像", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
