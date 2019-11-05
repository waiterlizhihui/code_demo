package com.waiter.design.pattern.state;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FlyweightState
 * @Description 集成了享元模式的共享模式
 * @Author lizhihui
 * @Date 2019/10/28 19:26
 * @Version 1.0
 */
class ShareContext {
    private ShareState shareState;
    private Map<String, ShareState> stateMap = new HashMap<>();

    public ShareContext() {
        shareState = new ConcreteState1();
        stateMap.put("1", shareState);
        shareState = new ConcreteState2();
        stateMap.put("2", shareState);
    }

    public void setShareState(ShareState shareState) {
        this.shareState = shareState;
    }

    public ShareState getShareState(String key) {
        return stateMap.get(key);
    }

    public void handle() {
        shareState.handle(this);
    }
}

abstract class ShareState {
    public abstract void handle(ShareContext context);
}

class ConcreteState1 extends ShareState {
    @Override
    public void handle(ShareContext context) {
        System.out.println("当前状态时：状态1");
        context.setShareState(context.getShareState("2"));
    }
}

class ConcreteState2 extends ShareState {
    @Override
    public void handle(ShareContext context) {
        System.out.println("当前状态：状态2");
        context.setShareState(context.getShareState("1"));
    }
}

public class FlyweightState {
    public static void main(String[] args) {
        ShareContext shareContext = new ShareContext();
        shareContext.handle();
        shareContext.handle();
        shareContext.handle();
        shareContext.handle();
    }
}
