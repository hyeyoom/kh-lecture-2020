package kr.or.iei.ex20201117;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Quicksort {

    public static List<Integer> sort(List<Integer> origin) {
        // 0. 탈출 조건 선정
        if (origin.isEmpty()) {
            return origin;
        }

        // 1. 피벗 선정
        final Integer pivot = origin.get(0);

        // 2. 피벗 중심으로 분류
        List<Integer> less = origin.stream().filter(x -> x < pivot).collect(Collectors.toList());
        List<Integer> greater = origin.stream().filter(x -> x > pivot).collect(Collectors.toList());
        final List<Integer> pivots = origin.stream().filter(x -> x.equals(pivot)).collect(Collectors.toList());

        // 3. 분류된 새로운 리스트들을 정렬
        less = sort(less);
        greater = sort(greater);

        // 4. 취합
        less.addAll(pivots);
        less.addAll(greater);

        return less;
    }
}
