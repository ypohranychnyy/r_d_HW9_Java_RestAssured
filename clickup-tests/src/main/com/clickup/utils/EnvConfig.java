package com.clickup.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvConfig {
    private static final Dotenv dotenv = Dotenv.load();

    public static String getEnv(String key) {
        return dotenv.get(key);
    }
}