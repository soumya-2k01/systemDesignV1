package com.app.splitwise.split;

import org.springframework.stereotype.Component;

@Component
public class SplitFactory {
    private static SplitFactory instance;

    private SplitFactory() {

    }
    public static synchronized SplitFactory getInstance() {
        if(instance==null)
            instance = new SplitFactory();
        return instance;
    }
    public Split getSplitByType(SplitType splitType) {
        switch (splitType) {
            case EQUAL:
                return new EqualSplit();
            case UNEQUAL:
                return new UnequalSplit();
            case PERCENTAGE:
                return new PercentageSplit();
            default:
                return null;
        }
    }
}
