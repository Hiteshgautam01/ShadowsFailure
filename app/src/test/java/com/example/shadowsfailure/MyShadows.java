package com.example.shadowsfailure;

import org.robolectric.internal.ShadowProvider;
import org.robolectric.shadow.api.Shadow;

import java.util.HashMap;

public class MyShadows implements ShadowProvider {
    private static final HashMap<String, String> SHADOW_MAP = new HashMap<>();

    static {
        SHADOW_MAP.put("com.example.shadowsfailure.FinalClass", "com.example.shadowsfailure.ShadowFinalClass");
    }

    public static ShadowFinalClass shadowOf(FinalClass finalClass) {
        return shadowOf_(finalClass);
    }

    @Override
    public void reset() {
        // MpaTestLifecycle handles reset between each test for now
    }

    @Override
    public String[] getProvidedPackageNames() {
        return new String[]{
                "com.example.shadowsfailure"
        };
    }

    @Override
    public java.util.Map<String, String> getShadowMap() {
        return SHADOW_MAP;
    }

    @SuppressWarnings("unchecked")
    private static <T> T shadowOf_(Object object) {
        return (T) Shadow.extract(object);
    }
}
