package com.career.cup;

public class CollabEdit {
	
	/*Given a stream of integers, implement a solution which outputs a summary of all integers seen to date on the minute, every minute. The output summary is formatted as example (1-3,5,7,9-11).
    
    (1-3,5,7,9-11).
    
1,1,5,5,5,5,2,2,3,4,4,4,4,1,1,1,8,9


1,1,1,1,1,2,2,3,4,4,4,4,5,5,5,5,5,8,9

1-5,8,9





public static void main(String[] args){
    String s = "1,1,5,5,5,5,2,2,3,4,4,4,4,1,1,1,8,9";
    
    String[] arr = s.split(",");
    
    Arrays.sort(arr);
    
    Stack<Integer> s = new Stack<Integer>();
    
    Queue q = new Queue();
    
    for(int i = 0; i < arr.length; i++){
        s.push(arr[i]);
        q.offer(arr[i]);
    }
    
    getStreamValues(s);

}

>> 3,4

public static void getSequence(String[] arr){

    if(arr == null || arr.length < 2) return;
    
    StringBuilider s =
    
    String output

    for(int i = 0; i < arr.length; i++){
            if(arr[i+1] - arr[i] > 1){
                System.out.println(arr[i]);
            }else{
                
            }
    
       }


}

public static void getStreamValues(Stack<Integer> s){
    
    while(!s.isEmpty()){
        System.out.println(s.pop()+",");
        System.out.println(q.poll()+",");
    }

}

public static void getStreamValuesQueue(Queue<Integer> q){
    
    while(!q.isEmpty()){
        
        System.out.println(q.poll()+",");
    }

}

1,1,1,1,1,2,2,3,4,4,4,4,5,5,5,5,5,8,9

>>9,8,1,1,1,4,4,4,4,3,2,2,5,5,5,5,1,1
*/

}
