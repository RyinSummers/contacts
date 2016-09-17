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
import android.widget.AdapterView;
import android.widget.Button;
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
    IndexedSimpleAdapter simpleAdapter;
    List<Map<String,Object>> listItems;
//    AlphabetIndexer alphabetIndexer;
//    static String alphabet="#ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    Button button_editnewcard;

    public FirstFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_1, container, false);
        listView = (ListView) rootView.findViewById(R.id.listview_frag1);

        button_editnewcard = (Button) rootView.findViewById(R.id.button_editnewcard);
        button_editnewcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                ((MainActivity)getActivity()).startCardEditActivity("","");
            }
        });

        listItems = new ArrayList<Map<String, Object>>();
        Map<String, Object> temp1 = new HashMap<String, Object>();

        /*
        读取手机联系人
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

        //定义一个cursor游标，逐行查找数据库，数据库里有一个name与首字母的对应关系sort_key
        Cursor cursor = getActivity().getContentResolver().query(uri,
                null, null, null, "sort_key");
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                //String sortkey = cursor.getString(0);
                temp1.put("header",R.drawable.usermain);
                temp1.put("name",name);
                temp1.put("number", number);
                listItems.add(temp1);
                temp1 = new HashMap<String, Object>();
            } while (cursor.moveToNext());
        }
        */

        DatabaseUtils databaseUtils=((MainActivity)getActivity()).getdatabase();
        Cursor cursor=((MainActivity)getActivity()).getdatabase().getReadableDatabase().rawQuery("select user_name,content from cards_received",null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("user_name"));
                String number = cursor.getString(cursor.getColumnIndex("content"));
                //String sortkey = cursor.getString(0);
                temp1.put("header",R.drawable.usermain);
                temp1.put("name",name);
                temp1.put("number", number);
                listItems.add(temp1);
                temp1 = new HashMap<String, Object>();
            } while (cursor.moveToNext());
        }

        simpleAdapter=new IndexedSimpleAdapter(getActivity(),listItems,R.layout.frag1_list_item,
                new String[]{"header","name","number"},
                new int[]{R.id.image_icon_frag1,R.id.name_frag1,R.id.number_frag1});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String currentname=(String)listItems.get(position).get("name");
                String currentnumber=(String)listItems.get(position).get("number");
                ((MainActivity)getActivity()).startCardInfoActivity(currentname,currentnumber);
            }
        });
        cursor.close();
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    public class IndexedSimpleAdapter extends SimpleAdapter
    {
        private int mResource;
        private LayoutInflater mInflater;
        List<Map<String,Object>> mList;//使用这个list做一些什么
        public IndexedSimpleAdapter(Context context,
                             List<Map<String,Object>> data,
                             int resource,
                             String[] from,
                             int[] to)
        {
            super(context,data,resource,from,to);
            mList=data;
            mResource=resource;
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View v;
            if (convertView == null) {
                v = mInflater.inflate(mResource, parent, false);
            } else {
                v = convertView;
            }
            return super.getView(position,convertView,parent);
        }


    }

}