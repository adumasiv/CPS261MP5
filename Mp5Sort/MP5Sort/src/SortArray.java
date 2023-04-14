import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortArray 
{

        public static void main(String[] args) 
        {
                
                int[][] list = new int[][] {{34,89},{56,3},{27,61},{45,8},{45,89}};
                List<Integer> temp = new ArrayList<>();
                for(Integer x : Stream.of(list).flatMapToInt(row -> IntStream.of(row)).toArray())
                {
                        temp.add(x);
                }

                Collections.sort(temp);
                temp.stream().distinct().forEach(System.out::println);
              
        }

}
/*
3
8 
27
34
45
56
61
89
 */