package yaoyaoandus.contacts;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

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

    //public static final String host="http://121.250.217.61";

    public static boolean haslogin=false;

    public PopupWindow popupWindow;

    //public static boolean phone_import;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
        dialog.setMessage("是否导入原手机联系人？");
        dialog.setCancelable(true);
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences.Editor editor=getSharedPreferences("settings",MODE_PRIVATE).edit();
                editor.putBoolean("phone_import",true);
                editor.commit();

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
            }
        });
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SharedPreferences.Editor editor=getSharedPreferences("settings",MODE_PRIVATE).edit();
                editor.putBoolean("phone_import",false);
                editor.commit();
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
            }
        });
        dialog.show();


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
            //final SearchView searchView = (SearchView) item.getActionView();
            final View popView=this.getLayoutInflater().inflate(R.layout.popup_searchresult,null);
            popupWindow = new PopupWindow
                    (popView, LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.MATCH_PARENT);
            popupWindow.setFocusable(true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
            popupWindow.showAtLocation(findViewById(R.id.toolbar), Gravity.NO_GRAVITY,0,0);

            ArrayList<String> choice=new ArrayList<String>();
            choice.add(0,"baba_changjinlu");
            choice.add(1,"18029393201");
            choice.add(2,"iamswing");
            choice.add(3,"code_me_find_me");
            choice.add(4,"582310224");
            choice.add(5,"givemefive");
            choice.add(6,"ljq_fjfz");
            choice.add(7,"zhangxinyu");
            choice.add(8,"copy_keaidekexin");
            choice.add(9,"xuanzhiqian_best");
            choice.add(10,"223397960@163.com");
            choice.add(11,"shuangxuewei8881");
            choice.add(12,"chenxin1996");
            choice.add(13,"tsingtan_developer");
            choice.add(14,"jinanhefeng5");
            choice.add(15,"iqiyi_notofficial");
            choice.add(16,"lovelive8nozomi");
            choice.add(17,"kehuilan_shandong");
            final ListView poplistview=(ListView)popView.findViewById(R.id.listview_searchresult);
            final ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,R.layout.popup_list_item,choice);
            poplistview.setAdapter(adapter);
            poplistview.setTextFilterEnabled(true);
            //poplistview.setVisibility(View.INVISIBLE);
            adapter.getFilter().filter("abcdefghijklmnopqrstuvwxyz");
            SearchView searchView=(SearchView) popView.findViewById(R.id.search_view);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    final String s=query;
                    new Thread(){
                        public void run(){
                            try {
                                Thread.sleep(1500);
                                adapter.getFilter().filter(s);
                            }catch(Exception e){}
                        }
                    }.start();

                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
            poplistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setMessage("是否发送索要名片请求？");
                    dialog.setCancelable(true);
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {
                            Toast.makeText(MainActivity.this, "请求已发送，耐心等待对方回应", Toast.LENGTH_LONG).show();
                        }
                    });
                    dialog.setNegativeButton("取消",new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog, int which) {}
                    });
                    dialog.show();
                }
            });
            return true;
        }
        else if (id == R.id.action_addnew)
        {
            Intent intent=new Intent(MainActivity.this,CardEditActivity.class);
            intent.putExtra("name","");
            intent.putExtra("number","");
            startActivityForResult(intent,2);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch (requestCode) {
            case 2:
                if (resultCode == RESULT_OK) {
                    String newname = data.getStringExtra("name");
                    String newnumber= data.getStringExtra("number");
                    ((FirstFragment)(mSectionsPagerAdapter.getItem(0))).addCard(newname,newnumber);
                }
                break;
            default:
        }
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
