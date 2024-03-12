package djh.learn.hashDS;

import djh.learn.hashDS.model.Employee;

public class ChainedHashTableMain {
    public static void main(String[] args) {
        Employee john = new Employee("John","Adam",53533);
        Employee timmi = new Employee("Timmi","burton",3433);
        Employee paul = new Employee("Paul","Geferry",8777);
        Employee hanna = new Employee("Hanna","Montana",77575);
        Employee jimmy = new Employee("Jimmy","Jimmy",43433);

        ChainedHashTable hashTable = new ChainedHashTable();
        hashTable.put(john.getFirstName(), john);
        hashTable.put(timmi.getFirstName(), timmi);

        hashTable.put(paul.getFirstName(), paul);
        hashTable.print();

        System.out.println(hashTable.remove("Paul"));
        hashTable.print();
    }
}
