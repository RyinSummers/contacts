package yaoyaoandus.contacts;

/**
 * Created by LJY on 16/8/10.
 */

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
      * A placeholder fragment containing a simple view.
      */
public  class FirstFragment extends android.support.v4.app.Fragment {

    ListView listView;
    SimpleAdapter simpleAdapter;
    List<Map<String,Object>> listItems;

    public FirstFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_1, container, false);
        listView = (ListView) rootView.findViewById(R.id.listview_frag1);

        listItems = new ArrayList<Map<String, Object>>();
        Map<String, Object> temp1 = new HashMap<String, Object>();
        temp1.put("header",R.drawable.usermain);
        temp1.put("name","刘婧颖");
        temp1.put("number", "17865198377");
        listItems.add(temp1);
        temp1 = new HashMap<String, Object>();
        temp1.put("header",R.drawable.usermain);
        temp1.put("name","刘A");
        temp1.put("number", "178");
        listItems.add(temp1);
        temp1 = new HashMap<String, Object>();
        temp1.put("header",R.drawable.usermain);
        temp1.put("name","刘B");
        temp1.put("number", "17865");
        listItems.add(temp1);
        temp1 = new HashMap<String, Object>();
        temp1.put("header",R.drawable.usermain);
        temp1.put("name","刘婷婷");
        temp1.put("number","13822123342");
        listItems.add(temp1);
        temp1 = new HashMap<String, Object>();
        temp1.put("header",R.drawable.usermain);
        temp1.put("name","江大哥");
        temp1.put("number","888888");
        listItems.add(temp1);
        temp1 = new HashMap<String, Object>();
        temp1.put("header",R.drawable.usermain);
        temp1.put("name","宁");
        temp1.put("number","19191919");
        listItems.add(temp1);

        simpleAdapter=new SimpleAdapter(getActivity(),listItems,R.layout.frag1_list_item,
                new String[]{"header","name","number"},
                new int[]{R.id.image_icon_frag1,R.id.name_frag1,R.id.number_frag1});
        listView.setAdapter(simpleAdapter);
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    public class MySimpleAdapter extends SimpleAdapter
    {
        private int mResource;
        public MySimpleAdapter(Context context,
                             List<? extends Map<String,?>> data,
                             int resource,
                             String[] from,
                             int[] to)
        {
            super(context,data,resource,from,to);
            mResource=resource;
        }
    }
}