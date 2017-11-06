package com.devguys.itrevolutionhackaton.view.update;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.devguys.itrevolutionhackaton.ITRevolutionApp;
import com.devguys.itrevolutionhackaton.R;
import com.devguys.itrevolutionhackaton.base.BaseFragment;
import com.devguys.itrevolutionhackaton.databinding.FragmentUpdateProfileBinding;
import com.devguys.itrevolutionhackaton.presenter.CreateProfilePresenter;
import com.devguys.itrevolutionhackaton.util.UiUtills;

import javax.inject.Inject;

public class CreateProfileFragment extends BaseFragment<FragmentUpdateProfileBinding> implements CreateProfileView {

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

    }

    @Override
    public void updateProfileFailed(String message) {
        UiUtills.showToast(message);
    }
}
