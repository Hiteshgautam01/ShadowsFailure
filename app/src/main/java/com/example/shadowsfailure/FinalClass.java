package com.example.shadowsfailure;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class FinalClass {

    @Nullable
    private static FinalClass instance;

    @Nullable
    static FinalClass getInstance() {
        if(instance == null){
            instance = new FinalClass();
        }
        return instance;
    }

    private Context context;

    private FinalClass() {
        // nop
    }

    public void init(@NonNull Context context) {
        this.context = context; // TODO check not null
    }
}
