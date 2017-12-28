package net.anapsil.voosbrasil.ui.databinding;

import android.databinding.BindingAdapter;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import net.anapsil.voosbrasil.R;
import net.anapsil.voosbrasil.helpers.TextWatcherWrapper;

public class FormCustomBindings {

    @BindingAdapter("binding")
    public static void bindText(TextView view, ObservableString text) {
        Pair<ObservableString, TextWatcher> pair = (Pair) view.getTag(R.id.bound);
        if (pair == null || pair.first != text) {
            if (pair != null) {
                view.removeTextChangedListener(pair.second);
            }

            TextWatcherWrapper watcher = new TextWatcherWrapper() {
                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    text.set(charSequence.toString());
                }
            };

            view.setTag(R.id.bound, new Pair<>(text, watcher));
            view.addTextChangedListener(watcher);
        }

        String newValue = text.get();
        if (!view.getText().toString().equals(newValue)) {
            view.setText(newValue);
        }
    }

    @BindingAdapter("onTouch")
    public static void handleTouch(EditText view, View.OnTouchListener touchListener) {
        view.setOnTouchListener(touchListener);
    }
}
