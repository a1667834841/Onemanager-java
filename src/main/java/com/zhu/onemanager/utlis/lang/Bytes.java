package com.zhu.onemanager.utlis.lang;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ggBall
 * @version 1.0.0
 * @ClassName Bytes.java
 * @Description TODO
 * @createTime 2022年01月10日 11:16:00
 */
public class Bytes {

    public List<byte[]> split(byte[] bytes, int splitIndex) {

        byte[] bytes1 = new byte[splitIndex];
        for (int i = 0; i < splitIndex; i++) {
            bytes1[i] = bytes[i];
            if (i == splitIndex) {
                break;
            }
        }

        byte[] bytes2 = new byte[bytes.length - splitIndex];
        for (int i = splitIndex; i < splitIndex; i++) {
            bytes2[i-splitIndex] = bytes[i];
        }

        LinkedList<byte[]> list = new LinkedList<>();
        list.add(bytes1);
        list.add(bytes2);

        return list;

    }
}
