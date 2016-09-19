package yaoyaoandus.contacts;

/**
 * Created by LJY on 16/8/10.
 */

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.StringBuilderPrinter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

/**
      * A placeholder fragment containing a simple view.
      */
public  class SecondFragment extends android.support.v4.app.Fragment {
        ListView list;
        ArrayAdapter<String> listAdapter;

    public SecondFragment() {

    }
//TODO:1.为创建群组设置监听 2.如何设置长按进入群详情界面
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
//        super.onCreateView(inflater,container,savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_2, container, false);
//        TextView textView = (TextView) rootView.findViewById(R.id.textview_frag2);
//        textView.setText("我是群");
       list=(ListView) rootView.findViewById(R.id.listview_frag2);
        listAdapter=new CustomListAdapter(this.getActivity(),R.layout.frag2_list_item);
//TODO:这儿应该读取到数据库，数组只是为了测试,然后还需要加上名片长按的地方
//        for(int i=0;i<20;i++)
//            listAdapter.add("群"+i);
        listAdapter.add("春田花花幼儿园");
        listAdapter.add("山东人民是一家");
        listAdapter.add("我的大学");
        listAdapter.add("我们这一大家子");
        listAdapter.add("共同进步");
        list.setAdapter(listAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {

                View toolbar = view.findViewById(R.id.toolbar);
                ExpandAnimation expandAni = new ExpandAnimation(toolbar, 500);
                toolbar.startAnimation(expandAni);
            }
        });
//        添加每一个群组的长按监听
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            public boolean onItemLongClick(AdapterView<?> arg0,View arg1,int arg2,long arg3){
                Intent detail_of_group_intent=new Intent(getActivity(),Detail_of_group.class);
                getActivity().startActivity(detail_of_group_intent);
                return false;
            }

        });

//        转到创建群组页面
        FloatingActionButton add_group=(FloatingActionButton)rootView.findViewById(R.id.add_group);
        add_group.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((MainActivity) getActivity()).startAdd_group();
                    }
                }
        );

        return rootView;
    }

    class CustomListAdapter extends ArrayAdapter<String>{
        public CustomListAdapter(Context context, int textViewResourceId){
            super(context,textViewResourceId);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView =getActivity().getLayoutInflater().inflate(R.layout.frag2_list_item, null);

            }

            ((TextView)convertView.findViewById(R.id.title)).setText(getItem(position));

// Resets the toolbar to be closed
            View toolbar = convertView.findViewById(R.id.toolbar);
//            ((LinearLayout.LayoutParams) toolbar.getLayoutParams()).bottomMargin  -=50;
            toolbar.setVisibility(View.GONE);

            return convertView;
        }
    }
    }