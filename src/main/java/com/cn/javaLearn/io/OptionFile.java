package com.cn.javaLearn.io;

import java.io.*;

/**
 * @program: javaLearn
 * @description: JavaIO操作
 * @author: liyan
 * @create: 2024-05-08 08:25
 **/
public class OptionFile {


    public void ReadTxtInfo(String filePath) {
        File file = new File(filePath);
        try {
            // 正常
            InputStream in = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader bf = new BufferedReader(isr);
            // 简化版
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
