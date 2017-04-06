package com.imudgesyy.ISBNQuery;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import com.imudgesyy.bean.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


/**
 * Created by yangyang on 2017/4/6.
 */
public class ISBNQuery {
    private static String BASE_URL = "https://api.douban.com/v2/book/isbn/:";
    private OkHttpClient client = new OkHttpClient.Builder().build();

    /**
     * OkHttp库，主要用来执行网络请求
     */

    public Book ISBNQuery(String ISBN) {
        if (ISBN == null || ISBN.equals("")) {
            return null;
        }
        Request request = new Request.Builder()
                .url(BASE_URL + ISBN)
                .build();

        Call call = client.newCall(request);

        Response response = null;
        Book book = new Book();
        try {
            response = call.execute();
            String body = response.body().string();
            Gson gson = new Gson();
            Map<String,Object> map = gson.fromJson(body,new TypeToken<Map<String,Object>>(){}.getType());


            book.setISBN((String) map.get("isbn13"));

            ArrayList<String> authorArray = (ArrayList) map.get("author");
            book.setAuthor(authorArray);

            book.setBinding((String) map.get("binding"));

            book.setImages((String) map.get("image"));

            book.setPages((String) map.get("pages"));

            book.setPrice((String) map.get("price"));

            book.setPubdate((String) map.get("pubdate"));

            book.setPublisher((String) map.get("publisher"));

            book.setSummary((String) map.get("summary"));

            book.setTitle((String) map.get("title"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return book;
    }
}
