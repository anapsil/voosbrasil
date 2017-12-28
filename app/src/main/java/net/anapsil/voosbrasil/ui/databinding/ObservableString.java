package net.anapsil.voosbrasil.ui.databinding;

import android.databinding.BaseObservable;

public class ObservableString extends BaseObservable {
    String value;

    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

    public String get() {
        return value != null ? value : "";
    }

    public void set(String value) {
        if (!equals(this.value, value)) {
            this.value = value;
            notifyChange();
        }
    }

    public boolean isEmpty() {
        return value == null || value.isEmpty();
    }
}
