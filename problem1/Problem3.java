package com.dpworld;

 
import java.util.HashMap; 
import java.util.Map; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class HelloWorld{

     public static void main(String []args){
        HashMap<String, Integer> map 
            = new HashMap<>(); 
             map.put("12.21.21.211", 10); 
        map.put("12.21.21.212", 30); 
        map.put("12.21.21.213", 20); 
        map.put("12.21.21.214", 50); 
        map.put("12.21.21.215", 5); 
        sortByValues(map,3);
     }
     static void sortByValues(HashMap<String, Integer> codenames, int maxLimit){
         Set<Entry<String, Integer>> entries = codenames.entrySet();
         Comparator<Entry<String, Integer>> valueComparator = new Comparator<Entry<String,Integer>>() {
            
            @Override
            public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
                Integer v1 = e1.getValue();
                Integer v2 = e2.getValue();
                return v2.compareTo(v1);
            }
        };
        
        List<Entry<String, Integer>> listOfEntries = new ArrayList<Entry<String, Integer>>(entries);
        
        Collections.sort(listOfEntries, valueComparator);
        
        LinkedHashMap<String, Integer> sortedByValue = new LinkedHashMap<String, Integer>(listOfEntries.size());
        
        for(Entry<String, Integer> entry : listOfEntries){
            sortedByValue.put(entry.getKey(), entry.getValue());
        }
        
        Set<Entry<String, Integer>> entrySetSortedByValue = sortedByValue.entrySet();
        
        
        for(Entry<String, Integer> mapping : entrySetSortedByValue){
            System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
            maxLimit--;
            if(maxLimit==0){
                break;
            }
        }
     }
}