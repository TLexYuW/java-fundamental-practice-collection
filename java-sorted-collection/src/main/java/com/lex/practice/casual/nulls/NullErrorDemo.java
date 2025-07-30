package com.lex.practice.casual.nulls;

import java.util.Objects;

public class NullErrorDemo {
    public static void main(String[] args) {
        try {
            nullEqualsError();
        } catch (Exception e) {
            System.out.println("nullEqualsError() ➤ " + e);
        }

        try {
            nullObjectError();
        } catch (Exception e) {
            System.out.println("nullObjectError() ➤ " + e);
        }

        try {
            lazyLoadError();
        } catch (Exception e) {
            System.out.println("lazyLoadError() ➤ " + e);
        }

        safeCompare();
    }

    // ❶ NullPointerException: null.equals(...) 呼叫 null 方法
    public static void nullEqualsError() {
        String apiUserName = null;
        String databaseUserName = "Alice";

        // ❌ null 調用 equals → NPE
        if (!apiUserName.equals(databaseUserName)) {
            System.out.println("User name mismatch!");
        }
    }

    // ❷ NullPointerException: 物件本身為 null，呼叫 method
    public static void nullObjectError() {
        UserInfo input = new UserInfo("Bob");
        UserData dbData = null; // ← 模擬查無資料

        // ❌ dbData 為 null → 調用 method 時 NPE
        if (!input.getUsername().equals(dbData.getAccountName())) {
            System.out.println("Account name mismatch");
        }
    }

    // ❸ ORM 常見錯誤：Session 已關閉仍試圖 lazy load
    public static void lazyLoadError() {
        SessionWrapper session = new SessionWrapper();

        // ❌ 模擬 Hibernate session closed 後觸發懶加載 → IllegalStateException
        String nickname = session.getLazyProfile().getNickName();
        System.out.println("Nickname = " + nickname);
    }

    // ✅ 安全防禦寫法：使用 Objects.equals
    public static void safeCompare() {
        String inputName = null;
        String dbName = "Charlie";

        if (!Objects.equals(inputName, dbName)) {
            System.out.println("✅ Names are different (safe compare)");
        }
    }

    // ===== 模擬資料物件 (DTO / Entity 類) =====

    static class UserInfo {
        private String username;

        public UserInfo(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }
    }

    static class UserData {
        private String accountName = "Bob";

        public String getAccountName() {
            return accountName;
        }
    }

    static class SessionWrapper {
        public LazyProfile getLazyProfile() {
            // 模擬 session 已關閉導致懶加載失敗
            throw new IllegalStateException("DB session is closed. Cannot fetch lazy-loaded profile.");
        }
    }

    static class LazyProfile {
        public String getNickName() {
            return "LazyUser";
        }
    }
}
