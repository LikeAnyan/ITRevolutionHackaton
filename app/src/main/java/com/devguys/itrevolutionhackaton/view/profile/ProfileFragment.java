package com.devguys.itrevolutionhackaton.view.profile;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.devguys.itrevolutionhackaton.ITRevolutionApp;
import com.devguys.itrevolutionhackaton.LoginActivity;
import com.devguys.itrevolutionhackaton.R;
import com.devguys.itrevolutionhackaton.base.BaseFragment;
import com.devguys.itrevolutionhackaton.databinding.FragmentProfileBinding;
import com.devguys.itrevolutionhackaton.presenter.ProfilePresenter;
import com.devguys.itrevolutionhackaton.util.helpers.DrunkHelper;
import com.devguys.itrevolutionhackaton.util.helpers.WaveHelper;
import com.gelitenight.waveview.library.WaveView;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

/**
 * Created by sergey on 05.11.17.
 */

public class ProfileFragment extends BaseFragment<FragmentProfileBinding> implements ProfileView {
    public static final String TAG = ProfileFragment.class.getName();

    @Inject
    @InjectPresenter
    ProfilePresenter presenter;

    @ProvidePresenter
    ProfilePresenter provideProfilePresenter(){ return presenter;}

    @Override
    public void inject() {
        ITRevolutionApp.get().getApplicationModules().inject(this);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_profile;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        binding.setAccount(presenter.getProfile());
        binding.profileIvEdit.setOnClickListener(view1 -> LoginActivity.openAccountEdit(getActivity()));
        initAlcoholInBloodContent(view);
        initStatistics(view);
    }

    private void initAlcoholInBloodContent(View root){
        if(root == null){
            Log.e(TAG, "initAlcoholInBloodContent failed, root == null");
            return;
        }

        double alcoholInBlood = DrunkHelper.getAlcoholInBlood(ITRevolutionApp.get().getAccount(), ITRevolutionApp.get().getDrinkList());
        TextView tvAlcoholInBlood = root.findViewById(R.id.profile_tv_alcohol_in_blood);
        tvAlcoholInBlood.setText(String.format(Locale.getDefault(), "%.2f", alcoholInBlood));

        WaveView waveView = root.findViewById(R.id.profile_wave_drunk_status);
        waveView.setShapeType(WaveView.ShapeType.CIRCLE);
        waveView.setWaveColor(getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorPrimaryDark));
        WaveHelper mWaveHelper = new WaveHelper(waveView);
        mWaveHelper.setAlcohol(alcoholInBlood);
    }

    private void initStatistics(View root){
        if(root == null){
            return;
        }

        List<PieEntry> pieEntries = DrunkHelper.getBeverageDrink(ITRevolutionApp.get().getDrinkList());
        PieChart pieChart = root.findViewById(R.id.profile_piechart_drinks);

        pieChart.setUsePercentValues(false);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);

        Description description = new Description();
        description.setText("");
        pieChart.setDescription(description);

        pieChart.setTransparentCircleColor(Color.WHITE);
        pieChart.setTransparentCircleAlpha(110);

        pieChart.setHoleRadius(58f);
        pieChart.setTransparentCircleRadius(61f);

        PieDataSet dataSet = new PieDataSet(pieEntries, "");
        dataSet.setDrawIcons(false);
        dataSet.setValueTextSize(12);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GRAY);
        colors.add(Color.GREEN);
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);
        colors.add(Color.MAGENTA);

        dataSet.setColors(colors);

        PieData pieData = new PieData(dataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }
}
