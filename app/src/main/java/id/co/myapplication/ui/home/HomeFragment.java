package id.co.myapplication.ui.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.myapplication.R;
import id.co.myapplication.adapter.HomeAdapter;
import id.co.myapplication.model.Home;

public class HomeFragment extends Fragment {

    @BindView(R.id.rv_home)
    RecyclerView rvHome;
    private HomeViewModel homeViewModel;
    private Activity mActivity;
    private Context mContext;
    private HomeAdapter homeAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        mActivity = getActivity();
        mContext = getContext();
        ButterKnife.bind(this, root);

        initData();
        return root;
    }

    private void initData() {
        ArrayList<Home> homes = new ArrayList<>();
        homes.add(new Home("messi", R.drawable.messi_one));
        homes.add(new Home("cr", R.drawable.cr_one));
        homes.add(new Home("mbappe", R.drawable.mbappe_one));

        homeAdapter = new HomeAdapter(homes, mContext);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
        rvHome.setLayoutManager(layoutManager);
        rvHome.setAdapter(homeAdapter);
    }
}