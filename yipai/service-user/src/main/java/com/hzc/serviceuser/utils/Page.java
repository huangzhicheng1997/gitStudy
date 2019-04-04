package com.hzc.serviceuser.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Page {
    public static void main(String[] args) throws IOException {
        String nio1Path="C:\\Users\\hzc\\Desktop\\nio1.txt";
        String nio2Path="C:\\Users\\hzc\\Desktop\\nio2.txt";

        //获取in的 channel
        FileInputStream in=new FileInputStream(nio1Path);
        FileChannel channel = in.getChannel();
        //获取out的channel
        FileOutputStream out = new FileOutputStream(nio2Path);
        FileChannel fc = out.getChannel();
        //创建缓冲区
        ByteBuffer buffer=ByteBuffer.allocate(3);
        //读入缓冲区 能读到多少由limit决定  读的时候limit是等于capacity的 position从0开始
        while (-1!=channel.read(buffer)) {
            //置limit为position  置position为0 所以要写入多少字符就是从position到limit长度
            //写之前要flip一下
            buffer.flip();
            fc.write(buffer);
            //写完了必须重置buffer调用clear以便于下次读写
            buffer.clear();
        }

    }
}
