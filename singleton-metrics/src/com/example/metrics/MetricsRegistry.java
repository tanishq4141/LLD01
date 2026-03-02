package com.example.metrics;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * INTENTION: Global metrics registry (should be a Singleton).
 *
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - Constructor is public -> anyone can create instances.
 * - getInstance() is lazy but NOT thread-safe -> can create multiple instances.
 * - Reflection can call the constructor to create more instances.
 * - Serialization can create a new instance when deserialized.
 *
 * TODO (student):
 *  1) Make it a proper lazy, thread-safe singleton (private ctor)
 *  2) Block reflection-based multiple construction
 *  3) Preserve singleton on serialization (readResolve)
 */
public class MetricsRegistry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static volatile boolean instanceAlreadyCreated = false;
    private final Map<String, Long> counters = new HashMap<>();

    private MetricsRegistry() {
        if (instanceAlreadyCreated) {
            throw new IllegalStateException(
                    "MetricsRegistry singleton violated: "
                            + "reflective constructor call blocked. "
                            + "Use MetricsRegistry.getInstance() instead.");
        }
        instanceAlreadyCreated = true;
    }

    private static final class RegistryHolder {
        private static final MetricsRegistry INSTANCE = new MetricsRegistry();
    }

    public static MetricsRegistry getInstance() {
        return RegistryHolder.INSTANCE;
    }

    @Serial
    private Object readResolve() {
        return getInstance();
    }

    /* ── Counter operations (synchronized for thread-safe mutation) ── */

    public synchronized void setCount(String metricKey, long value) {
        counters.put(metricKey, value);
    }

    public synchronized void increment(String metricKey) {
        counters.put(metricKey, getCount(metricKey) + 1);
    }

    public synchronized long getCount(String metricKey) {
        return counters.getOrDefault(metricKey, 0L);
    }

    public synchronized Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(counters));
    }
}
