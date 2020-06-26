import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class JSONExercise {
    public static void main(String[] args) {

        //1.    转换  : ["一二三","二三四","三四五"]
        List<String> strings = JSON.parseArray("[\"一二三\",\"二三四\",\"三四五\"]", String.class);
        System.out.println(strings.get(1));

    }
   /* public static void main(String[] args) {

        //1.    转换  : {"id":"1002","info":"床前明月光，地上鞋一堆。床上我杰哥，喊十块钱一双。","name":"唐诗三百首"}
        Book book = JSON.parseObject("{\"id\":\"1002\",\"info\":\"床前明月光，地上鞋一堆。床上我杰哥，喊十块钱一双。\",\"name\":\"唐诗三百首\"}", Book.class);
        System.out.println(book.getId());

    }*/

    /*public static void main(String[] args) {

        Book book = new Book("1002","唐诗三百首","床前明月光，地上鞋一堆。床上我杰哥，喊十块钱一双。");
        //1.    转换
        String json = JSON.toJSONString(book);
        System.out.println(json);
    }
*/
/*
    public static void main(String[] args) {
        //1.    创建Gson对象
        Gson g = new Gson();
        //2.    转换  :  {"id":"100","name":"金苹果","info":"种植苹果真辛苦","page":["锄禾日当午","汗滴禾下土","嘿嘿嘿嘿嘿"]}
        HashMap data = g.fromJson("{\"id\":\"100\",\"name\":\"金苹果\",\"info\":\"种植苹果真辛苦\",\"page\":[\"锄禾日当午\",\"汗滴禾下土\",\"嘿嘿嘿嘿嘿\"]}", HashMap.class);
        List page = (List) data.get("page");
        System.out.println(page.get(1));
    }*/
   /* public static void main(String[] args) {
        //1.    创建Gson对象
        Gson g = new Gson();
        //2.    转换  :  {"id":"100","name":"金苹果","info":"种植苹果真辛苦"}
        Book b = g.fromJson("{\"id\":\"100\",\"name\":\"金苹果\",\"info\":\"种植苹果真辛苦\"}", Book.class);
        System.out.println(b.getId());
    }*/







/*
    public static void main(String[] args) {
        *//**1.    创建Gson对象
        Gson g = new Gson();
        //2.    转换
        Book b = new Book("100","金苹果","种植苹果真辛苦");
        String s = g.toJson(b);
        System.out.println(s);*//*

        //1.    创建Gson对象
        //2.    转换
        Book b = new Book("100","金苹果","种植苹果真辛苦");
        String s = new Gson().toJson(b);
        System.out.println(s);
    }*/
}
