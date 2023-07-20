package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {
    @Test
    public void testBubbleSort() {
        int[] numbers = {43, 76, 1, 7, 21, 65, 57, 33, 11, 123};
        Bubble.sort(numbers);
        int[] expectedNumbers = {1, 7, 11, 21, 33, 43, 57, 65, 76, 123};
        Assert.assertArrayEquals(numbers, expectedNumbers);
    }
}
