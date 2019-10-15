package com.waiter.io.utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @ClassName Calculator
 * @Description TOOD
 * @Author lizhihui
 * @Date 2019/8/16 16:29
 * @Version 1.0
 */
public final class Calculator {
    private final static ScriptEngine SCRIPT_ENGINE = new ScriptEngineManager().getEngineByName("JavaScript");

    public static Object cal(String expression) throws ScriptException {
        return SCRIPT_ENGINE.eval(expression);
    }
}
