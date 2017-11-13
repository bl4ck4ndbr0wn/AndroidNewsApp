package com.alphaclicksolutions.ju5tu5.androidnewsapp.Interface;

import com.alphaclicksolutions.ju5tu5.androidnewsapp.Model.IconBetterIdea;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by JU5TU5 on 13-Nov-17.
 */

public interface IconBetterIdeaService {
    @GET
    Call<IconBetterIdea> getIconUrl(@Url String url);
}
