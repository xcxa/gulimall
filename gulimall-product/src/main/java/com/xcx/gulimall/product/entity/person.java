package com.xcx.gulimall.product.entity;

import java.util.HashSet;
import java.util.Objects;

public class person {
    private int age;
    private String name;

    public static void main(String[] args) {
        int t = 8; // 1000
        System.out.println(t>>>1);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        person person = (person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
