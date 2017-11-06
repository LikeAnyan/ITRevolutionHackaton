package com.devguys.itrevolutionhackaton.view.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.devguys.itrevolutionhackaton.ITRevolutionApp;
import com.devguys.itrevolutionhackaton.MainActivity;
import com.devguys.itrevolutionhackaton.R;
import com.devguys.itrevolutionhackaton.base.BaseFragment;
import com.devguys.itrevolutionhackaton.databinding.FragmentLoginBinding;
import com.devguys.itrevolutionhackaton.presenter.LoginPresenter;
import com.devguys.itrevolutionhackaton.util.UiUtills;
import com.devguys.itrevolutionhackaton.view.update.CreateProfileFragment;

import javax.inject.Inject;

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

        binding.btnSignIn.setOnClickListener(btn -> {
            if(!isCredentialsEmpty())
                presenter.signIn(binding.email.getText().toString(), binding.password.getText().toString());
            else loginFailed("Credentials cannot be empty!");
        });

        binding.btnSignUp.setOnClickListener(btn -> {
            if(!isCredentialsEmpty())
                presenter.signUp(binding.email.getText().toString(), binding.password.getText().toString());
            else loginFailed("Credentials cannot be empty!");
        });
    }

    @Override
    public void signInSucceeded() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    @Override
    public void signUpSucceeded() {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new CreateProfileFragment())
                .commit();
    }

    @Override
    public void loginFailed(String message) {
        UiUtills.showToast(message);
    }

    private boolean isCredentialsEmpty() {
        return TextUtils.isEmpty(binding.email.getText()) || TextUtils.isEmpty(binding.password.getText());
    }
}
