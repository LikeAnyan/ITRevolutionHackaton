package com.devguys.itrevolutionhackaton.view.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.devguys.itrevolutionhackaton.ITRevolutionApp;
import com.devguys.itrevolutionhackaton.R;
import com.devguys.itrevolutionhackaton.base.BaseFragment;
import com.devguys.itrevolutionhackaton.databinding.FragmentLoginBinding;
import com.devguys.itrevolutionhackaton.presenter.LoginPresenter;

import javax.inject.Inject;

/**
 * Created by sergeyboy on 04.11.17.
 */

public class LoginFragment extends BaseFragment<FragmentLoginBinding> implements LoginView {
    @Inject
    @InjectPresenter
    LoginPresenter presenter;

    @ProvidePresenter
    LoginPresenter provideLoginPresenter(){
        return presenter;
    }

    @Override
    public void inject() {
        ITRevolutionApp.get().getApplicationModules().inject(this);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_login;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.onBtnPressed();
    }

    @Override
    public void onButtonPressed(String text) {

    }


}
