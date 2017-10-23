package com.example.shadowsfailure;

import android.content.Context;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.annotation.internal.DoNotInstrument;

import static com.google.common.base.Preconditions.checkNotNull;

@DoNotInstrument
@Implements(FinalClass.class)
class ShadowFinalClass {

    private Context context;


    @SuppressWarnings("checkstyle:methodname") // Justification: Shadow class constructor method naming convention
    public void __constructor__() {
        // nop
    }

    @Implementation
    public void init(Context context) {
        context = checkNotNull(context);
    }

    public static void reset() {
        FinalClass finalClass = FinalClass.getInstance();

        MyShadows.shadowOf(finalClass).resetInstance();
    }

    private void resetInstance() {
        context = null;
    }
}
