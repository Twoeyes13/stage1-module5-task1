package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return (x) -> {
            for (String el : x) {
                if (!el.substring(0, 1).equals(el.substring(0, 1).toUpperCase()) || el.matches("-?\\d+(\\.\\d+)?")) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            List<Integer> result = new ArrayList<>();
            for (Integer el : x) {
                if (el % 2 == 0) {
                    result.add(el);
                }

            }
            x.addAll(result);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> result = new ArrayList<>();
            for (String el : values) {
                if (el.substring(0, 1).equals(el.substring(0, 1).toUpperCase()) && el.split(" ").length > 3 && el.substring(el.length() - 1).equals(".")) {
                    result.add(el);
                }
            }
            return result;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> result = new HashMap<>();
            for (String el : x) {
                result.put(el, el.length());
            }
            return result;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>();
            result.addAll(list1);
            result.addAll(list2);
            return result;
        };
    }
}
