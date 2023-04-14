import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScrabbleStats 
{

   public static void main(String[] args) 
   {

       
       System.out.println("Top three words are:");
       String[] words = { "Java", "program", "list", "string", "unix", "hours", "syntax", "error" };
       Stream.of(words).sorted((e1, e2) -> vals(e2) - vals(e1)).limit(3)
               .forEach(e -> System.out.println(e + ":" + vals(e)));

       System.out.print("Average value for words is: ");
       List<Integer> list = new ArrayList<>();
       Stream.of(words).sorted((e1, e2) -> vals(e2) - vals(e1)).forEach(e -> list.add(vals(e)));
       Integer sum = list.stream().collect(Collectors.summingInt(Integer::intValue));

       double average = (double) sum / list.size();

       System.out.println((double) sum / list.size());

       Map<String, Integer> map = new HashMap<>();

       Stream.of(words).sorted((e1, e2) -> vals(e2) - vals(e1)).forEach(e -> map.put(e, vals(e)));

       System.out.print("Words below average:");

       Map<String, Integer> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
               .filter(x -> x.getValue() < average).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));

       ArrayList<String> belowAverageList = new ArrayList<>();

       collect.entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(4)
               .forEachOrdered(x -> belowAverageList.add(x.getKey()));
       System.out.println(belowAverageList);

       System.out.print("Words above average:");

       Map<String, Integer> aboveaverageMap = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
               .filter(x -> x.getValue() > average).collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
       ArrayList<String> aboveAverageList = new ArrayList<>();
       aboveaverageMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).limit(4)
               .forEachOrdered(x -> aboveAverageList.add(x.getKey()));

        System.out.println(aboveAverageList);

   }

   public static int vals(String word) 
   {
       Map<Character, Integer> letters = new HashMap<>();
       letters.put('a', 1);
       letters.put('b', 3);
       letters.put('c', 3);
       letters.put('d', 2);
       letters.put('e', 1);
       letters.put('f', 4);
       letters.put('g', 2);
       letters.put('h', 4);
       letters.put('i', 1);
       letters.put('j', 8);
       letters.put('k', 5);
       letters.put('l', 1);
       letters.put('m', 3);
       letters.put('n', 1);
       letters.put('o', 1);
       letters.put('p', 3);
       letters.put('q', 10);
       letters.put('r', 1);
       letters.put('s', 1);
       letters.put('t', 1);
       letters.put('u', 1);
       letters.put('v', 8);
       letters.put('w', 4);
       letters.put('x', 8);
       letters.put('y', 4);
       letters.put('z', 10);
       return word.toLowerCase().chars().map(e -> letters.get((char) e)).sum();
   }

}
/*
Top three words are:
Java:18
syntax:16
program:12
Average value for words is: 10.125
*/