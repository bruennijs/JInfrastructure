package test.matcher;

import java.util.function.Function;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class LambdaMatcher<T> extends TypeSafeMatcher<T>
{
    private final Function<? super T, Boolean> matcher;
    private final String description;

    public LambdaMatcher(Function<? super T, Boolean> matcher,
                         String description)
    {
        this.matcher = matcher;
        this.description = description;
    }

    @Override
    public void describeTo(Description description)
    {
        description.appendText(this.description);
    }

    @Override
    protected boolean matchesSafely(T item) {
        return matcher.apply(item);
    }
}