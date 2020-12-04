package com.hit.yt;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.io.*;

public class Main {
    static int[][] square;
    public static Scanner in;

    public static boolean isLegal(@NotNull String s){
        if(s.replaceAll("\\d*\\t*\\n*","").length()==0){
            return true;
        }

        return false;
    }

    public static boolean isLeaglMagicSquare(String fileName){
        boolean ret=false;
        File file = new File(fileName);
        BufferedReader in =null;
        try {
            in =new BufferedReader(new FileReader(file));
            String s;
            int lines=0;
            int rows=0;
            s=in.readLine();



        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(in!=null){
                try{
                    in.close();
                } catch (IOException e2){
                    e2.printStackTrace();
                }
            }
        }


        return ret;
    }

    public static void main(String[] args) {
        boolean ans;
        String s;
        for(int i=1;i<7;i++){
//            s="E:\\JavaFile\\Project\\src\\txt\\"+i+".txt";
            s="src/txt/"+i+".txt";
            boolean ret= isLeaglMagicSquare(s);
//            File file=new File(s);
//            System.out.println(file.isFile());
//            System.out.println(file.getAbsolutePath());
        }
    }
}
