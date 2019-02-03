/*
 * Developed by Uday Kumar
 * NIT Trichy, CA Department (MCA)
 * Software Engineer at McAfee, Bengaluru
 */
package mficafeteria;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author ukumar1
 */
public class Snack {
    private class TrieNode{
        Map<Character, TrieNode> children;
        String name;
        int quantity;
        int price;
        int days_available[];
        boolean endOfWord;
        public TrieNode() {
            children = new HashMap<>();
            quantity = 0;
            price = 0;
            days_available = new int[5];
            endOfWord = false;
        }
    }
    private TrieNode root = null;
    Snack(){
        root = new TrieNode();
    }
    
    /**
     * Iterative implementation of insert into breakfast trie
     */
    public void insert_item(String name, int quantity, int price, int []days) {
        TrieNode current = root;
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        //mark the current nodes endOfWord as true
        current.name = name;
        current.quantity = current.quantity + quantity;
        current.price = price;
        current.days_available = days;
        current.endOfWord = true;
    }
    
    public void display(){
        System.out.println("Name of Item\tQuantity\tPrice\tMON|TUE|WED|THU|FRI");
        display_items(root, "");
    }
    
    public void display_items(TrieNode root, String s){
        TrieNode current = root;
        if(root.children == null || root.children.size() == 0){
            return;
        }
        Iterator<Map.Entry<Character, TrieNode>> iter = current.children.entrySet().iterator();
        
        while(iter.hasNext()){
            Map.Entry<Character, TrieNode> entry = iter.next();
            TrieNode node = entry.getValue();
            s+=entry.getKey();
            display_items(node, s);
            if(node.endOfWord == true){
                System.out.print(node.name+"\t\t"+node.quantity+"\t\t"+node.price+"\t");
                for(int i=0;i<5;i++){
                    System.out.print(node.days_available[i]+"   ");
                }
                System.out.println();
                s=s.substring(0, s.length()-1);
            }else{
                s=s.substring(0,s.length()-1);
            }
        }
    }
    
    /**
     * Iterative implementation of search into trie.
     */
    public Item search(String word, int quantity, int day) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            //if node does not exist for given char then return false
            if (node == null) {
                return null;
            }
            current = node;
        }
        //return Item of current's endOfWord is true else return false.
        if(current.quantity < quantity){
            return null;
        }
        if(current.days_available[day-1] == 0){
            return null;
        }
        return new Item(current.name, quantity, current.price * quantity, "snack", current.days_available);
    }
}
