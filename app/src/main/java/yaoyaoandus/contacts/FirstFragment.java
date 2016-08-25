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
//    AlphabetIndexer alphabetIndexer;
//    static String alphabet="#ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public FirstFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_1, container, false);
        listView = (ListView) rootView.findViewById(R.id.listview_frag1);


        listItems = new ArrayList<Map<String, Object>>();
        Map<String, Object> temp1 = new HashMap<String, Object>();

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

        //定义一个cursor游标，逐行查找数据库，数据库里有一个name与首字母的对应关系sort_key
        Cursor cursor = getActivity().getContentResolver().query(uri,
                null, null, null, "sort_key");
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
        simpleAdapter=new IndexedSimpleAdapter(getActivity(),listItems,R.layout.frag1_list_item,
                new String[]{"header","name","number"},
                new int[]{R.id.image_icon_frag1,R.id.name_frag1,R.id.number_frag1});
//        alphabetIndexer = new AlphabetIndexer(cursor, cursor.getColumnIndex("sort_key"), "#ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        listView.setAdapter(simpleAdapter);
//        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
//
//            @Override
//            public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//            }
//
//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem,int visibleItemCount, int totalItemCount) {
//                //设置首字母碰撞覆盖效果具体代码
//                int section = alphabetIndexer.getSectionForPosition(firstVisibleItem);
//                int nextSecPosition = alphabetIndexer.getPositionForSection(section + 1);
//                if (firstVisibleItem != lastFirstVisibleItem) {
//                    ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) titleLayout.getLayoutParams();
//                    params.topMargin = 0;
//                    titleLayout.setLayoutParams(params);
//                    title.setText(String.valueOf(alphabet.charAt(section)));
//                }
//                if (nextSecPosition == firstVisibleItem + 1) {
//                    View childView = view.getChildAt(0);
//                    if (childView != null) {
//                        int titleHeight = titleLayout.getHeight();
//                        int bottom = childView.getBottom();
//                        MarginLayoutParams params = (MarginLayoutParams) titleLayout
//                                .getLayoutParams();
//                        if (bottom < titleHeight) {
//                            float pushedDistance = bottom - titleHeight;
//                            params.topMargin = (int) pushedDistance;
//                            titleLayout.setLayoutParams(params);
//                        } else {
//                            if (params.topMargin != 0) {
//                                params.topMargin = 0;
//                                titleLayout.setLayoutParams(params);
//                            }
//                        }
//                    }
//                }
//                lastFirstVisibleItem = firstVisibleItem;
//            }
//        });
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
//            int section = mSectionIndexer.getSectionForPosition(position);
//            TextView sortKey = (TextView) v.findViewById(R.id.alphabet_title_frag1);
//            if (position == mSectionIndexer.getPositionForSection(section)) {
//               sortKey.setText("hey");
//                sortKey.setVisibility(View.VISIBLE);
//            } else {
//                sortKey.setVisibility(View.GONE);
//            }

//            TextView sortKey = (TextView) v.findViewById(R.id.alphabet_title_frag1);
//            TextView name=(TextView)v.findViewById(R.id.name_frag1);
//            String title=name.getText().toString();
//            sortKey.setText(title);
//            sortKey.setVisibility(View.VISIBLE);

            TextView sortKey = (TextView) v.findViewById(R.id.alphabet_title_frag1);
            TextView name = (TextView)v.findViewById(R.id.name_frag1);
            //获取每个item字符串的头一个字符
            String firstword = name.getText().toString();
            //若为第一个位置直接设置组view就行
            if (position == 0 && firstword.startsWith("啊"))
            {
                sortKey.setText("A");
                sortKey.setVisibility(View.VISIBLE);
            }
            //若不是，需判断当前item首字母与上一个item首字母是否一致，再设置组view
//            else
//            {
//                String preLabel = (String) mList.get(position-1).get("name");
//                //获取上一个item的首字母
//                if (!firstword.equals(preLabel.substring(0,1)))
//                {
//                    sortKey.setText((firstword));
//                    sortKey.setVisibility(View.VISIBLE);
//                }
//                else
//                {
//                    //若与上一个item首字母一致则不需要重复设置组view
//                    sortKey.setVisibility(View.GONE);
//                }
//            }
            return super.getView(position,convertView,parent);
        }

//        @Override
//        public Object[] getSections()
//        {
//            //获取组信息的数组，比如这里可以返回char[]{'A','B',...}
////            return new String[] {"A","B","C","D","E","F","G",
////                    "H","I","J","K","L","M","N","O","P","Q",
////                    "R","S","T","U","V","W","X","Y","Z",};
//            return new Object[0];
//        }
//
//        @Override
//        public int getPositionForSection(int section)
//        {
//            //根据组信息获取索引
////              for (int i = 0; i < mList.size(); i++) {
////                         String str = mList.get(i).getName();
////                        char firstChar = ZhCharactersUtil.changeToSpell(str).toUpperCase().charAt(0);
////                         if (firstChar == section) {
////                                return i;
////                           }
////                    }
//            return 0;
//        }
//
//        @Override
//        public int getSectionForPosition(int i)
//        {
//               //根据索引获取组信息，这里不做处理
//             return 0;
//        }
    }

    private char getChAlphabet(String s)
    {
        return 0;
    }
}