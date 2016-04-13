package com.xjp.androidtoolbardemo.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xjp.androidtoolbardemo.R;
import com.xjp.androidtoolbardemo.adapter.RecyclerAdapter;
import com.xjp.androidtoolbardemo.model.ModelBean;

import java.util.List;

/**
 * Description:
 * User: xjp
 * Date: 2015/6/15
 * Time: 15:03
 */

public class GameFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView view = new TextView(getActivity());
        view.setText("我是game");
        return view;
    }
}
