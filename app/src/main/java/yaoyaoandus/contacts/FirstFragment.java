package yaoyaoandus.contacts;

/**
 * Created by LJY on 16/8/10.
 */

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SectionIndexer;
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

    public FirstFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_1, container, false);
        listView = (ListView) rootView.findViewById(R.id.listview_frag1);


        listItems = new ArrayList<Map<String, Object>>();
        Map<String, Object> temp1 = new HashMap<String, Object>();
//        temp1.put("header",R.drawable.usermain);
//        temp1.put("name","刘A");
//        temp1.put("number", "178");
//        listItems.add(temp1);
//        temp1 = new HashMap<String, Object>();
//        temp1.put("header",R.drawable.usermain);
//        temp1.put("name","刘B");
//        temp1.put("number", "17865");
//        listItems.add(temp1);
//        temp1 = new HashMap<String, Object>();
//        temp1.put("header",R.drawable.usermain);
//        temp1.put("name","刘婷婷");
//        temp1.put("number","13822123342");
//        listItems.add(temp1);
//        temp1 = new HashMap<String, Object>();
//        temp1.put("header",R.drawable.usermain);
//        temp1.put("name","江大哥");
//        temp1.put("number","888888");
//        listItems.add(temp1);
//        temp1 = new HashMap<String, Object>();
//        temp1.put("header",R.drawable.usermain);
//        temp1.put("name","宁");
//        temp1.put("number","19191919");
//        listItems.add(temp1);

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        //定义一个cursor游标，逐行查找数据库，数据库里有一个name与首字母的对应关系
        Cursor cursor = getActivity().getContentResolver().query(uri,
                null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                temp1.put("header",R.drawable.usermain);
                temp1.put("name",name);
                temp1.put("number", number);
                listItems.add(temp1);
                temp1 = new HashMap<String, Object>();
            } while (cursor.moveToNext());
        }
        //alphabetIndexer = new AlphabetIndexer(cursor, 1, " ABCDEFGHIJKLMNOPQRSTUVWXYZ");
       // simpleAdapter.setSectionIndexer(alphabetIndexer);
        simpleAdapter=new IndexedSimpleAdapter(getActivity(),listItems,R.layout.frag1_list_item,
                new String[]{"header","name","number"},
                new int[]{R.id.image_icon_frag1,R.id.name_frag1,R.id.number_frag1});
        listView.setAdapter(simpleAdapter);
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
        private SectionIndexer mSectionIndexer;
        public IndexedSimpleAdapter(Context context,
                             List<? extends Map<String,?>> data,
                             int resource,
                             String[] from,
                             int[] to)
        {
            super(context,data,resource,from,to);
            mResource=resource;
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public void setSectionIndexer(SectionIndexer sectionIndexer) {
            mSectionIndexer = sectionIndexer;
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
//            int section = mSectionIndexer.getSectionForPosition(position);
//            TextView sortKey = (TextView) v.findViewById(R.id.alphabet_title_frag1);
//            if (position == mSectionIndexer.getPositionForSection(section)) {
//                sortKey.setText("hey");
//                sortKey.setVisibility(View.VISIBLE);
//            } else {
//                sortKey.setVisibility(View.GONE);
//            }
            return super.getView(position,convertView,parent);
        }
    }
}