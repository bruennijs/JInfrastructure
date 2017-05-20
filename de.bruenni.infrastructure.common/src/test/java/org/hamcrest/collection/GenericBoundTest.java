package org.hamcrest.collection;

import infrastructure.util.IterableUtils;
import infrastructure.util.Tuple2;
import infrastructure.util.Tuple3;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import test.matcher.LambdaMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@RunWith(JUnit4.class)
public class GenericBoundTest {


	@Test
	public void allow_inherited_classes_to_be_passed_to_matcher() throws Exception {

		List<TupleSum> actualSuper = Arrays.asList(new TupleSum(1, "2"), new TupleSum(2, "4"));

		Assert.assertThat(actualSuper, Matchers.hasItem(new LambdaMatcher<Tuple2<Integer, String>>(item -> item.getT1() == 1 && item.getT2().equals("2"), "comparing to 1 and  \"2\"")));
	}

	@Test
	public void name() throws Exception {
		List<Tuple2<Integer, String>> actualSuper = Arrays.asList(new Tuple2<>(1, "1"));

		IsIterableEquivalent.to(Arrays.asList(new Tuple3<>(1, "1", "7")));
	}

	@Test
	public void doVariance() throws Exception {
		List<Tuple2<Integer, String>> aggregated = new ArrayList<>();

		Tuple2<Integer, String> t1 = new Tuple2<>(1, "7");
		Tuple2<Integer, String> t2 = new Tuple2<>(5, "47");

		doAggregate(Arrays.asList(t1, t2), aggregated);

		List<Tuple2<Integer, String>> tupleSumList = aggregated.stream()
			.filter(t -> TupleSum.isInstanceOf(t))
			.collect(Collectors.toList());

		Assert.assertThat(2, IsEqual.equalTo(tupleSumList.size()));

		// assert sum is calculated correctly
		Assert.assertThat(tupleSumList
			.stream()
			.map(ts -> (TupleSum)ts)
			.map(ts -> ts.sum())
			.collect(Collectors.toList()), Matchers.<Integer>contains(8, 52));
	}

	@Test
	public void doUpperBoundConsumer() {
		Tuple3<Integer, String, String> t1 = new Tuple3<>(1, "", "");

		doFuncSuper(t1, new Consumer<Tuple2<Integer, String>>() {
			@Override
			public void accept(Tuple2<Integer, String> p1) {
				System.out.print(p1.getClass().toGenericString());
			}
		});
	}

	@Test
	public void list_test() throws Exception {
		List<Tuple2<Integer, String>> list = new ArrayList<>();

		list.add(new TupleExtended(5, ""));
	}

	public <T extends Tuple2<Integer, String>> void doFuncSuper(T item, Consumer<? super T> consumer)
	{
		consumer.accept(item);
	}

	public void doAggregate(Iterable<? extends Tuple2<Integer, String>> toBeAggregated, List<? super TupleSum> aggregated)
	{
		//aggregated.add(TupleSum.create(new Tuple2<>(1, "")));

		IterableUtils.stream(toBeAggregated)
			.map(TupleSum::create)
			.forEach(tupleSum -> aggregated.add(tupleSum));
	}

	/**
	 * helper class
	 */
	public class TupleExtended extends Tuple2<Integer, String> implements Comparable<Tuple2<Integer, String>> {

		public TupleExtended(Integer i, String s) {
			super(i, s);
		}

		@Override
		public int compareTo(Tuple2<Integer, String> o) {
			return 0;
		}
	}
}

