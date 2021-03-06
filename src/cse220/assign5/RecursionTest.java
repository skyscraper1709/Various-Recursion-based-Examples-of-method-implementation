/**
 * RecursionTest.java
 */
package cse220.assign5;

import java.util.Random;

import junit.framework.TestCase;

/**
 * Testcases for cse220.assign5.RecursionTest class.
 */
public class RecursionTest extends TestCase {

    // Test data used, but not modified, by more than one test.
    // data_odd_unsorted - contains unordered even number of values
    // data_odd_sorted - same data, but sorted
    // data_even_unsorted - contains unordered odd number of values
    // data_even_sorted - same data, but sorted
    private Integer[] data_even_unsorted;
    private Integer[] data_even_sorted;
    private Integer[] data_odd_unsorted;
    private Integer[] data_odd_sorted;

    /**
     * Sets up the testing framework by creating the shared test data.
     * This method is called exactly once before any test is run.
     */
    protected void setUp() throws Exception {
        super.setUp();

        // Prepare data for testing
        data_even_unsorted = new Integer[] { 3, 1, 17, 2, 4, 9 };
        data_even_sorted = java.util.Arrays.copyOf(data_even_unsorted,
                data_even_unsorted.length);
        java.util.Arrays.sort(data_even_sorted);

        data_odd_unsorted = new Integer[] { 3, 1, 17, 2, 4, 9, 13 };
        data_odd_sorted = java.util.Arrays.copyOf(data_odd_unsorted,
                data_odd_unsorted.length);
        java.util.Arrays.sort(data_odd_sorted);
    }

    /**
     * Test method for
     * {@link cse220.assign5.Recursion#linearSearch(java.lang.Object[], int, int, java.lang.Object)}
     * .
     */
    public final void testLinearSearch() {
        for (int i = 0; i < data_even_sorted.length; i++) {
            Object key = data_even_sorted[i];
            int index = Recursion.linearSearch(data_even_sorted, 0,
                    data_even_sorted.length - 1, key);
            assertEquals(i, index);
        }
        for (int i = 0; i < data_odd_sorted.length; i++) {
            Object key = data_odd_sorted[i];
            int index = Recursion.linearSearch(data_odd_sorted, 0,
                    data_odd_sorted.length - 1, key);
            assertEquals(i, index);
        }

        // Try a non-existent value in both odd and even-sized arrays.
        Integer nonExKey = data_odd_sorted[data_odd_sorted.length - 1] + 100;
        int index = Recursion.linearSearch(data_odd_sorted, 0,
                data_odd_sorted.length - 1, nonExKey);
        assertEquals(-1, index);
        index = Recursion.linearSearch(data_even_sorted, 0,
                data_even_sorted.length - 1, nonExKey);
        assertEquals(-1, index);
    }

    /**
     * Test method for
     * {@link cse220.assign5.Recursion#binarySearch(java.lang.Object[], int, int, java.lang.Object)}
     * .
     */
    public final void testBinarySearch() {
        for (int i = 0; i < data_even_sorted.length; i++) {
            Object key = data_even_sorted[i];
            int index = Recursion.binarySearch(data_even_sorted, 0,
                    data_even_sorted.length - 1, key);
            assertEquals(i, index);
        }
        for (int i = 0; i < data_odd_sorted.length; i++) {
            Object key = data_odd_sorted[i];
            int index = Recursion.binarySearch(data_odd_sorted, 0,
                    data_odd_sorted.length - 1, key);
            assertEquals(i, index);
        }

        // Try a non-existent value in both odd and even-sized arrays.
        Integer nonExKey = data_odd_sorted[data_odd_sorted.length - 1] + 100;
        int index = Recursion.binarySearch(data_odd_sorted, 0,
                data_odd_sorted.length - 1, nonExKey);
        assertEquals(-1, index);
        index = Recursion.binarySearch(data_even_sorted, 0,
                data_even_sorted.length - 1, nonExKey);
        assertEquals(-1, index);
    }

    /**
     * Test method for
     * {@link cse220.assign5.Recursion#countHowMany(java.lang.Object[], int, int, java.lang.Object)}
     * .
     */
    public final void testCountHowMany() {
        Integer[] data1 = new Integer[] { 3, 1, 3, 17, 2, 2, 4, 9, 2 };
        assertEquals(2,Recursion.countHowMany(data1, 0, data1.length - 1, 3));
        assertEquals(3,Recursion.countHowMany(data1, 0, data1.length - 1, 2));
        assertEquals(0,Recursion.countHowMany(data1, 0, data1.length - 1, 52));
    }

    /**
     * Test method for
     * {@link cse220.assign5.Recursion#reverseArray(java.lang.Object[], int, int)}
     * .
     */
    public final void testReverseArray() {
        Integer[] revData = java.util.Arrays.copyOf(data_even_unsorted,
                data_even_unsorted.length);
        Recursion.reverseArray(revData, 0, revData.length - 1);
        int j = data_even_unsorted.length - 1;
        for (int i = 0; i < revData.length; i++, j--)
            assertEquals(data_even_unsorted[j], revData[i]);
    }

    /**
     * Test method for
     * {@link cse220.assign5.Recursion#reversePrint(java.lang.Object[], int, int)}
     * .
     */
    public final void testReversePrint() {
        // No tests are done for this one since it prints to
        // System.out.println.
        // fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for {@link cse220.assign5.Recursion#pow(int, int)}.
     */
    public final void testPow() {
        for (int p = 2; p < 6; p++) {
            for (int x = 0; x < 10; x++) {
                int ans = Recursion.pow(p, x);
                int exp = (int) Math.pow(p, x);
                assertEquals(exp, ans);
            }
        }
    }

    /**
     * Test method for {@link cse220.assign5.Recursion#powDC(int, int)}.
     */
    public final void testPowDC() {
        for (int p = 2; p < 6; p++) {
            for (int x = 0; x < 10; x++) {
                int ans = Recursion.powDC(p, x);
                int exp = (int) Math.pow(p, x);
                assertEquals(exp, ans);
            }
        }
    }

    /**
     * Test method for
     * {@link cse220.assign5.Recursion#linearSum(int[], int, int)}.
     */
    public final void testLinearSum() {
        int[] data = new int[] { 3, 1, 17, 2, 4, 9 };
        int ans = Recursion.linearSum(data, 0, data.length - 1);
        int exp = 0;
        for (int i = 0; i < data.length; i++)
            exp += data[i];
        assertEquals(exp, ans);
    }

    /**
     * Test method for
     * {@link cse220.assign5.Recursion#binarySum(int[], int, int)}.
     */
    public final void testBinarySum() {
        int[] data = new int[] { 3, 1, 17, 2, 4, 9 };
        int ans = Recursion.binarySum(data, 0, data.length - 1);
        int exp = 0;
        for (int i = 0; i < data.length; i++)
            exp += data[i];
        assertEquals(exp, ans);
    }

    /**
     * Test method for {@link cse220.assign5.Recursion#printDigits(int)}
     * .
     */
    public final void testPrintDigits() {
        // No tests are done for this one since it prints to
        // System.out.println.
        // fail("Not yet implemented"); // TODO
    }

    /**
     * Checks to see if two arrays are equal or not, element by element.
     * 
     * @param a1 first array.
     * @param a2 second array.
     * @return <code>true</code> all the elements are equal,
     *         <code>false</code> otherwise.
     */
    private static boolean equals(Object[] a1, Object[] a2) {
        return java.util.Arrays.equals(a1, a2);
    }

    private static void swap(Object[] data, int x, int y) {
        Object tmp = data[x];
 data[x] = data[y];
 data[y] = tmp;
    }

    /**
     * Test method for
     * {@link cse220.assign5.Recursion#findPosOfMinimum(Object[], int, int)}
     * .
     */
    public final void testFindPosOfMinimum() {
        Integer[] data = new Integer[100];
 for (int i = 0; i < 100; i++)
     data[i] = new Integer(i);

 for (int i = 0; i < 100; i++) {
     if (i != 0)
  swap(data, 0, i);

     int result = Recursion.findPosOfMinimum(data, 0, 99);
     assertTrue(result == i);

     if (i != 0)
  swap(data, 0, i);
 }
    }

    /**
     * Test method for
     * {@link cse220.assign5.Recursion#selectionSort(Object[], int, int)}
     * .
     */
    public final void testSelectionSort() {
        // Test unsorted array.
        Integer[] data1_in = { 31, 5, 17, -3, 99, 4, 33, 1 };
        Integer[] data1_out = { -3, 1, 4, 5, 17, 31, 33, 99 };
        Recursion.selectionSort(data1_in, 0, data1_in.length - 1);
        boolean matches = equals(data1_in, data1_out);
        assertTrue(matches);

        // Test sorted array, but in the reverse order.
        data1_in = new Integer[] { -3, 1, 4, 5, 17, 31, 33, 99 };
        Recursion.selectionSort(data1_in, 0, data1_in.length - 1);
        matches = equals(data1_in, data1_out);
        assertTrue(matches);

        // Test sorted array, but in the reverse order.
        data1_in = new Integer[] { 99, 31, 33, 17, 5, 4, 1, -3 };
        Recursion.selectionSort(data1_in, 0, data1_in.length - 1);
        matches = equals(data1_in, data1_out);
        assertTrue(matches);

        // degenerate cases - 0, 1 and 2 element arrays
        data1_in = new Integer[] {};
        Recursion.selectionSort(data1_in, 0, data1_in.length - 1);
        matches = equals(data1_in, new Integer[] {});
        assertTrue(matches);

        data1_in = new Integer[] { 99 };
        Recursion.selectionSort(data1_in, 0, data1_in.length - 1);
        matches = equals(data1_in, new Integer[] { 99 });
        assertTrue(matches);

        data1_in = new Integer[] { 99, -5 };
        Recursion.selectionSort(data1_in, 0, data1_in.length - 1);
        matches = equals(data1_in, new Integer[] { -5, 99 });
        assertTrue(matches);
    }

    /**
     * Test method for
     * {@link cse220.assign5.Recursion#strLength(String)} .
     */
    public final void testStrLength() {
        String[] strings = { "", "a", "ab", "abc", "abcd", "abcde" };
        for (String str : strings) {
            int result = Recursion.strLength(str);
            int expected = str.length();
            assertEquals(expected, result);
        }
    }

    /**
     * Test method for
     * {@link cse220.assign5.Recursion#reverseString(String)} .
     */
    public final void testReverseString() {
        String[] strings = { "", "a", "ab", "abc", "abcd", "abcde" };
        String[] exp = { "", "a", "ba", "cba", "dcba", "edcba" };
        for (int i = 0; i < strings.length; i++) {
            String result = Recursion.reverseString(strings[i]);
            String expected = exp[i];
            assertEquals(expected, result);
        }
    }
}
