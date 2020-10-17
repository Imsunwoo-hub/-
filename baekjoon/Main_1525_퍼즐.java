package beakjoon;

import java.io.IOException;
import java.util.HashMap;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;


class Main_1525_퍼즐 {
       public static void main(String[] args) throws IOException {
    	   Scanner scan=new Scanner(System.in);
    	   int puzzle=0;
    	   int flag=100000000;

    	   for(int i=0; i<9; i++) {
    		   int n=scan.nextInt();
    		   if(n!=0) 
    			   puzzle+=n*flag;
    		   else
    			   puzzle+=9*flag;
    		   flag/=10;
    	   }
    	   
    	   Map<Integer,Integer> dist=new HashMap<>();
    	   
    	   Queue<Integer> queue=new LinkedList<>();
    	   int pn=puzzle;
    	   queue.add(pn);
    	   dist.put(pn, 0);
    	   while(!queue.isEmpty()) {
    		   int now=queue.poll();
    		   int nw=-1;
    		   if(now==123456789) {
    			   System.out.println(dist.get(now));
    			   return;
    		   }
    		   
    		   nw=Integer.toString(now).indexOf('9');
    		   String str=Integer.toString(now);
    		   StringBuilder builder = new StringBuilder(str);

    		   if(nw-3>=0 ) {
   
    			   builder.setCharAt(nw, str.charAt(nw-3));
    			   builder.setCharAt(nw-3, '9');
    			   int an=Integer.parseInt(builder.toString());
    			   if(dist.get(an)==null) {
    				   queue.add(an);
    				   dist.put(an, dist.get(now)+1);
    			   }
    		   }
    		   
    		   if(nw%3!=2) {
    			 
    			   builder = new StringBuilder(str);
    			   builder.setCharAt(nw, str.charAt(nw+1));
    			   builder.setCharAt(nw+1, '9');
    			   int an=Integer.parseInt(builder.toString());
    			   if(dist.get(an)==null) {
    				   queue.add(an);
    				   dist.put(an, dist.get(now)+1);
    			   }
    		   }
    		   
    		   if(nw%3!=0) {
    			  
    			   builder = new StringBuilder(str);
    			   builder.setCharAt(nw, str.charAt(nw-1));
    			   builder.setCharAt(nw-1, '9');
    			   int an=Integer.parseInt(builder.toString());
    			   if(dist.get(an)==null) {
    				   queue.add(an);
    				   dist.put(an, dist.get(now)+1);
    			   }
    		   }

    		   

    		   if(nw+3<9) {
    			   
    			   builder = new StringBuilder(str);
    			   builder.setCharAt(nw, str.charAt(nw+3));
    			   builder.setCharAt(nw+3, '9');
    			   int an=Integer.parseInt(builder.toString());
    			   if(dist.get(an)==null) {
    				   queue.add(an);
    				   dist.put(an, dist.get(now)+1);
    			   }
    		   }

    	   }
    	   System.out.println(-1);
       }

       
}