package com.hout.frogcrossingriver;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by hout on 2018/4/5.
 */
class SolutionTest {

    private Solution solution = new Solution();

    @Test
    void canCross() {
        assertEquals(solution.canCross(new int[]{
                0,1,3,4,5,7,9,10,12
        }),
                true);
        assertEquals(solution.canCross(new int[]{
                0,23213
        }),
                false);
        assertEquals(solution.canCross(new int[]{
                0,1,3,5,7,8,10,14
        }),
                true);
        assertEquals(solution.canCross(new int[]{
                0,1,3,4,6,7,9,10,15
        }),
                true);
        assertEquals(solution.canCross(
                IntStream.iterate(0, n -> n + 1)
                        .limit(1000)
                        .toArray()),
                true);

        assertEquals(solution.canCross(
                IntStream.iterate(0, n -> n + 2)
                        .limit(1000)
                        .toArray()),
                false);

        assertEquals(solution.canCross(IntStream.concat(
                IntStream.iterate(0, n -> n + 1)
                        .limit(1000),
                IntStream.of(1037))
                        .toArray()),

                true);
        assertEquals(solution.canCross(IntStream.concat(
                IntStream.iterate(0, n -> n + 1)
                        .limit(1000),
                IntStream.of(1037000))
                        .toArray()),

                false);
    }

    @Test
    void canCross1() {
    }
}