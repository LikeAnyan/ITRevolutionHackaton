package com.devguys.itrevolutionhackaton.view.drink;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.devguys.itrevolutionhackaton.ITRevolutionApp;
import com.devguys.itrevolutionhackaton.R;
import com.devguys.itrevolutionhackaton.base.BaseFragment;
import com.devguys.itrevolutionhackaton.databinding.FragmentAddDrinkBinding;
import com.devguys.itrevolutionhackaton.presenter.AddDrinkPresenter;
import com.devguys.itrevolutionhackaton.util.drink.DrinkDataset;

import javax.inject.Inject;

/**
 * Created by sergey on 06.11.17.
 */

public class AddDrinkFragment extends BaseFragment<FragmentAddDrinkBinding> implements AddDrinkView{
    @Inject
    @InjectPresenter
    AddDrinkPresenter presenter;

    @ProvidePresenter
    AddDrinkPresenter provideAddDrinkPresenter() {
        return presenter;
    }

    @Override
    public void inject() {
        ITRevolutionApp.get().getApplicationModules().inject(this);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_add_drink;
    }

    private DrinkDataset currentDataset;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.drink_types));
        binding.drinkAddSpinnerType.setAdapter(adapter);
        binding.drinkAddSpinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                currentDataset = DrinkDataset.getDrinkDataSet(i + 1);
                binding.drinkAddEtAlcohol.setText(String.valueOf(currentDataset.getAlcoholTurnoversRecommend() * 100));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        binding.drinkAddSpinnerType.setSelection(0);

        binding.drinkAddBtnSave.setOnClickListener(view1 -> {
            if(checkFields()){
                presenter.addDrink(Double.parseDouble(binding.drinkAddEtDrunk.getText().toString()),
                        Double.parseDouble(binding.drinkAddEtAlcohol.getText().toString()) / 100,
                        binding.drinkAddSpinnerType.getSelectedItemPosition() + 1);
            }
        });
    }

    @Override
    public void onDrinkSaved() {
        getActivity().finish();
    }

    private boolean checkFields(){
        boolean success = true;
        double value = Double.parseDouble(binding.drinkAddEtAlcohol.getText().toString()) / 100;
        if(value > currentDataset.getAlcoholTurnoversMax()){
            binding.drinkAddEtAlcohol.setError(getString(R.string.error_wrong_alcohol_type_selected_too_much));
            success = false;
        } else if(value < currentDataset.getAlcoholTurnoversMin()){
            binding.drinkAddEtAlcohol.setError(getString(R.string.error_wrong_alcohol_type_selected_too_less));
            success = false;
        }
        if(Double.parseDouble(binding.drinkAddEtDrunk.getText().toString()) <= 0){
            binding.drinkAddEtDrunk.setError(getString(R.string.error_zero_or_less));
        }
        return success;
    }
}
