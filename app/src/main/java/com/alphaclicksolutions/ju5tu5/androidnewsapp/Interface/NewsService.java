package com.alphaclicksolutions.ju5tu5.androidnewsapp.Interface;

import com.alphaclicksolutions.ju5tu5.androidnewsapp.Model.WebSite;
import retrofit2.Call;
import retrofit2.http.GET;
import java.lang.annotation.Target;

/**
 * Created by JU5TU5 on 11-Nov-17.
 */

public interface NewsService {
    @GET("v1/sources?language=en")
    Call<WebSite> getSources();
}
