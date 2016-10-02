/**
 * Recursion.java
 */
package cse220.assign5;

/**
 * Various recursive function implementations to get a feel for how
 * recursion works.
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class Recursion {

    /**
     * Searches through A[left,right] for key using linear search.
     * 
     * @param A reference to the array.
     * @param left the index of the leftmost element.
     * @param right the index of the rightmost element.
     * @param key the key to search for.
     * @return the index of the element, relative to left, if found; -1
     *         otherwise.
     */
    public static int linearSearch(Object[] A, int left, int right,
            Object key) {
      
      
      if(left == A.length)
        return -1;
      else if(key.equals(A[left]))
        return left;
      else 
        return linearSearch(A, left + 1, right, key);
    }
    
    
    /**
     * Searches through A[left,right] for key using binary search.
     * 
     * @param A reference to the array.
     * @param left the index of the leftmost element.
     * @param right the index of the rightmost element.
     * @param key the key to search for.
     * @return the index of the element, relative to left, if found; -1
     *         otherwise.
     */
    public static int binarySearch(Object[] A, int left, int right,
            Object key) {
 // TODO
      
      
      if(left > right)
        return -1;
      else {
        int mid = (left + right) / 2;
        if(key == A[mid])
          return mid;
        else if(((Comparable)key).compareTo(A[mid]) > 0)
          return binarySearch(A, mid + 1, right, key);
        else
          return binarySearch(A, left, mid - 1, key);
      }
    }
    
    
    /**
     * Counts the number of times x occurs in A[left,right].
     * 
     * @param A reference to the array.
     * @param left the index of the leftmost element.
     * @param right the index of the rightmost element.
     * @param x the element to count.
     * @return the number of times x occurs A[left,right].
     */
    public static int countHowMany(Object[] A, int left, int right,
            Object x) {
 // TODO
      
      
      if(left == A.length)
        return 0;
      else if(x.equals(A[left]))
        return 1 + countHowMany(A, left + 1, right, x);
      else
        return countHowMany(A, left + 1, right, x);
    }
    
    
    /**
     * Reverses the order of the elements in the specified array.
     * 
     * @param A reference to the array.
     * @param left the index of the leftmost element.
     * @param right the index of the rightmost element.
     */
    public static void reverseArray(Object[] A, int left, int right) {
 // TODO
      
      
      int mid = A.length / 2;
      if(left == mid)
        return;
      else {
        Object x = A[left];
        A[left] = A[right];
        A[right] = x;
        reverseArray(A, left + 1, right - 1);
      }   
    }
    
    
    /**
     * Prints the elements of the array in the reverse order.
     * 
     * @param A reference to the array.
     * @param left the index of the leftmost element.
     * @param right the index of the rightmost element.
     */
    public static void reversePrint(Object[] A, int left, int right) {
 // TODO
      
      
      if(left == right)
        return;
      else {
        reversePrint(A, left + 1, right);
        System.out.print("[" + left + "," + right + "] " + A[left] + ", ");
      }
    }
    
    
    /**
     * Computes the value of base^exp.
     * 
     * @param base the base.
     * @param exp the exponent.
     * @return the value of base^exp.
     */
    public static int pow(int base, int exp) {
 // TODO
      
      
      if(exp == 0)
        return 1;
      else
        return pow(base, exp - 1) * base;
    }
    
    
    /**
     * Computes the value of base^exp using divide and conquer strategy.
     * 
     * <pre>
     * a^n = 1, if n == 0
     * a^n = a^(n/2) * a^(n/2), if n is even (n % 2 == 0)
     * a^n = a^((n-1)/2) * a^((n-1)/2) * a, if n is odd (n % 2 != 0)
     * </pre>
     * 
     * @param base the base.
     * @param exp the exponent.
     * @return the value of base^exp.
     */
    public static int powDC(int base, int exp) {
 // TODO
      
      
      if(exp == 0)
        return 1;
      else if(exp % 2 == 0)
        return pow(base, exp / 2) * pow (base, exp / 2);
      else
        return pow(base, (exp - 1) / 2) * pow (base, (exp - 1) / 2) * base;
    }
    
    
    /**
     * Computes the sum of the values in the array using linear recursion.
     * 
     * @param A reference to the array.
     * @param left the index of the leftmost element.
     * @param right the index of the rightmost element.
     * @return the sum of the elements in the array.
     */
    public static int linearSum(int[] A, int left, int right) {
 // TODO
      
      
      if(left > right)
        return 0;
      else
        return A[left] + linearSum(A, left + 1, right);
    }
    
    
    /**
     * Computes the sum of the values in the array using binary recursion.
     * 
     * @param A reference to the array.
     * @param left the index of the leftmost element.
     * @param right the index of the rightmost element.
     * @return the sum of the elements in the array.
     */
    public static int binarySum(int[] A, int left, int right) {
 // TODO
      
      
      if (left == right)
        return A[left];
      else {
        int mid = (left + right) / 2;
        return binarySum(A, left, mid) + binarySum(A, mid + 1, right);
      }
    }
    
    
    /**
     * Returns the largest element in the array using linear recursion.
     * 
     * @param A reference to the array.
     * @param left the index of the leftmost element.
     * @param right the index of the rightmost element.
     * @return the largest element in the array.
     */
    private static Object linearMax(Object[] A, int left, int right) {
 // TODO
      
      
      if (left == right)
        return A[left];
      else {
        Object max = linearMax(A, left + 1, right);
        if(((Comparable)A[left]).compareTo(max) > 0)
          return A[left];
        return max;
      }    
    }
    
    
    /**
     * Returns the largest element in the array using binary recursion.
     * 
     * @param A reference to the array.
     * @param left the index of the leftmost element.
     * @param right the index of the rightmost element.
     * @return the largest element in the array.
     */
    private static Object binaryMax(Object[] A, int left, int right) {
 // TODO
      
      
      if(left == right)
        return A[left];
      else {
        int mid = (left + right ) / 2;
        Object maxLeftHalf = binaryMax(A, left, mid);
        Object maxRightHalf = binaryMax(A, mid + 1, right);
        if(((Comparable)maxLeftHalf).compareTo(maxRightHalf) > 0)
          return maxLeftHalf;
        return maxRightHalf;
      }
    }
    
    
    /**
     * Prints the digits of an integer from most-significant to least
     * significant.
     * 
     * @param N the integer, > 0.
     */
    public static void printDigits(int N) {
 // TODO
      
      
      if(N == 0)
        return;
      else {
        printDigits(N / 10);
        System.out.print(N % 10);
      }
    }
    
    
    /**
     * Finds the position of the minimum key in data[l..r].
     * 
     * @param data the data to find the minimum key in
     * @param l the left boundary of the array to consider
     * @param r the right boundary of the array to consider
     * @return the position/index of the minimum key in data[l..r]
     */
    public static int findPosOfMinimum(Object[] data, int l, int r) {
 // TODO
      
      
      if (l == r)
        return l;
      else {
        int min = findPosOfMinimum(data, l + 1, r);
        if(((Comparable)data[l]).compareTo(data[min]) < 0)
          return l;
        return min;
      }
    }
    
    
    /**
     * Sorts the given array of objects using selection sort.
     * 
     * @param data the data to sort
     * @param l the left boundary of the array to consider
     * @param r the right boundary of the array to consider
     */
    public static void selectionSort(Object[] data, int l, int r) {
 // TODO
      
      
      if(l > r)
        return;
      int min = l;
      for(int i = l + 1; i < data.length; i++) {
        if(((Comparable)data[i]).compareTo(data[min]) < 0)
          min = i;
      }
      Object temp = data[l];
      data[l] = data[min];
      data[min] = temp;
      selectionSort(data, l + 1, r);
    }
    
    
    /**
     * Returns the length of the given String (without using
     * String.length)
     * 
     * @param str the string whose length is to be computed
     * @return the length of the string object
     */
    public static int strLength(String str) {
 // TODO
      
      
      if(str.equals(""))
        return 0;
      else
        return 1 + strLength(str.substring(1));
    }
    
    
    /**
     * Reverses the order of characters in a String.
     * 
     * @param str the string to reverse
     * @return the reversed string
     */
    public static String reverseString(String str) {
 // TODO
      
      
      if(str.length() <= 1)
        return str;
      else
        return  reverseString(str.substring(1)) + str.charAt(0);
    }
    
    
    private static void printArray(Object[] A) {
        System.out.println(java.util.Arrays.toString(A));
    }

    /**
     * Tests the various static recursive functions in this class.
     * 
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        // Prepare data for testing:
        // data1 - contains unordered even number of random values
        // data2 - same data, but sorted
        // data3 - contains unordered odd number of random values
        // data4 - same data, but sorted
        Integer[] data1 = new Integer[20];
        for (int i = 0; i < data1.length; i++) {
            data1[i] = (int) (Math.random() * 10000);
        }
        Integer[] data2 = java.util.Arrays.copyOf(data1, data1.length);
        java.util.Arrays.sort(data2);

        Integer[] data3 = new Integer[21];
        for (int i = 0; i < data3.length; i++) {
            data3[i] = (int) (Math.random() * 10000);
        }
        Integer[] data4 = java.util.Arrays.copyOf(data3, data3.length);
        java.util.Arrays.sort(data4);

        printArray(data2);
        for (int i = 0; i < data2.length; i++) {
            Object key = data2[i];
            int index = linearSearch(data2, 0, data2.length, key);
            if (index != i)
                System.out.println("expected index " + i + " for key "
                        + key + ", but have " + index);
        }

        printArray(data1);
        linearSearch(data1, 0, data1.length - 1, 5);
        printArray(data1);
        System.out.println("Sorting using Arrays.sort()");
        java.util.Arrays.sort(data1);
        printArray(data1);

        data1 = new Integer[] { 3, 2, 4, 1, 7, 9, 6, 10, 5, 8 };
        printArray(data1);
        linearSearch(data1, 0, data1.length - 1, 5);
        printArray(data1);
        System.out.println("Sorting using Arrays.sort()");
        java.util.Arrays.sort(data1);
        printArray(data1);

        reversePrint(data1, 0, data1.length - 1);
        reverseArray(data1, 0, data1.length - 1);
        printArray(data1);
        reverseArray(data1, 0, data1.length - 1);
        printArray(data1);

        System.out.print("pow(2,i) = ");
        for (int i = 0; i < 9; i++)
            System.out.print(" " + pow(2, i));
        System.out.println("");

        System.out.print("powDC(2,i) = ");
        for (int i = 0; i < 9; i++)
            System.out.print(" " + powDC(2, i));
        System.out.println("");

        int[] idata1 = new int[5];
        int[] idata2 = new int[6];
        java.util.Arrays.fill(idata1, 5);
        java.util.Arrays.fill(idata2, 5);
        System.out.println("linearSum("
                + java.util.Arrays.toString(idata1) + ") = "
                + linearSum(idata1, 0, idata1.length - 1));
        System.out.println("linearSum("
                + java.util.Arrays.toString(idata2) + ") = "
                + linearSum(idata2, 0, idata2.length - 1));
        System.out.println("binarySum("
                + java.util.Arrays.toString(idata1) + ") = "
                + binarySum(idata1, 0, idata1.length - 1));
        System.out.println("binarySum("
                + java.util.Arrays.toString(idata2) + ") = "
                + binarySum(idata2, 0, idata2.length - 1));

        Integer[] Idata1 = new Integer[5];
        Integer[] Idata2 = new Integer[6];
        java.util.Arrays.fill(Idata1, new Integer(5));
        java.util.Arrays.fill(Idata2, new Integer(5));

        System.out.println("countHowMany("
                + java.util.Arrays.toString(Idata1)
                + ", 5) = "
                + countHowMany(Idata1, 0, Idata1.length - 1, new Integer(
                        5)));
        System.out.println("countHowMany("
                + java.util.Arrays.toString(Idata2)
                + ", 5) = "
                + countHowMany(Idata2, 0, Idata2.length - 1, new Integer(
                        5)));
        System.out.println("countHowMany("
                + java.util.Arrays.toString(Idata2)
                + ", 6) = "
                + countHowMany(Idata2, 0, Idata2.length - 1, new Integer(
                        6)));

        System.out.println("linearMax("
                + java.util.Arrays.toString(data1) + ") = "
                + linearMax(data1, 0, data1.length - 1));
        System.out.println("linearMax("
                + java.util.Arrays.toString(data2) + ") = "
                + linearMax(data2, 0, data2.length - 1));
        System.out.println("linearMax("
                + java.util.Arrays.toString(data3) + ") = "
                + linearMax(data3, 0, data3.length - 1));
        System.out.println("linearMax("
                + java.util.Arrays.toString(data4) + ") = "
                + linearMax(data4, 0, data4.length - 1));

        System.out.println("binaryMax("
                + java.util.Arrays.toString(data1) + ") = "
                + binaryMax(data1, 0, data1.length - 1));
        System.out.println("binaryMax("
                + java.util.Arrays.toString(data2) + ") = "
                + binaryMax(data2, 0, data2.length - 1));
        System.out.println("binaryMax("
                + java.util.Arrays.toString(data3) + ") = "
                + binaryMax(data3, 0, data3.length - 1));
        System.out.println("binaryMax("
                + java.util.Arrays.toString(data4) + ") = "
                + binaryMax(data4, 0, data4.length - 1));

        int intToPrint = 1321040;
        System.out.print("printDigits(" + intToPrint + ") = ");
        printDigits(intToPrint);
        System.out.println("");

        Integer[] data1_in = { 31, 5, 17, -3, 99, 4, 33, 1 };
        System.out.println("selectionSort input: "
                + java.util.Arrays.toString(data1_in));
        Recursion.selectionSort(data1_in, 0, data1_in.length - 1);
        System.out.println("selectionSort output: "
                + java.util.Arrays.toString(data1_in));

        String[] strings = { "", "a", "ab", "abc", "abcd", "abcde" };
        for (String str : strings) {
            int result = Recursion.strLength(str);
            System.out.println("Length(" + str + ") = " + result);
        }

        strings = new String[] { "", "a", "ab", "abc", "abcd", "abcde" };
        for (String str : strings) {
            String result = Recursion.reverseString(str);
            System.out.println("reverseString(" + str + ") = " + result);
        }
    }
}
