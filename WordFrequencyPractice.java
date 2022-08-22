package others;

import java.util.*;

public class WordFrequencyPractice {

    public static void main(String args[]) {

        String test = "the cat is in the bag";

        calculateWordFrequency(test);


    }

    private static void calculateWordFrequency(String test) {


        String values[] = test.split(" ");


        Map<String, Integer> wordFrequency = new HashMap();
        for (int i = 0; i < values.length; i++) {

            wordFrequency.put(values[i], wordFrequency.getOrDefault(values[i],0) + 1);
        }

        wordFrequency = sortWordFrequencyBasedonOccurence(wordFrequency);
        for(Map.Entry<String,Integer> mapValues : wordFrequency.entrySet())  {

            System.out.println(mapValues.getValue()+  "   " +mapValues.getKey());
        }

    }



    private static Map<String,Integer>  sortWordFrequencyBasedonOccurence(Map<String, Integer> wordFrequency) {

      List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String,Integer>>(wordFrequency.entrySet());

     Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){
         @Override
         public int compare(Map.Entry<String,Integer> o1, Map.Entry<String,Integer> o2) {
             return o2.getValue().compareTo(o1.getValue());
         }
     });

     Map<String,Integer> temp = new LinkedHashMap<>();

     for(Map.Entry<String,Integer> mapValues : list) {

         temp.put(mapValues.getKey(),mapValues.getValue());



     }



return temp;

    }
}
