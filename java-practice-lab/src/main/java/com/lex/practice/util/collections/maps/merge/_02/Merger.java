package com.lex.practice.util.collections.maps.merge._02;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Merger {
    private String a_phone;
    private String b_phone;
    private String c_phone;
    private String d_phone;
    private String e_phone;
    private String f_phone;

    public Merger(String a_phone, String b_phone, String c_phone, String d_phone, String e_phone, String f_phone) {
        this.a_phone = a_phone;
        this.b_phone = b_phone;
        this.c_phone = c_phone;
        this.d_phone = d_phone;
        this.e_phone = e_phone;
        this.f_phone = f_phone;
    }

    public List<String> mergePhoneNumbers() {
        return Stream.of(a_phone, b_phone, c_phone, d_phone, e_phone, f_phone)
                .filter(phone -> phone != null && !phone.isEmpty())
                .distinct()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Merger m = new Merger(null, "123", "456", "123", null, null);
        List<String> phoneNumbers = m.mergePhoneNumbers();
        System.out.println(phoneNumbers);
        System.out.println(phoneNumbers.size());
    }
}
