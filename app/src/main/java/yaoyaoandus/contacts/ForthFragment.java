package yaoyaoandus.contacts;

/**
 * Created by LJY on 16/8/10.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        FloatingActionButton setting=(FloatingActionButton)rootView.findViewById(R.id.setting);
        setting.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent self_setting_intent=new Intent(getActivity(),self_setting.class);
                        getActivity().startActivity(self_setting_intent);
                    }
                }
        );
        return rootView;
    }
}