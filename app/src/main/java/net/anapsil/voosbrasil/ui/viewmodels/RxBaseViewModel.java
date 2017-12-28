package net.anapsil.voosbrasil.ui.viewmodels;

import android.databinding.ObservableBoolean;

import io.reactivex.disposables.CompositeDisposable;

public abstract class RxBaseViewModel extends BaseViewModel {
    public final ObservableBoolean isLoading = new ObservableBoolean(false);
    protected CompositeDisposable disposable;

    @Override
    public void onViewCreated() {
        disposable = new CompositeDisposable();
    }

    @Override
    public void onDestroyView() {
        disposable.dispose();
    }


}
