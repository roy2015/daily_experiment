package com.guo.roy.research.misc.targetObject;

import java.security.SecureRandom;
import java.util.Random;

public class SessionIdUtil {

    protected static Random random;
    private static boolean             weakRandom;
    private static volatile Object     lock     = new Object();

    private static final SessionIdUtil instance = new SessionIdUtil();

    private SessionIdUtil() {
        try {
            random = new SecureRandom();
            weakRandom = false;
        } catch (Exception e) {
            random = new Random();
            weakRandom = true;
        }
    }

    public static SessionIdUtil getInstance() {
        return instance;
    }

    public String generate() {
        synchronized (lock) {
            String id = null;
            while (id == null || id.length() == 0) {
                long r0 = weakRandom ? (hashCode() ^ Runtime.getRuntime().freeMemory()
                                        ^ random.nextInt() ^ (System.currentTimeMillis() << 32))
                    : random.nextLong();
                long r1 = random.nextLong();
                if (r0 < 0) {
                    r0 = -r0;
                }
                if (r1 < 0) {
                    r1 = -r1;
                }
                id = Long.toString(r0, 36) + Long.toString(r1, 36);
            }
            return id.toUpperCase();
        }
    }

}