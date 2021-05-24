package edu.bt.pythonquiz.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import edu.bt.pythonquiz.R;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v =  inflater.inflate(R.layout.fragment_home, container, false);
//        Button btn_logout = (Button)v.findViewById(R.id.btn_logout);
//        Button btn_verifyEmail = (Button)v.findViewById(R.id.btn_verifyEmail);
//        TextView verifyMEssage = (TextView)v.findViewById()
       return v;
    }
}