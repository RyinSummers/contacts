package yaoyaoandus.contacts;

/**
 * Created by LJY on 16/8/10.
 */

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
      * A placeholder fragment containing a simple view.
      */
public  class ForthFragment extends android.support.v4.app.Fragment {

    public ForthFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_4, container, false);

//        FloatingActionButton setting=(FloatingActionButton)rootView.findViewById(R.id.setting);
//        setting.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent self_setting_intent=new Intent(getActivity(),self_setting.class);
//                        getActivity().startActivity(self_setting_intent);
//                    }
//                }
//        );
        ImageView imageView=(ImageView) rootView.findViewById(R.id.image_frag4);
        imageView.setImageResource(R.drawable.header6);
        TextView tv_id=(TextView) rootView.findViewById(R.id.id_frag4);
        TextView tv_nick=(TextView) rootView.findViewById(R.id.nickname_frag4);

        Cursor cursor = ((MainActivity) getActivity()).getdatabase().getReadableDatabase().rawQuery("select email,nickname from users", null);
        if (cursor.moveToFirst()) {
            String account = cursor.getString(cursor.getColumnIndex("email"));
            String nickname = cursor.getString(cursor.getColumnIndex("nickname"));
            tv_id.setText(account);
            tv_nick.setText(nickname);
        }
        cursor.close();
        return rootView;
    }
}