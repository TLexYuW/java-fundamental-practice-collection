package com.lex.practice.util.functional._lambda._3;

/**
 * @author : Lex Yu
 */
interface TransactionOperation<T> {
    T execute() throws Exception;
}

class TransactionManager {
    public <T> T executeInTransaction(TransactionOperation<T> operation) {
        try {
            // 1. 開始事務
            System.out.println("Starting transaction...");

            // 2. 執行業務邏輯
            T result = operation.execute();

            // 3. 提交事務
            System.out.println("Committing transaction...");
            return result;
        } catch (Exception e) {
            // 4. 回滾事務
            System.out.println("Rolling back transaction...");
            throw new RuntimeException("Transaction failed: " + e.getMessage(), e);
        }
    }
}

public class Transactions {

    public static void main(String[] args) {
        TransactionManager transactionManager = new TransactionManager();

        // 在事務中執行一個操作
        String result = transactionManager.executeInTransaction(() -> {
            System.out.println("Executing business logic...");
            return "Success";
        });

        System.out.println("Result: " + result);
    }

}
