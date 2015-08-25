package com.android.nilima.stackviewer;

import java.util.ArrayList;

/**
 * Created by nilima on 8/25/2015.
 */
public class StackUtils {
   static ArrayList<Integer> data=new ArrayList<>();

   static public void pushNumber(int a){
        data.add(a);
    }

   static public int popNumber(){
        int size=data.size();
        int temp=data.get(size-1);
        data.remove(size-1);
        return temp;
    }

   static public boolean isEmpty(){
        return (data.size()==0);
    }

}
