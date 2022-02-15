package com.example.aop.introduction.programmatically;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

// Default implementation for advisors that performs one or more introductions
public class FlyerAdvisor extends DefaultIntroductionAdvisor {

    public FlyerAdvisor() {
        super(new FlyerImpl());
    }

}
