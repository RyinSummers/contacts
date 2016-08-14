package yaoyaoandus.contacts;

/**
 * Created by LJY on 16/8/10.
 */

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AlphabetIndexer;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.SimpleAdapter;
import android.widget.TextView;

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
    AlphabetIndexer alphabetIndexer;

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

        simpleAdapter=new IndexedSimpleAdapter(getActivity(),listItems,R.layout.frag1_list_item,
                new String[]{"header","name","number"},
                new int[]{R.id.image_icon_frag1,R.id.name_frag1,R.id.number_frag1});


        //还不清楚cursor是什么
//        Cursor cursor = getContentResolver().query(uri,
//                new String[] { "display_name", "sort_key" }, null, null, "sort_key");
//        if (cursor.moveToFirst()) {
//            do {
//                String name = cursor.getString(0);
//                String sortKey = getSortKey(cursor.getString(1));
//                Contact contact = new Contact();
//                contact.setName(name);
//                contact.setSortKey(sortKey);
//                contacts.add(contact);
//            } while (cursor.moveToNext());
//        }
//        startManagingCursor(cursor);
//        alphabetIndexer = new AlphabetIndexer(cursor, 1, "#ABCDEFGHIJKLMNOPQRSTUVWXYZ");

        //simpleAdapter.setSectionIndexer(alphabetIndexer);
        listView.setAdapter(simpleAdapter);
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
            //int section = mSectionIndexer.getSectionForPosition(position);
            TextView sortKey = (TextView) v.findViewById(R.id.alphabet_title_frag1);
//            if (position == mSectionIndexer.getPositionForSection(section)) {
//                sortKey.setText("hey");
//                sortKey.setVisibility(View.VISIBLE);
//            } else {
//                sortKey.setVisibility(View.GONE);
//            }
            if(position%2==0)
                sortKey.setVisibility(View.VISIBLE);
            return super.getView(position,convertView,parent);
//            Contact contact = getItem(position);
//            LinearLayout layout = null;
//            if (convertView == null) {
//                layout = (LinearLayout) LayoutInflater.from(getContext()).inflate(resource, null);
//            } else {
//                layout = (LinearLayout) convertView;
//            }
//            TextView name = (TextView) layout.findViewById(R.id.name);
//            LinearLayout sortKeyLayout = (LinearLayout) layout.findViewById(R.id.sort_key_layout);
//            TextView sortKey = (TextView) layout.findViewById(R.id.sort_key);
//            name.setText(contact.getName());
//            int section = mIndexer.getSectionForPosition(position);
//            if (position == mIndexer.getPositionForSection(section)) {
//                sortKey.setText(contact.getSortKey());
//                sortKeyLayout.setVisibility(View.VISIBLE);
//            } else {
//                sortKeyLayout.setVisibility(View.GONE);
//            }
//            return layout;
        }
    }
}