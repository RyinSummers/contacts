package yaoyaoandus.contacts;

/**
 * Created by LJY on 16/8/10.
 */

import android.content.Context;
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
        public String[] groups = { "我的名片1", "我的名片2", "我的名片3", "我的名片4" };
        public String[][] children = {
                { "胡算林", "张俊峰", "王志军", "二人" },
                { "李秀婷", "蔡乔", "别高", "余音" },
                { "摊派新", "张爱明" },
                { "马超", "司道光" }
        };
        Context context;

        public MyExpandableListAdapter(Context c)
        {
            context=c;
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
            logo.setImageResource(R.drawable.usermain);
            TextView textView =(TextView)v.findViewById(R.id.textview_frag3);
            textView.setText(getGroup(groupPosition).toString());
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