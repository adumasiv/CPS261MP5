import java.util.*;
import java.util.stream.Collectors;


public class CountDigits {
        public static void main(String[] args) {
                ArrayList<Integer>list=new ArrayList<>();
                Random rand = new Random();
                for(int i=0;i<100;i++)
                        list.add(rand.nextInt(10));
                Map<Object, Integer> count = list.parallelStream().collect(Collectors.toConcurrentMap(e -> e, e -> 1, Integer::sum));           
                System.out.println(count);

        }
}
/*
{0=11, 1=7, 2=14, 3=4, 4=12, 5=9, 6=8, 7=7, 8=14, 9=14}
 */ 