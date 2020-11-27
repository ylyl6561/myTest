package com.corp.service.thread;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

    public static String getCorrectUrlFromFile(String filePath) throws IOException{

        List<String> urlList = getUrlFromFile(filePath);
        Map<String, String> urlMap = getUniqueUrl(urlList);
        return writeUrlIntoFile(filePath,urlMap);
    }

    public static List<String> getUrlFromFile(String filePath) throws IOException {
        ArrayList<String> urlList = new ArrayList<String>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filePath));
            String str;
            while ((str = bf.readLine()) != null) {
                urlList.add(str);
            }
            bf.close();
            return urlList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static  String  writeUrlIntoFile(String filePath ,Map<String, String>  urlMap) throws IOException {
        try {
            FileWriter fw =new FileWriter(filePath);
            BufferedWriter br = new BufferedWriter(fw);
            File f = new File(filePath);
            if (!f.exists()) {
                f.createNewFile();
            }
            for(Map.Entry<String,String> k: urlMap.entrySet()){
                br.write(k.getKey());
            }
            br.close();
            return filePath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    public static Map<String, String> getUniqueUrl(List<String> urlList){
        if(urlList == null){
            return null;
        }
        Map<String, String> res = new HashMap<String, String>();
        for(String item: urlList ){
            if(isUrl(item) && (!res.containsKey(item))){
                res.put(item,item);
            }
        }
        return res;
    }

    public static boolean isUrl(String url){
        String reg = "(((https|http)?://)?([a-z0-9]+[.])|(www.))\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";
        Pattern p = Pattern.compile(reg);
        Matcher mat = p.matcher(url);
        return mat.matches();
    }





}
