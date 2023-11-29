import static org.junit.Assert.*;

import org.junit.*;

import java.util.Arrays;
import java.util.List;
import java.util.*;

class IsMoon implements StringChecker {
    public boolean checkString(String s) {
        return s.equalsIgnoreCase("moon");
    }
}

public class TestListExamples {

    int grade = 0;

    @Test(timeout = 500)
    public void testMergeRightEnd() {
        List<String> left = Arrays.asList("a", "b", "c");
        List<String> right = Arrays.asList("a", "d");
        List<String> merged = ListExamples.merge(left, right);
        List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
        assertEquals(expected, merged);
        grade += 20;
    }

    @Test(timeout = 500)
    public void testEmpty() {
        List<String> left = Arrays.asList();
        List<String> right = Arrays.asList();
        List<String> merged = ListExamples.merge(left, right);
        List<String> expected = Arrays.asList();
        assertEquals(expected, merged);
        grade += 20;
    }

    @Test(timeout = 500)
    public void testMergeLeftEnd() {
        List<String> left = Arrays.asList("b", "c", "e");
        List<String> right = Arrays.asList("a", "d");
        List<String> merged = ListExamples.merge(left, right);
        List<String> expected = Arrays.asList("a", "b", "c", "d", "e");
        assertEquals(expected, merged);
        grade += 20;
    }

    @Test(timeout = 500)
    public void testMergeOneEmpty() {
        List<String> left = Arrays.asList("b", "c", "e");
        List<String> right = Arrays.asList();
        List<String> merged = ListExamples.merge(left, right);
        List<String> expected = Arrays.asList("b", "c", "e");
        assertEquals(expected, merged);
        grade += 20;
    }

    @Test(timeout = 500)
    public void testMergeMany() {
        List<String> left = Arrays.asList("b", "c", "e");
        List<String> right = Arrays.asList("a", "a", "a", "a", "a", "f");
        List<String> merged = ListExamples.merge(left, right);
        List<String> expected = Arrays.asList("a", "a", "a", "a", "a", "b", "c", "e", "f");
        assertEquals(expected, merged);
        grade += 20;
    }
}
