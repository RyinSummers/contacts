package yaoyaoandus.contacts;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    public static final String host="";

    public static boolean haslogin=false;

    public PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //顶栏
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        //为viewpager提供每个fragment的adapter，自定义
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        //咱们的viewpager
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //四个切换标签，暂时还在上面，以后要修改布局挪到底部
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        //圆形悬浮按钮
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if(haslogin==false)
        {
            startActivity(new Intent(new Intent(MainActivity.this,LoginActivity.class)));
            finish();
        }
        else
        //读取网络上的更新信息，存储到数据库里
        {

        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search)
        {
            final SearchView searchView = (SearchView) item.getActionView();
            final View popView=this.getLayoutInflater().inflate(R.layout.popup_searchresult,null);
            popupWindow = new PopupWindow
                    (popView, RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    ArrayList<String> choice=new ArrayList<String>();
                    choice.add(0,query);
                    choice.add(1,"qwe");
                    choice.add(2,"were");
                    ListView poplistview=(ListView)popView.findViewById(R.id.listview_searchresult);
                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.popup_list_item,choice);
                    poplistview.setAdapter(adapter);
                    popupWindow.setFocusable(true);
                    popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                    popupWindow.showAsDropDown(searchView);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
            return true;
        }
        else if (id == R.id.action_addnew)
        {
            startCardEditActivity("","");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent motionEvent)
//    {
//        if(popupWindow!=null)
//        {
//            popupWindow.dismiss();
//            popupWindow=null;
//        }
//        return super.onTouchEvent(motionEvent);
//    }

    public void startCardEditActivity(String name,String number)
    {
        Intent intent=new Intent(MainActivity.this,CardEditActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("number",number);
        startActivity(intent);
    }

    public void startCardInfoActivity(String name,String number)
    {
        Intent intent=new Intent(MainActivity.this,CardInfoActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("number",number);
        startActivity(intent);
    }

    public void startAdd_group()
    {
        startActivity(new Intent(MainActivity.this,Add_group.class));
    }

    public DatabaseUtils getdatabase()
    {
        DatabaseUtils dbhelp=new DatabaseUtils(MainActivity.this,"myuser.db",1);
        return dbhelp;
    }

//    /**
//     * A placeholder fragment containing a simple view.
//     */
//    public static class PlaceholderFragment extends Fragment {
//        /**
//         * The fragment argument representing the section number for this
//         * fragment.
//         */
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        public PlaceholderFragment() {
//        }
//
//        /**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         */
//        public static PlaceholderFragment newInstance(int sectionNumber) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
//            return rootView;
//        }
//    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            //return PlaceholderFragment.newInstance(position + 1);
            switch (position) {
                case 0:
                    return new FirstFragment();
                case 1:

                    return new SecondFragment();
                case 2:
                    return new ThirdFragment();
                case 3:
                    return new ForthFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 4 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "名片集";
                case 1:
                    return "群";
                case 2:
                    return "我发出的";
                case 3:
                    return "我的设置";
            }
            return null;
        }
    }

}
