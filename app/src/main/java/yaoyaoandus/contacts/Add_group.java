package yaoyaoandus.contacts;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/9/4.
 */
//
public class Add_group extends Activity{
    private Spinner spinner;
    private List<String> group_type;
    private ArrayAdapter<String> arr_adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_add_group);
        spinner=(Spinner)findViewById(R.id.group_type);
        group_type=new ArrayList<String>();
//        TODO:讨论一下都有哪些类型
        group_type.add("类型一");
        group_type.add("类型二");
        group_type.add("类型三");
        group_type.add("其它");
//适配器
        arr_adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,group_type);
//        设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        加载适配器
        spinner.setAdapter(arr_adapter);
    }

}
