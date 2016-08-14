package yaoyaoandus.contacts;

/**
 * Created by LJY on 16/8/10.
 */

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
        temp1.put("number", "1382792");
        listItems.add(temp1);
        Map<String, Object> temp2 = new HashMap<String, Object>();
        temp2.put("header",R.drawable.usermain);
        temp2.put("name","刘婷婷");
        temp2.put("number","13822123342");
        listItems.add(temp2);

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
}