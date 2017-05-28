package test.matcher;

import java.util.function.Predicate;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class LambdaMatcher<T> extends TypeSafeMatcher<T>
{
    private final Predicate<? super T> matcher;
    private final String description;

    public LambdaMatcher(Predicate<? super T> matcher,
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
        return matcher.test(item);
    }

    public static <T> LambdaMatcher<? super T> isMatching(Predicate<? super T> predicate)
    {
        return LambdaMatcher.isMatching(predicate, "Lambda matcher's predicate is successful");
    }

    public static <T> LambdaMatcher<? super T> isMatching(Predicate<? super T> predicate, String description)
    {
        return new LambdaMatcher<>(predicate, description);
    }
}