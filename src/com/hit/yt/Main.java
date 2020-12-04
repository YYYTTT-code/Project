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

    public static boolean isLegalMagicSquare(String fileName){
        File file = new File(fileName);
        BufferedReader in =null;
        try {
            in =new BufferedReader(new FileReader(file));
            String s;
            int lines=0;
            int rows=0;
            s=in.readLine();
            if(isLegal(s)==false){
                System.out.println("有一行格式不匹配");
                return false;
            }
            String[] temps=s.split("\t");
            rows=temps.length;

            String[][] mat=new String[rows][rows];
            mat[lines++]=temps;
            while((s=in.readLine())!=null){
                if(isLegal(s)==false){
                    System.out.println("有一行格式不匹配");
                    return false;
                }
                temps=s.split("\t");
                if(rows!=temps.length){
                    System.out.println("这一行长度不相等啊");
                    return false;
                }
                mat[lines++]=temps;
            }
            if(rows!=lines){
                System.out.println("行列长度不相等");
                return false;
            }

            //上面格式验证完了，现在开始验证和是否相等
            square=new int[rows][lines];
            //转换成数字
            for(int i=0;i<rows;i++){
                for(int j=0;j<lines;j++){
                    try {
                        square[i][j]=Integer.valueOf(mat[i][j]);
                    }catch (NumberFormatException nf){
                        System.out.println("这一行不是数字的形式");
                        nf.printStackTrace();
                    }
                    if(square[i][j]<0){
                        System.out.println("有负数");
                        return false;
                    }

                }
            }
            //验证行列、对角线和是否相等
            int [] rowSum=new int[lines];
            int[] lineSum=new int[rows];
            int dia=0;
            int ndia=0;
            for(int i=0;i<rows;i++){
                for(int j=0;j<lines;j++){
                    rowSum[i]+=square[i][j];
                    lineSum[j]+=square[i][j];
                    if(i==j){
                        dia=dia+square[i][j];
                    }
                    if((i+j)==(rows-1)){
                        ndia=ndia+square[i][j];
                    }
                }
            }
            if(dia!=ndia){
                System.out.println("对角线元素不相等");
                return false;
            }
            for(int i=0;i<rows;i++){
                if(!(rowSum[i]==lineSum[i]&&rowSum[i]==dia)){
                    System.out.println("行列值不相等");
                    return false;
                }
            }


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
        return true;

    }
//1.1.2
    public static boolean generateMagicSquare(int n) {
        if (n % 2 == 0) {
            System.out.println("Input an even number!");
            return false;
        }
        if (n <= 0) {
            System.out.println("Input a negative number!");
            return false;
        }
        BufferedWriter out=null;
        try{
            out=new BufferedWriter(new FileWriter("src/txt/7.txt"));

            int magic[][] = new int[n][n];
            int row = 0, col = n / 2, i, j, square = n * n;
            for (i = 1; i <= square; i++) {
                magic[row][col] = i;
                if (i % n == 0)
                    row++;
                else {
                    if (row == 0)
                        row = n - 1;
                    else
                        row--;
                    if (col == (n - 1))
                        col = 0;
                    else
                        col++;
                }
            }
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++)
                    out.write(magic[i][j] + "\t");
                out.write("\n");
            }
            out.flush();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return true;
    }


    public static void main(String[] args) {
        boolean ans;
        String s;
        System.out.println(generateMagicSquare(9));
        for(int i=1;i<8;i++){
//            s="E:\\JavaFile\\Project\\src\\txt\\"+i+".txt";
            s="src/txt/"+i+".txt";
            boolean ret= isLegalMagicSquare(s);
//            File file=new File(s);
//            System.out.println(file.isFile());
//            System.out.println(file.getAbsolutePath());
            System.out.println("第"+i+"个文本结果为："+ret);
        }

    }
}
