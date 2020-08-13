/*
 *
 *  * This file is part of TorrentStreamer-Android.
 *  *
 *  * TorrentStreamer-Android is free software: you can redistribute it and/or modify
 *  * it under the terms of the GNU Lesser General Public License as published by
 *  * the Free Software Foundation, either version 3 of the License, or
 *  * (at your option) any later version.
 *  *
 *  * TorrentStreamer-Android is distributed in the hope that it will be useful,
 *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  * GNU Lesser General Public License for more details.
 *  *
 *  * You should have received a copy of the GNU Lesser General Public License
 *  * along with TorrentStreamer-Android. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package org.huixing.torrent.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public final class FileUtils {

    private FileUtils() throws InstantiationException {
        throw new InstantiationException("This class is not created for instantiation");
    }

    /**
     * Delete every item below the File location
     *
     * @param file Location
     * @return {@code true} when successful delete
     */
    public static boolean recursiveDelete(File file) {
        if (file.isDirectory()) {
            String[] children = file.list();
            if (children == null) return false;
            for (String child : children) {
                recursiveDelete(new File(file, child));
            }
        }

        return file.delete();
    }

    public static StringBuffer readTxt(String path) throws IOException {
StringBuffer sb=new StringBuffer();
        // 使用一个字符串集合来存储文本中的路径 ，也可用String []数组
        List<String> list = new ArrayList();
        FileInputStream fis = new FileInputStream(path);
        // 防止路径乱码   如果utf-8 乱码  改GBK     eclipse里创建的txt  用UTF-8，在电脑上自己创建的txt  用GBK
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
            // 如果 t x t文件里的路径 不包含---字符串       这里是对里面的内容进行一个筛选
            if (line.lastIndexOf("---") < 0) {
                sb.append("&tr=").append(line);
            }
        }
        br.close();
        isr.close();
        fis.close();
        return sb;
    }
}
