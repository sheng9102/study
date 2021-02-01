package com.sweet.util.study.innerstaticclass;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@ToString
public class Monitor {
    @ToString
    public static class Key {
        private String url;
        private String desc;

        public Key(String url, String desc) {
            this.url = url;
            this.desc = desc;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return url.equals(key.url);
        }

        @Override
        public int hashCode() {
            return Objects.hash(url);
        }
    }

    @ToString
    public static class Value {
        AtomicInteger count = new AtomicInteger();
        float avgTime;
        AtomicLong totalTime = new AtomicLong();
    }

    private ConcurrentHashMap<Key, Value> monitors = new ConcurrentHashMap<>();

    public void visit(String url, String desc, long timeCost) {
        Key key = new Key(url, desc);
        Value value = monitors.get(key);
        if (value == null) {
            synchronized (this) {
                value = new Value();
                monitors.put(key, value);
            }
        }

        value.count.getAndIncrement();
        value.totalTime.getAndAdd(timeCost);
        value.avgTime = value.totalTime.get() / value.count.get();
    }
}
