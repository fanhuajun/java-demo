package com.huajun.file.fileOperate;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
//        readTxtFile();
        
        writeFile();
    }

    public static void readTxtFile() {

        try {
            String encoding = "utf-8";
            File file = new File("C:/Users/fanhuajun/Desktop/repository/myInfo/life Record/日记/zhaorui.sql");
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    
                    System.out.println(lineTxt);
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }
    
    public static void writeFile(){
        
        /* 写入Txt文件 */  
        File writename = new File("D:/2.sql"); // 相对路径，如果没有则要建立一个新的output.txt文件  
        
        try {
            writename.createNewFile();// 创建新文件  
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
            out.write("我会写入文件啦\r\n"); // \r\n即为换行  
            out.flush(); // 把缓存区内容压入文件  
            out.close(); // 最后记得关闭文件 
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        
    }
}
