package com.alphaclicksolutions.ju5tu5.androidnewsapp.Common;

import com.alphaclicksolutions.ju5tu5.androidnewsapp.Interface.IconBetterIdeaService;
import com.alphaclicksolutions.ju5tu5.androidnewsapp.Interface.NewsService;
import com.alphaclicksolutions.ju5tu5.androidnewsapp.Remote.IconBetterIdeaClient;
import com.alphaclicksolutions.ju5tu5.androidnewsapp.Remote.RetrofitClient;



/**
 * Created by JU5TU5 on 13-Nov-17.
 */

public class Common {
    private static final String BASE_URL="https://newsapi.org/";

    public static  final String API_KEY="ac047ea28a3645aea158059da6661720";

    public static NewsService getNewsService()
    {
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }
    public static IconBetterIdeaService getIconService()
    {
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }

}
