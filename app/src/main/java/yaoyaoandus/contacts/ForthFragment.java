package yaoyaoandus.contacts;

/**
 * Created by LJY on 16/8/10.
 */

import android.os.Bundle;
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
        return rootView;
    }
}