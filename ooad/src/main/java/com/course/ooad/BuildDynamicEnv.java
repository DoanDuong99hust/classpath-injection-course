package com.course.ooad;

import java.util.HashMap;
import java.util.Map;

public class BuildDynamicEnv {

    private Map<String, Integer> envSizeByKey;

    public BuildDynamicEnv() {
        envSizeByKey = new HashMap<>();
        envSizeByKey.put("DEV", 1);
        envSizeByKey.put("SIT", 10);
        envSizeByKey.put("UAT", 20);
        envSizeByKey.put("PROD", 30);
    }

    public Integer getBudget(String env) {
        return 100*envSizeByKey.get(env);
    }
}
