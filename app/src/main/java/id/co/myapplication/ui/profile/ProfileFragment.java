package id.co.myapplication.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.myapplication.R;

public class ProfileFragment extends Fragment {

    @BindView(R.id.iv_profile)
    ImageView ivProfile;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_gender)
    TextView tvGender;
    @BindView(R.id.tv_phonenumber)
    TextView tvPhonenumber;
    private ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, root);

        initData();

        return root;
    }

    private void initData() {
        Glide.with(this).load(R.drawable.cr_one).into(ivProfile);
        tvName.setText("Fazil Muammar");
        tvGender.setText("Male");
        tvPhonenumber.setText("1234567890");
    }
}