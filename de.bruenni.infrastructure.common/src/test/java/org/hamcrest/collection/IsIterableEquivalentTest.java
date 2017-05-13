package org.hamcrest.collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

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
	public void when_size_equal_expect_matches_succeeds() throws Exception {
		List<String> actual = Arrays.asList("b", "a");

		Assert.assertThat(actual, IsIterableEquivalent.to("a", "b"));
		Assert.assertThat(actual, IsIterableEquivalent.to(Arrays.asList("a", "b")));
	}
}
