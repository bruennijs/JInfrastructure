package infrastructure.org.hamcrest.collection;

import infrastructure.util.IterableUtils;
import org.hamcrest.*;
import org.hamcrest.core.AnyOf;
import org.hamcrest.core.IsEqual;

import java.util.ArrayList;
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
	public IsIterableEquivalent(T...items) {
		elementMatchers = Arrays.stream(items).map(item -> IsEqual.equalTo(item)).collect(Collectors.toList());
	}

	@Override
	protected boolean matchesSafely(Iterable<T> items, Description mismatchDescription) {

		List<? super T> examingList = IterableUtils.toList(items);

		if (examingList.size() != elementMatchers.size())
		{
			mismatchDescription.appendText(String.format("Size of examing iterable and comparing iterable differs [examing=%1%, comparing=%2%]", examingList.size(), elementMatchers.size()));
			return false;
		}

		return true;

/*		for ( item : items)
		{
			AnyOf.anyOf(elementMatchers)
		}*/
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
}
