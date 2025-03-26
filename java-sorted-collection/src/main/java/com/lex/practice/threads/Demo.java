package com.lex.practice.threads;

import lombok.Getter;

/**
 * @author : Lex Yu
 */
public class Demo {
    public static void main(String[] args) {
        ExecutionInfo info1 = getCurrentExecutionInfo(1);
        System.out.println("Method 1 (Index 1): " + info1);

        ExecutionInfo info2 = getCurrentExecutionInfo(2);
        System.out.println("Method 2 (Index 2): " + info2);

        System.out.println("Simple Class Name: " + info1.getSimpleClassName());
        System.out.println("Method Name: " + info1.getMethodName());

        indirectCall();
    }

    public static void indirectCall() {
        ExecutionInfo info = getCurrentExecutionInfo(1);
        System.out.println("Indirect Call (Index 1): " + info);
    }

    public static ExecutionInfo getCurrentExecutionInfo(int stackTraceIndex) {
        Thread currentThread = Thread.currentThread();

        StackTraceElement[] stackTrace = currentThread.getStackTrace();

        if (stackTraceIndex >= stackTrace.length) {
            stackTraceIndex = stackTrace.length - 1;
        }

        StackTraceElement element = stackTrace[stackTraceIndex];

        String fullClassName = element.getClassName();

        String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);

        String methodName = element.getMethodName();

        String threadName = currentThread.getName();

        return new ExecutionInfo(fullClassName, simpleClassName, methodName, threadName);
    }

    @Getter
    public static class ExecutionInfo {
        private final String fullClassName;
        private final String simpleClassName;
        private final String methodName;
        private final String threadName;

        public ExecutionInfo(String fullClassName, String simpleClassName, String methodName, String threadName) {
            this.fullClassName = fullClassName;
            this.simpleClassName = simpleClassName;
            this.methodName = methodName;
            this.threadName = threadName;
        }

        @Override
        public String toString() {
            return String.format("Class: %s (Simple: %s), Method: %s, Thread: %s",
                    fullClassName, simpleClassName, methodName, threadName);
        }
    }
}
