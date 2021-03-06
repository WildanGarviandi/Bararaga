package com.ragamania.bararaga.data.remote;

import android.content.Context;

import com.ragamania.bararaga.BuildConfig;
import com.ragamania.bararaga.model.ArticleDetail.BaseResponseArticleDetail;
import com.ragamania.bararaga.model.ArticlesModel.BaseResponseArticles;
import com.ragamania.bararaga.model.BaseResponseCoaches;
import com.ragamania.bararaga.model.BaseResponsePlaces;
import com.ragamania.bararaga.model.ChatListModel.BaseReponseChatList;
import com.ragamania.bararaga.model.DetailCoaches.BaseResponseDetailCoach;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface APIService {

    String ENDPOINT = "https://api.myjson.com/bins/";
    String API_KEY = "aa9af8d39d6519b1d47dec305bd253a4";

    @GET("4xwzo")
    Observable<BaseResponsePlaces> getPlaceList();

    @GET("55law")
    Observable<BaseResponseCoaches> getCoachesList();

    @GET("3fkfu")
    Observable<BaseResponseDetailCoach> getDetailCoach();

    @GET("4bjwm")
    Observable<BaseResponseArticles> getArticles();

    @GET("440rs")
    Observable<BaseResponseArticleDetail> getDetailArticle();

    //TODO : Upload the json
    @GET("2yyef")
    Observable<BaseReponseChatList> getListMessage();

//    Observable<BaseResponseArticles> getArticles(@Query("index") int index, @Query("offsets") int offsets);


//    @GET("data/2.5/weather?APPID=" + API_KEY)
//    Observable<WeatherPojo> getWeatherForLatLon(@Query("lat") double lat, @Query("lng") double lng, @Query("units") String units);

    class Factory {

        public static APIService create(Context context) {

            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            builder.readTimeout(30, TimeUnit.SECONDS);
            builder.connectTimeout(20, TimeUnit.SECONDS);
            builder.writeTimeout(60, TimeUnit.SECONDS);

            //builder.certificatePinner(new CertificatePinner.Builder().add("*.androidadvance.com", "sha256/RqzElicVPA6LkKm9HblOvNOUqWmD+4zNXcRb+WjcaAE=")
            //    .add("*.xxxxxx.com", "sha256/8Rw90Ej3Ttt8RRkrg+WYDS9n7IS03bk5bjP/UXPtaY8=")
            //    .add("*.xxxxxxx.com", "sha256/Ko8tivDrEjiY90yGasP6ZpBU4jwXvHqVvQI0GS3GNdA=")
            //    .add("*.xxxxxxx.com", "sha256/VjLZe/p3W/PJnd6lL8JVNBCGQBZynFLdZSTIqcO0SJ8=")
            //    .build());

            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
                builder.addInterceptor(interceptor);
            }

            //Extra Headers
//            builder.addNetworkInterceptor(chain -> {
//                Request request = chain.request().newBuilder().addHeader("Authorization", authToken).build();
//                return chain.proceed(request);
//            });

            int cacheSize = 10 * 1024 * 1024; // 10 MiB
            Cache cache = new Cache(context.getCacheDir(), cacheSize);
            builder.cache(cache);

            builder.addInterceptor(new UnauthorisedInterceptor(context));
            OkHttpClient client = builder.build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(APIService.ENDPOINT)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();

            return retrofit.create(APIService.class);
        }
    }
}