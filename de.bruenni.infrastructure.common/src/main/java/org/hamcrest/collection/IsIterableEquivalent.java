package org.hamcrest.collection;

import infrastructure.util.IterableUtils;
import org.hamcrest.*;
import org.hamcrest.core.IsEqual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by bruenni on 12.05.17.
 */
public class IsIterableEquivalent<T> extends TypeSafeDiagnosingMatcher<Iterable<T>> {

	private final List<Matcher<? super T>> elementMatchers;
	private final Matcher<Iterable<? extends T>> iterableMatcher;

	/**
	 * Constructor
	 * @param items
	 */
	public IsIterableEquivalent(Iterable<T> items) {
		elementMatchers = IterableUtils.stream(items).map(item -> IsEqual.equalTo(item)).collect(Collectors.toList());
		iterableMatcher = Matchers.containsInAnyOrder(elementMatchers);
	}

	/**
	 * Constructor
	 * @param items
	 */
	public IsIterableEquivalent(T...items) {
		elementMatchers = Arrays.stream(items).map(item -> IsEqual.equalTo(item)).collect(Collectors.toList());
		//elementMatchers.stream().collect(Collectors.toList());
		iterableMatcher = Matchers.containsInAnyOrder(elementMatchers);
	}

	@Override
	protected boolean matchesSafely(Iterable<T> items, Description mismatchDescription) {

		boolean matches = iterableMatcher.matches(items);
		if (!matches)
		{
			mismatchDescription.appendText("Iterabes are not equivalent -> ");
			iterableMatcher.describeMismatch(items, mismatchDescription);
		}

		return matches;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("two Iterables are equivalent.");
	}

	/**
	 * Factory method
	 * @param items
	 * @param <T>
	 * @return
	 */
	@Factory
	public static <V> Matcher<Iterable<V>> to(V...items)
	{
		return new IsIterableEquivalent<V>(items);
	}

	/**
	 * Factory method
	 * @param items
	 * @param <V>
	 * @return
	 */
	@Factory
	public static <V> Matcher<Iterable<V>> to(Iterable<V> items)
	{
		return new IsIterableEquivalent<V>(items);
	}
}
