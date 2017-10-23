package com.example.shadowsfailure;

import android.support.annotation.NonNull;

import org.junit.runners.model.InitializationError;
import org.robolectric.DefaultTestLifecycle;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.TestLifecycle;

import java.lang.reflect.Method;

public class CustomTestRunner extends RobolectricTestRunner {

    public CustomTestRunner(Class<?> testClass) throws InitializationError {
        super(testClass);
    }

    @NonNull
    @Override
    protected Class<? extends TestLifecycle> getTestLifecycleClass() {
        return MyTestLifecycle.class;
    }

    public static class MyTestLifecycle extends DefaultTestLifecycle {
        @Override
        public void beforeTest(Method method) {
            super.beforeTest(method);

            ShadowFinalClass.reset();
        }
    }
}
