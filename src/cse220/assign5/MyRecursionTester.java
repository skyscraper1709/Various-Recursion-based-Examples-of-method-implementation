
package cse220.assign5;
class MyRecursionTester
{
    public static void main(String[] args)
    {
        Recursion r = new Recursion();
        Object []x={355,125,58,96,-56,89,45,991,35};
        System.out.println(r.linearSearch(x,1,7,991));
    }
}
