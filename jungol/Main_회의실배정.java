package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
public class Main_회의실배정 {
     
    public static String[][] sa, ra;
 
    public static void main(String[] args) throws Exception {
     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sa = new String[N][];
        ra = new String[N][];
             
        for(int i=0; i<N; i++) {
            String[] s = br.readLine().split(" ");
            sa[i] = s;
        }
        mergesort(0,sa.length-1);
        int count = 0;
        ArrayList<Integer> al = new ArrayList<>();
        //for(String[] s : ra) System.out.println(Arrays.toString(s));
        int end = 0;
        for(int i=0; i<ra.length; i++) {
            if(Integer.parseInt(sa[i][1])>=end) {
                count++;
                al.add(Integer.parseInt(sa[i][0]));
                end = Integer.parseInt(sa[i][2]);
            }
        }
        System.out.println(count);
        for(int i : al) {
            System.out.print(i+" ");
        }
    }
     
    public static void mergesort(int left, int right) {
        if(left<right) {
            int mid = (left+right)/2;
            mergesort(left,mid);
            mergesort(mid+1, right);
            merge(left,mid,right);
            //System.out.println(Arrays.toString(a));
        }
    }
     
    public static void merge(int left, int mid, int right) {
         
        int i = left;
        int j = mid + 1;
        int k = left;
         
        while(i<=mid && j<=right) {
            if(Integer.parseInt(sa[i][2])<=Integer.parseInt(sa[j][2])) ra[k++] = sa[i++];
            else ra[k++]=sa[j++];
        }
        if(i>mid) {
            for(int l=j; l<=right; l++) {
                ra[k++] = sa[l];
            }
        }else {
            for(int l=i; l<=mid; l++) {
            ra[k++] = sa[l];
            }
        }
        for(int l=left; l<=right; l++) {
            sa[l] = ra[l];
        }
    }
 
 
}

