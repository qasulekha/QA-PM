package biz.promanage.tests;

import biz.promanage.base.BaseTest;
import org.testng.annotations.Test;

public class SideBarDemo extends BaseTest {

    @Test
    public void testSideBarDemo() {
        FindLargestNumber(new int[]{23, 5, 12, 65, 21, 78, 43});
        FindSmallestNumber(new int[]{23, 5, 12, 65, 21, 78, 43});
    }

    private void FindSmallestNumber(int[] value) {
        int smallestNumber = value[0];

        for (int i = 1; i < value.length - 1; i++) {
            if (value[i] < smallestNumber) {
                smallestNumber = value[i];
            }
        }

        System.out.println("Largest number in the array : " + smallestNumber);
    }

    private void FindLargestNumber(int[] value) {
        int largestNumber = value[0];

        for (int i = 1; i < value.length - 1; i++) {
            if (value[i] > largestNumber) {
                largestNumber = value[i];
            }
        }

        System.out.println("Largest number in the array : " + largestNumber);
    }
}
