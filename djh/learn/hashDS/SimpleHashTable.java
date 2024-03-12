package djh.learn.hashDS;

import djh.learn.hashDS.model.Employee;
import djh.learn.hashDS.model.StoredEmployee;

public class SimpleHashTable {
   // Employee [] hashTable;
    StoredEmployee [] hashTable;
    private int key;

    public SimpleHashTable(){
        hashTable = new StoredEmployee[10];
    }

    public int hashKey(String key){
        return key.length() % hashTable.length;
    }

    public void put(String key,Employee emp){
        int hashKey = hashKey(key);
        if(occupied(hashKey)){
            int stopIndex = hashKey;
            if(hashKey == hashTable.length-1){
                hashKey = 0;
            } else{
                hashKey++;
            }
            while(occupied(hashKey) && hashKey!= stopIndex){
                hashKey = (hashKey +1) % hashTable.length;
            }
        }
        if(occupied(hashKey)){
            System.out.println("Sorry there is already an element at key "+hashKey);
        } else {
            hashTable[hashKey]= new StoredEmployee(key,emp);
        }

    }

    public  Employee get(String key){
        int hashKey = findKey(key);
        System.out.println("hashkey is: "+hashKey);
        if(hashKey == -1){
            return null;
        }
        return hashTable[hashKey].emp;
    }

    private int findKey(String key){
        int hashKey = hashKey(key);
        if(hashTable[hashKey] != null && hashTable[hashKey].key.equals(key)){
            return hashKey;
        }
        int stopIndex = hashKey;
        if(hashKey == hashTable.length-1){
            hashKey = 0;
        } else{
            hashKey++;
        }
        while( hashKey != stopIndex && hashTable[hashKey] != null && !hashTable[hashKey].key.equals(key)){
            hashKey = (hashKey +1) % hashTable.length;
        }
        if(hashTable[hashKey] != null && hashTable[hashKey].key.equals(key)){
            return hashKey;
        } else{
            return -1;
        }
    }

    public Employee remove(String key){
        int hashKey = findKey(key);
        System.out.println("hashKey: "+hashKey);
        if(hashTable[hashKey] != null && hashTable[hashKey].key.equals(key)) {
            Employee removed = hashTable[hashKey].emp;
            hashTable[hashKey] = null;
            return removed;
        }
        return null;
    }
    public void print(){
        for (int i = 0; i < hashTable.length; i++) {
            if(hashTable[i] == null){
                System.out.println("Empty");
            } else {
                System.out.println(hashTable[i].emp);
            }
        }
    }
    private boolean occupied(int index){
        return hashTable[index]!=null;
    }
}
