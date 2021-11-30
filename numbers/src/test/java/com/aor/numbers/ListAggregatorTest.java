package com.aor.numbers;

import com.sun.tools.javac.jvm.Gen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {

    public List<Integer> list;

    public List<Integer> getList() {
        list = Arrays.asList(1,2,4,2,5);
        return list;
    }

    @Test
    public void sum() {
        list = getList();
        ListAggregator aggregator = new ListAggregator(new ListDeduplicator());
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        list = getList();

        ListAggregator aggregator = new ListAggregator(new ListDeduplicator());
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        list = getList();

        ListAggregator aggregator = new ListAggregator(new ListDeduplicator());
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        list = getList();

        ListAggregator aggregator = new ListAggregator(new ListDeduplicator());
        int distinct = aggregator.distinct(list);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void max_bug_7263() {
        //list = getList();
        list = Arrays.asList(-1, -4, -5);

        ListAggregator aggregator = new ListAggregator(new ListDeduplicator());
        int max = aggregator.max(list);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void distinct_bug_8726() {
        class TestListDeduplicate implements GenericListDeduplicator {

            @Override
            public List<Integer> deduplicate(List<Integer> list) {
                return Arrays.asList(1, 2, 4);
            }
        }
        list = Arrays.asList(1, 2, 4, 2);
        //GenericListDeduplicator gld = new ListDeduplicatorTest();
        ListAggregator aggregator = new ListAggregator(new TestListDeduplicate());
        int distinct = aggregator.distinct(list);

        Assertions.assertEquals(3, distinct);
    }
}
