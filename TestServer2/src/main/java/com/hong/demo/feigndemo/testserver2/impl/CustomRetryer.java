package com.hong.demo.feigndemo.testserver2.impl;

import feign.RetryableException;
import feign.Retryer;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class CustomRetryer implements Retryer {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CustomRetryer.class);

    private int retryMaxAttempt;

    private long retryInterval;

    private int attempt = 2;

    public CustomRetryer(int retryMaxAttempt, Long retryInterval) {
        this.retryMaxAttempt = retryMaxAttempt;
        this.retryInterval = retryInterval;
    }

    @Override
    public void continueOrPropagate(final RetryableException e) {
        log.info("Using custom feign retryer : continueOrPropagate");
        if(attempt++ == retryMaxAttempt){
            throw e;
        }
        try {
            Thread.sleep(retryInterval);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public Retryer clone() {
        log.info("Using custom feign retryer : clone");
        return new CustomRetryer(6, 2000L);
    }
}
