package yaoyaoandus.contacts;

/**
 * Created by LJY on 16/8/10.
 */

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

/**
      * A placeholder fragment containing a simple view.
      */
public  class ThirdFragment extends android.support.v4.app.Fragment {

    public ThirdFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_3, container, false);
        ExpandableListView expandableListView = (ExpandableListView)rootView.findViewById(R.id.expandablelistview_frag3);
        expandableListView.setAdapter(new MyExpandableListAdapter(getActivity()));
        return rootView;
    }


    public class MyExpandableListAdapter extends BaseExpandableListAdapter {
        // Sample data set.  children[i] contains the children (String[]) for groups[i].
        public String[] groups; //= { "我的名片1", "我的名片2", "我的名片3", "我的名片4" };
        public String[] groupsnum;
        public String[][] children
                = {
//                { "胡算林", "张俊峰", "王志军", "二人" },
//                { "李秀婷", "蔡乔", "别高", "余音" },
                { "摊派新", "张爱明" },
                { "马超", "司道光" }        };
        Context context;
        public MyExpandableListAdapter(Context c)
        {
            context=c;
            Cursor cursor=((MainActivity)c).getdatabase().getReadableDatabase().rawQuery("select card_name,content from mycards",null);
            groups=new String[cursor.getCount()];
            groupsnum=new String[cursor.getCount()];
            //children=new String[cursor.getCount()][];
            int i=0;
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor.getString(cursor.getColumnIndex("card_name"));
                    String number = cursor.getString(cursor.getColumnIndex("content"));
                    groups[i]=name;
                    groupsnum[i]=number;
                    i++;
                } while (cursor.moveToNext());
            }
            cursor.close();

//            Cursor cursor1=((MainActivity)c).getdatabase().getReadableDatabase().rawQuery("select * from cards_sendto",null);
//            Cursor cursor2=((MainActivity)c).getdatabase().getReadableDatabase().rawQuery("select * from cards_groups",null);
//            i=0;
//            if (cursor1.moveToFirst()) {
//                do {
//                    String name = cursor.getString(cursor1.getColumnIndex("card_name"));
//                    String number = cursor.getString(cursor1.getColumnIndex("content"));
//                    groups[i]=name;
//                    i++;
//                } while (cursor1.moveToNext());
//            }
//            cursor1.close();
//
//            if (cursor2.moveToFirst()) {
//                do {
//                    String name = cursor.getString(cursor2.getColumnIndex("card_name"));
//                    String number = cursor.getString(cursor2.getColumnIndex("content"));
//                    groups[i]=name;
//                    i++;
//                } while (cursor2.moveToNext());
//            }
//            cursor2.close();
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return children[groupPosition][childPosition];
        }
        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return children[groupPosition].length;
        }

        //设置子项布局
        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                                 View convertView, ViewGroup parent) {
            TextView textView = new TextView(getActivity());
            textView.setText(getChild(groupPosition, childPosition).toString());
            return textView;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        //设置父类布局
        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                                 ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(R.layout.frag3_list_item,parent,false);
            //LinearLayout linearLayout=new LinearLayout(getActivity());
            ImageView logo=(ImageView) v.findViewById(R.id.image_icon_frag3);
            logo.setImageResource(R.drawable.defaultheader);
            TextView textView =(TextView)v.findViewById(R.id.textview_name_frag3);
            final String name=getGroup(groupPosition).toString();
            textView.setText(name);
            TextView textView2 =(TextView)v.findViewById(R.id.textview_number_frag3);
            final String number=groupsnum[groupPosition];
            textView2.setText(number);
            TextView textView3 =(TextView)v.findViewById(R.id.textview_openinfo_frag3);
            textView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity)context).startCardInfoActivity(name,number);
                }
            });
            return v;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }
}