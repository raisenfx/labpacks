public class Lab6S0 {
    public static void main(String[] args) {
        int[] myArr = {4, 8, 15, 16, 23, 42};

        System.out.println("a. Length of myArr: " + myArr.length);
        System.out.println("b. First element: " + myArr[0]);
        System.out.println("c. Index of last element: " + (myArr.length - 1));
        System.out.println("d. Third element: " + myArr[2]);
        System.out.println("e. Value of myArr[3]: " + myArr[3]);

        
        System.out.println("f. Trying to access myArr[10]...");
        System.out.println(myArr[10]); 
    }
}
