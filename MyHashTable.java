/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author mehdi akbarian 2016-1-14
 */
public class MyHashTable {

    int TABLE_SIZE = 100;
    HashInputs[] table;
    private HashInputs DELETED;
    
    public MyHashTable() {
        table = new HashInputs[TABLE_SIZE];
        DELETED=new HashInputs(-234444444,-44444 );
    }
    /**
     * get value of key
     *
     * @param key for searching in table
     * @author mehdi akbarina
     * @return if key find in table returned value else return -1
     */
    public int get(int key) {
        
        if (table[hashFunction(key,true)] == null && table[hashFunction(key,true)]==DELETED)
            return -1;
        else
            return table[hashFunction(key,true)].getValue();
    }

    /**
     * add new data to hash table
     *
     * @param key for inserting in table
     * @param value for inserting in table
     * @author mehdi akbarina
     */
    public void put(int key, int value) {
        table[hashFunction(key,false)] = new HashInputs(key, value);
    }

    /**
     * generate index for hash table
     *
     * @param key for generate virtual position
     * @author mehdi akbarina
     */
    private int hashFunction(int key,boolean isGet) {
        int hash = (key % TABLE_SIZE);
        while (table[hash] != null &&(table[hash] !=DELETED || isGet)&& table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
        }
        return hash;
    }
    
    /**
     * remove data to hash table
     *
     * @param key for inserting in table
     * @author mehdi akbarina
     * @return true if successfully delete data 
     */
    public boolean remove(int key){
        int hashIndex=hashFunction(key,true);
        int tempKey=table[hashIndex].getValue();
        if(hashIndex==-1)
             return false;
        //region rubbish
//        int nextItems=hashIndex+1;
//        for(;table[nextItems]!=null && nextItems<TABLE_SIZE && nextItems!=(table[nextItems].getKey()%TABLE_SIZE);nextItems++){}
//        for(int i=hashIndex+1;i<=nextItems;i++)
//            table[i-1]=table[i];
//        if(nextItems !=hashIndex+1)
        //endregion
            table[hashIndex]=DELETED;  
        return true;
    }
    
    public void printTable(){
        for(int i=0;i<TABLE_SIZE;i++){
            if(table[i]!=null && table[i] !=DELETED)
                System.out.print("Table["+i+"] = ("+ table[i].getKey()+" , "+table[i].getValue()+")");
        }
        
    }

}
