package org.hamcrest.collection;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.core.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.data.domain.ExampleMatcher;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bruenni on 12.05.17.
 */
@RunWith(JUnit4.class)
public class IsIterableEquivalentTest {
	@Test
	public void when_size_differs_expect_matches_fails() throws Exception {
		List<String> actual = Arrays.asList("a", "b");

		Assert.assertEquals(false, IsIterableEquivalent.to(Arrays.asList("a")).matches(actual));
	}

	@Test
	public void IsIterableContaining_expect_is_like_collectionequivalent() throws Exception {
		List<String> actual = Arrays.asList("b", "a");

		Assert.assertThat(actual, Matchers.containsInAnyOrder(Arrays.asList(IsEqual.equalTo("a"), IsEqual.equalTo("b"))));
		Assert.assertThat(actual, IsIterableContainingInAnyOrder.containsInAnyOrder(Arrays.asList(IsEqual.equalTo("a"), IsEqual.equalTo("b"))));

		Assert.assertThat(actual, IsNot.not(Matchers.contains(Arrays.asList(IsEqual.equalTo("a"), IsEqual.equalTo("b")))));

		// in order
		Assert.assertThat(actual, Matchers.contains(Arrays.asList(IsEqual.equalTo("b"), IsEqual.equalTo("a"))));
	}

	@Test
	public void IsIterableContaining_expect_is_like_collectionequivalent_with_specific_matcher() throws Exception {
		List<String> actual = Arrays.asList("ab", "ac");

		Assert.assertThat(actual, Matchers.containsInAnyOrder(Arrays.asList(
			StringContains.containsString("a"),
			StringContains.containsString("a"))));
	}

	@Test
	public void IsCollectionContaining_test() throws Exception {
		List<String> actual = Arrays.asList("ab", "ac");

		Assert.assertThat(actual, IsCollectionContaining.hasItem(StringContains.containsString("a")));
		Assert.assertThat(actual, IsCollectionContaining.hasItem(StringContains.containsString("b")));
		Assert.assertThat(actual, IsCollectionContaining.hasItem(StringContains.containsString("c")));
		Assert.assertThat(actual, IsNot.not(IsCollectionContaining.hasItem(StringContains.containsString("d"))));
	}

	@Test

	public void IsIterableContaining_expect_understand_them_correclty_3() throws Exception {
		List<String> actual = Arrays.asList("ab", "ac");

		Assert.assertThat(actual, IsNot.not(Matchers.containsInAnyOrder(Arrays.asList(StringContains.containsString("a")))));
	}
}

