package org.hamcrest.collection;

import infrastructure.util.IterableUtils;
import org.hamcrest.*;
import org.hamcrest.core.IsEqual;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bruenni on 12.05.17.
 */
public class IsIterableEquivalent<T> extends TypeSafeDiagnosingMatcher<Iterable<T>> {

	private final List<Matcher<T>> elementMatchers;

	/**
	 * Constructor
	 * @param items
	 */
	public IsIterableEquivalent(Iterable<T> items) {
		elementMatchers = IterableUtils.stream(items).map(item -> IsEqual.equalTo(item)).collect(Collectors.toList());
	}

	/**
	 * Constructor
	 * @param items
	 */
	public IsIterableEquivalent(T...items) {
		elementMatchers = Arrays.stream(items).map(item -> IsEqual.equalTo(item)).collect(Collectors.toList());
	}

	@Override
	protected boolean matchesSafely(Iterable<T> items, Description mismatchDescription) {

		return false;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("Iterables are not equivalent.");
	}

	/**
	 * Factory method
	 * @param items
	 * @param <T>
	 * @return
	 */
	@Factory
	public static <T> Matcher<Iterable<T>> to(T...items)
	{
		return new IsIterableEquivalent<T>(items);
	}

	/**
	 * Factory method
	 * @param items
	 * @param <T>
	 * @return
	 */
	@Factory
	public static <T> Matcher<Iterable<T>> to(Iterable<T> items)
	{
		return new IsIterableEquivalent<T>(items);
	}
}
