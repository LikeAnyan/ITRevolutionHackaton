package com.devguys.itrevolutionhackaton.view.update;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.devguys.itrevolutionhackaton.ITRevolutionApp;
import com.devguys.itrevolutionhackaton.MainActivity;
import com.devguys.itrevolutionhackaton.R;
import com.devguys.itrevolutionhackaton.base.BaseFragment;
import com.devguys.itrevolutionhackaton.databinding.FragmentUpdateProfileBinding;
import com.devguys.itrevolutionhackaton.presenter.CreateProfilePresenter;
import com.devguys.itrevolutionhackaton.util.UiUtills;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

public class CreateProfileFragment extends BaseFragment<FragmentUpdateProfileBinding> implements CreateProfileView{

    @Inject
    @InjectPresenter
    CreateProfilePresenter presenter;

    @ProvidePresenter
    CreateProfilePresenter provideLoginPresenter(){
        return presenter;
    }

    @Override
    public void inject() {
        ITRevolutionApp.get().getApplicationModules().inject(this);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_update_profile;
    }

    @Override
    public void updateProfileSucceeded() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void updateProfileFailed(String message) {
        UiUtills.showToast(message);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setAccount(presenter.getProfile());

        binding.updateProfileSave.setOnClickListener((view1) -> {
            if(checkFields()){
                Date date;
                try{
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    date = dateFormat.parse(binding.updateProfileEtBirthday.getText().toString());
                } catch (ParseException e){
                    e.printStackTrace();
                    UiUtills.showToast(R.string.error_error);
                    return;
                }
                presenter.updateProfile(binding.updateProfileEtUsername.getText().toString(),
                        date.getTime(),
                        binding.updateProfileSexMale.isChecked(),
                        Double.parseDouble(binding.updateProfileEtWeight.getText().toString()),
                        binding.updateProfileUseFingerprint.isChecked());
            }
        });
    }

    private boolean checkFields(){
        boolean success = true;
        if(binding.updateProfileEtUsername.length() <= 0){
            success = false;
            binding.updateProfileEtUsername.setError(getResources().getString(R.string.error_empty_field));
        }
        if(binding.updateProfileEtBirthday.length() != 10){
            success = false;
            binding.updateProfileEtBirthday.setError(getResources().getString(R.string.error_date_format));
        } else{
            try{
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.parse(binding.updateProfileEtBirthday.getText().toString());
            } catch (ParseException e){
                success = false;
                binding.updateProfileEtBirthday.setError(getResources().getString(R.string.error_date_format));
            }
        }
        if(binding.updateProfileEtWeight.length() <= 0){
            success = false;
            binding.updateProfileEtWeight.setError(getResources().getString(R.string.error_empty_field));
        } else if(binding.updateProfileEtWeight.length() > 3){
            success = false;
            binding.updateProfileEtWeight.setError(getResources().getString(R.string.error_error));
        } else if(Double.parseDouble(binding.updateProfileEtWeight.getText().toString()) <= 0d){
            success = false;
            binding.updateProfileEtWeight.setError(getResources().getString(R.string.error_zero_or_less));
        }
        return success;
    }
}
