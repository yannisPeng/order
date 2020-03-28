/**
 * @(#)ServiceArgs.java, 2017年2月16日.
 *
 * Copyright 2017 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.netease.order.test;

import java.math.BigDecimal;
import java.util.Collection;

import org.apache.commons.lang.StringUtils;


/**
 * 参数校验工具类
 * 
 * @author hzzhangxuehao
 */
public class CheckUtil {

    public static void checkTrue(final boolean expression,
        final String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void checkTrue(final boolean expression, final String message,
        final Object... args) {
        if (!expression) {
            throw new IllegalArgumentException(String.format(message, args));
        }
    }

    public static void checkFalse(final boolean expression,
        final String message) {
        if (expression) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void checkFalse(final boolean expression,
        final String message, final Object... args) {
        if (expression) {
            throw new IllegalArgumentException(String.format(message, args));
        }
    }

    public static <T> T notNull(final T argument, final String message) {
        if (argument == null) {
            throw new IllegalArgumentException(message);
        }
        return argument;
    }

    public static String notEmpty(final String argument, final String message) {
        if (StringUtils.isEmpty(argument)) {
            throw new IllegalArgumentException(message);
        }
        return argument;
    }

    public static String notBlank(final String argument, final String message) {
        if (StringUtils.isBlank(argument)) {
            throw new IllegalArgumentException(message);
        }
        return argument;
    }

    public static String notBlankOrExceedMaxLen(final String argument,
        final String message, final int maxLength) {
        if (StringUtils.isBlank(argument)) {
            throw new IllegalArgumentException(message);
        }
        if (argument.length() > maxLength) {
            throw new IllegalArgumentException(message);
        }
        return argument;
    }

    public static String notExceedMaxLen(final String argument,
        final String message, final int maxLength) {
        if (StringUtils.isBlank(argument)) {
            return StringUtils.EMPTY;
        }
        if (argument.length() > maxLength) {
            throw new IllegalArgumentException(message);
        }
        return argument;
    }

    public static <E, T extends Collection<E>> T notEmpty(final T argument,
        final String message) {
        if (argument == null) {
            throw new IllegalArgumentException(message);
        }
        if (argument.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
        return argument;
    }

    public static <E, T extends Collection<E>> T sizeEquals(final T argument,
        final int expectedSzie, final String message) {
        if (argument == null) {
            throw new IllegalArgumentException(message);
        }
        if (argument.size() != expectedSzie) {
            throw new IllegalArgumentException(message);
        }
        return argument;
    }

    public static int positive(final int n, final String message) {
        if (n <= 0) {
            throw new IllegalArgumentException(message);
        }
        return n;
    }

    public static long positive(final long n, final String message) {
        if (n <= 0) {
            throw new IllegalArgumentException(message);
        }
        return n;
    }

    public static BigDecimal positive(final BigDecimal n,
        final String message) {
        if (n == null) {
            throw new IllegalArgumentException(message);
        }
        if (BigDecimal.ZERO.compareTo(n) >= 0) {
            throw new IllegalArgumentException(message);
        }
        return n;
    }

    public static int notNegative(final int n, final String message) {
        if (n < 0) {
            throw new IllegalArgumentException(message);
        }
        return n;
    }

    public static long notNegative(final long n, final String message) {
        if (n < 0) {
            throw new IllegalArgumentException(message);
        }
        return n;
    }

    public static BigDecimal notNegative(final BigDecimal n,
        final String message) {
        if (n == null) {
            throw new IllegalArgumentException(message);
        }
        if (BigDecimal.ZERO.compareTo(n) > 0) {
            throw new IllegalArgumentException(message);
        }
        return n;
    }

    public static void positiveRange(final long min, final long max,
        final String message) {
        if (min <= 0) {
            throw new IllegalArgumentException(message);
        }
        if (max <= 0) {
            throw new IllegalArgumentException(message);
        }
        if (min > max) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void positiveRange(final int min, final int max,
        final String message) {
        if (min <= 0) {
            throw new IllegalArgumentException(message);
        }
        if (max <= 0) {
            throw new IllegalArgumentException(message);
        }
        if (min > max) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNegativeRange(final long min, final long max,
        final String message) {
        if (min < 0) {
            throw new IllegalArgumentException(message);
        }
        if (max < 0) {
            throw new IllegalArgumentException(message);
        }
        if (min > max) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNegativeRange(final int min, final int max,
        final String message) {
        if (min < 0) {
            throw new IllegalArgumentException(message);
        }
        if (max < 0) {
            throw new IllegalArgumentException(message);
        }
        if (min > max) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> void equals(final T a, final T b, final String message) {
        if (a == null) {
            throw new IllegalArgumentException(message);
        }
        if (b == null) {
            throw new IllegalArgumentException(message);
        }
        if (a != b && !a.equals(b)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static int equals(final int value, final int expected,
        final String message) {
        if (value != expected) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public static long equals(final long value, final long expected,
        final String message) {
        if (value != expected) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public static <T> void notEquals(final T a, final T b,
        final String message) {
        if (a == null) {
            throw new IllegalArgumentException(message);
        }
        if (b == null) {
            throw new IllegalArgumentException(message);
        }
        if (a == b || a.equals(b)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static long greater(final long value, final long minValue,
        String message) {
        if (value <= minValue) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public static int greater(final int value, final int minValue,
        final String message) {
        if (value <= minValue) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public static long greaterEquals(final long value, final long minValue,
        String message) {
        if (value < minValue) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public static int greaterEquals(final int value, final int minValue,
        final String message) {
        if (value < minValue) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public static int less(final int value, final int maxValue,
        final String message) {
        if (value >= maxValue) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public static long less(final long value, final long maxValue,
        final String message) {
        if (value >= maxValue) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public static int lessEquals(final int value, final int maxValue,
        final String message) {
        if (value > maxValue) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public static long lessEquals(final long value, final long maxValue,
        final String message) {
        if (value > maxValue) {
            throw new IllegalArgumentException(message);
        }
        return value;
    }

    public static void between(final int n, final int min, final int max,
        final String message) {
        // min <= n <= max
        if (n < min) {
            throw new IllegalArgumentException(message);
        }
        if (n > max) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void between(final long n, final long min, final long max,
        final String message) {
        // min <= n <= max
        if (n < min) {
            throw new IllegalArgumentException(message);
        }
        if (n > max) {
            throw new IllegalArgumentException(message);
        }
    }

}
