package com.spring;

import java.util.concurrent.atomic.AtomicInteger;

public class Sequence {

    private final AtomicInteger counter = new AtomicInteger();

    private final String id;
    private String prefix;
    private String suffix;

    public Sequence(String id, String prefix, String suffix) {
        this.id = id;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getId() {
        return id;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }
}
