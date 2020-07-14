package swex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
 
public class Solution_상호의배틀필드 {
 
    public static void main(String[] args) throws Exception {
         
 
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
             
            String[] sa = br.readLine().split(" ");
            int H = Integer.parseInt(sa[0]);
            int W = Integer.parseInt(sa[1]);
            char[][] ca = new char[H][W];
            for(int i=0; i<H; i++) {
                String s = br.readLine();
                for(int j=0; j<W; j++) {
                    ca[i][j] = s.charAt(j);
                }
            }
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            for(int k=0; k<N; k++) {
                char c = input.charAt(k);
                switch(c) {
                case 'U': 
                    for(int i=0; i<H; i++) {
                        int bol = 0;
                        for(int j=0; j<W; j++) {
                            if(ca[i][j]=='v'|| ca[i][j]=='^'|| ca[i][j]=='>'|| ca[i][j]=='<' ) {
                                if(i-1>=0 && ca[i-1][j]=='.') {
                                    bol = 1;
                                    ca[i][j] = '.';
                                    ca[i-1][j] = '^';
                                    break;
                                } else {
                                    bol = 1;
                                    ca[i][j] = '^';
                                    break;
                                }
                            }
                        }
                        if(bol==1) break;
                    }
                    break;
                case 'D': 
                    for(int i=0; i<H; i++) {
                        int bol = 0;
                        for(int j=0; j<W; j++) {
                            if(ca[i][j]=='v'|| ca[i][j]=='^'|| ca[i][j]=='>'|| ca[i][j]=='<' ) {
                                if(i+1<H && ca[i+1][j]=='.') {
                                    bol = 1;
                                    ca[i][j] = '.';
                                    ca[i+1][j] = 'v';
                                    break;
                                } else {
                                    bol = 1;
                                    ca[i][j] = 'v';
                                    break;
                                }
                            }
                        }
                        if(bol ==1 ) break;
                    }
                    break;
                case 'L': 
                    for(int i=0; i<H; i++) {
                        int bol = 0;
                        for(int j=0; j<W; j++) {
                            if(ca[i][j]=='v'|| ca[i][j]=='^'|| ca[i][j]=='>'|| ca[i][j]=='<' ) {
                                if(j-1>=0 && ca[i][j-1]=='.') {
                                    bol = 1;
                                    ca[i][j] = '.';
                                    ca[i][j-1] = '<';
                                    break;
                                } else {
                                    bol = 1;
                                    ca[i][j] = '<';
                                    break;
                                }
                            }
                        }
                        if(bol==1) break;
                    }
                    break;
                 
                case 'R':
                    for(int i=0; i<H; i++) {
                        int bol = 0;
                        for(int j=0; j<W; j++) {
                            if(ca[i][j]=='v'|| ca[i][j]=='^'|| ca[i][j]=='>'|| ca[i][j]=='<' ) {
                                if(j+1<W && ca[i][j+1]=='.') {
                                    bol = 1;
                                    ca[i][j] = '.';
                                    ca[i][j+1] = '>';
                                    break;
                                } else {
                                    bol = 1;
                                    ca[i][j] = '>';
                                    break;
                                }
                            }
                        }
                        if(bol ==1 )break;
                    }
                     
                    break;
                case 'S': 
                    for(int i=0; i<H; i++) {
                        int bol = 0;
                        for(int j=0; j<W; j++) {
                            if(ca[i][j]=='v'|| ca[i][j]=='^'|| ca[i][j]=='>'|| ca[i][j]=='<' ) {
                                if(ca[i][j]=='^') {
                                    bol = 1;
                                    for(int l=i; l>=0; l--) {
                                        if(ca[l][j]=='*') {
                                            ca[l][j] = '.';
                                            break;
                                        }
                                        else if(ca[l][j]=='#') break;
                                    }
                                }
                                else if(ca[i][j]=='v') {
                                    bol = 1;
                                    for(int l=i; l<H; l++) {
                                        if(ca[l][j]=='*') {
                                            ca[l][j] = '.';
                                            break;
                                        }
                                        else if(ca[l][j]=='#') break;
                                    }
                                }
                                else if(ca[i][j]=='<') {
                                    bol = 1;
                                    for(int l=j; l>=0; l--) {
                                        if(ca[i][l]=='*') {
                                            ca[i][l] = '.';
                                            break;
                                        }
                                        else if(ca[i][l]=='#') break;
                                    }
                                }
                                else if(ca[i][j]=='>') {
                                    bol = 1;
                                    for(int l=j; l<W; l++) {
                                        if(ca[i][l]=='*') {
                                            ca[i][l] = '.';
                                            break;
                                        }
                                        else if(ca[i][l]=='#') break;
                                    }
                                }
                                }
                            }
                        if(bol==1) break;
                    }
                    break;
                }
            }
            System.out.print("#"+tc+" ");
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    System.out.print(ca[i][j]);
                }
                System.out.println();
            }
        }
    }
}
