package com.lex.practice.casual._3;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Demo {

    public static void main(String[] args) {
        AdvancedConfig config = new AdvancedConfig();
        System.out.println("Minutes = " + config.getDurationMinutes()); // 預期輸出 10
    }

    // 父類別：基本設定
    @Setter
    public static class BaseConfig {
        private Integer durationMinutes = 1; // 預設為 1

        @Getter
        private Map<String, String> options = new HashMap<>();

        public Integer getDurationMinutes() {
            return Objects.requireNonNullElse(durationMinutes, 1);
        }

    }

    // 子類別：進階設定，改寫預設值
    public static class AdvancedConfig extends BaseConfig {
        public AdvancedConfig() {
            this.setDurationMinutes(10); // 覆寫預設值為 10
        }
    }
}
