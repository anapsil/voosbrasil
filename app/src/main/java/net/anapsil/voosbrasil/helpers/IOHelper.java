package net.anapsil.voosbrasil.helpers;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class IOHelper {

    public static String loadJSONFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            Log.e("loadJSONFromAsset", ex.getMessage());
        }

        return json;
    }
}
