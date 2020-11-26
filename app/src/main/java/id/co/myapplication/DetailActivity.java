package id.co.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.slider)
    SliderLayout mSlider;
    private String name;
    private ArrayList<Integer> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        initData();
        initSlider();
    }

    
    private void initSlider() {
        for (Integer image : imageList) {
            TextSliderView textSliderView = new TextSliderView(this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(image)
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            mSlider.addSlider(textSliderView);
        }
        mSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSlider.setCustomAnimation(new DescriptionAnimation());
        mSlider.setDuration(2500);
    }

    private void initData() {
        Intent intent = getIntent();
        imageList = new ArrayList<>();
        name = intent.getStringExtra("name");
        if (name.equalsIgnoreCase("messi")) {
            imageList.add(R.drawable.messi_one);
            imageList.add(R.drawable.messi_two);
            imageList.add(R.drawable.messi_three);
        } else if (name.equalsIgnoreCase("cr")) {
            imageList.add(R.drawable.cr_one);
            imageList.add(R.drawable.cr_two);
            imageList.add(R.drawable.cr_three);
        } else {
            imageList.add(R.drawable.mbappe_one);
            imageList.add(R.drawable.mbappe_two);
            imageList.add(R.drawable.mbappe_three);
        }
    }
}