package djh.learn.hashDS;

import djh.learn.hashDS.model.Employee;
import djh.learn.hashDS.model.StoredEmployee;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class ChainedHashTable {
   // Employee [] hashTable;
    private LinkedList<StoredEmployee>[] hashTable;
    private int key;

    public ChainedHashTable(){

        hashTable = new LinkedList[10];
        for(int i=0;i<hashTable.length;i++){
    hashTable[i]= new LinkedList<StoredEmployee>();
        }
    }

    public int hashKey(String key){
        return key.length() % hashTable.length;
    }

    public void put(String key,Employee emp){
        int hashedKey = hashKey(key);
        hashTable[hashedKey].add(new StoredEmployee(key,emp));

    }

    public  Employee get(String myKey){
        int hashedKey = hashKey(myKey);
        Employee emp = hashTable[hashedKey].stream().filter( x -> x.key.equals(myKey)).collect(Collectors.toList()).get(0).emp;
        return emp;
    }

    public  Employee remove(String myKey){
        int hashedKey = hashKey(myKey);
        ListIterator<StoredEmployee> itr = hashTable[hashedKey].listIterator();
        int index =0;
        StoredEmployee employee = null;
        while (itr.hasNext()){
             employee = itr.next();
             index++;
            if(employee.key.equals(myKey)){
                break;
            }
        }
        System.out.println("emp is: "+employee.emp);
        if(employee==null){
            return null;
        } else{
            hashTable[hashedKey].remove(employee);
            return employee.emp;
        }

    }


    public void print(){
        for (int i = 0; i < hashTable.length; i++) {
            if(hashTable[i] == null){
                System.out.println("Empty");
            } else {
                hashTable[i].forEach(e -> System.out.println("Position: "+e.key+"---"+e.emp));
            }
        }
    }
    private boolean occupied(int index){
        return hashTable[index]!=null;
    }
}
