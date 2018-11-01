import java.util.Arrays;
import java.util.stream.IntStream;

public class MyMath {

    public void check (int first, int last, int ... mas){

        IntStream m1 = Arrays.stream(mas).filter(m -> (m > first && m < last));
        System.out.println(m1.count());

    }

    public static void main(String [] argv){
        int[] data = {10,20,30,40,50,60,71,80,90,91};
        MyMath mm = new MyMath();
        mm.check(20, 80, data);
    }
}
