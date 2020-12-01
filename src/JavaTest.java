public class JavaTest {

    public static void takeIntArray(int[] array){
        for(int i : array){
            System.out.print(i);
        }
    }

    public static int[] getIntArray(){
        return new int[]{1,2,3};
    }
}
