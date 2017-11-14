package com.alphaclicksolutions.ju5tu5.androidnewsapp.Common;

import com.alphaclicksolutions.ju5tu5.androidnewsapp.Interface.IconBetterIdeaService;
import com.alphaclicksolutions.ju5tu5.androidnewsapp.Interface.NewsService;
import com.alphaclicksolutions.ju5tu5.androidnewsapp.Remote.IconBetterIdeaClient;
import com.alphaclicksolutions.ju5tu5.androidnewsapp.Remote.RetrofitClient;



/**
 * Created by JU5TU5 on 13-Nov-17.
 */

public class Common {
    public static  final String API_KEY="ac047ea28a3645aea158059da6661720";
    private static final String BASE_URL = "https://newsapi.org/";

    public static NewsService getNewsService()
    {
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }
    public static IconBetterIdeaService getIconService()
    {
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }

    // https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=ac047ea28a3645aea158059da6661720
    public static String getApiUrl(String source, String sortBy, String apiKEY) {
        StringBuilder apiUrl = new StringBuilder("https://newsapi.org/v1/articles?source=");
        return apiUrl.append(source)
                .append("&sortBy=")
                .append(sortBy)
                .append("&apiKey=")
                .append(apiKEY)
                .toString();
    }

}
