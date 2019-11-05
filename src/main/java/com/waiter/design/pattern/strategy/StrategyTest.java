package com.waiter.design.pattern.strategy;

/**
 * @ClassName StrategyTest
 * @Description 策略模式的代码示例
 * @Author lizhihui
 * @Date 2019/10/23 19:12
 * @Version 1.0
 */

/**
 * 抽象策略类
 */
interface Strategy {
    /**
     * 策略方法
     */
    void strategyMethod();
}

/**
 * 具体策略类A
 */
class ConcreteStrategyA implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("具体策略A的策略方法被访问");
    }
}

/**
 * 具体策略类B
 */
class ConcreteStrategyB implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("具体策略B的策略方法被访问");
    }
}

class Context {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }
}

public class StrategyTest {
    public static void main(String[] args) {
        //这个环境类好像有点多余啊，直接依赖策略接口不就可以吗?
        Context context = new Context();
        Strategy strategy = new ConcreteStrategyA();
        context.setStrategy(strategy);
        context.strategyMethod();

        strategy = new ConcreteStrategyB();
        context.setStrategy(strategy);
        context.strategyMethod();
    }
}
