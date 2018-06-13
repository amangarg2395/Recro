//package com.amangarg.recrotask2.rest;
//
//import android.support.annotation.NonNull;
//
//import com.amangarg.recrotask2.BuildConfig;
////import com.amangarg.recrotask2.service.ProductsService;
//import com.amangarg.recrotask2.utils.BaseConfiguration;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//import okhttp3.Interceptor;
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//import okhttp3.logging.HttpLoggingInterceptor;
//import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class RestProvider {
//    private static Retrofit provideRxRetrofit() {
//        return new Retrofit.Builder()
//                .baseUrl(BaseConfiguration.BASE_URL)
//                .client(provideOkHttpClient())
//                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//    }
//
//    private static OkHttpClient provideOkHttpClient() {
//        OkHttpClient.Builder client = new OkHttpClient.Builder();
//        if (BuildConfig.DEBUG) {
//            client.addInterceptor(new HttpLoggingInterceptor()
//                    .setLevel(HttpLoggingInterceptor.Level.BODY));
//        }
//        client.addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request original = chain.request();
//                Request request = original.newBuilder()
//                        .addHeader("Accept", "application/json")
//                        .addHeader("Content-Type", "application/json")
//                        .method(original.method(), original.body())
//                        .build();
//                return chain.proceed(request);
//            }
//        });
//        client.connectTimeout(3, TimeUnit.MINUTES)
//                .readTimeout(3, TimeUnit.MINUTES)
//                .writeTimeout(3, TimeUnit.MINUTES);
//        return client.build();
//    }
//
//    @NonNull
//    public static ProductsService getProductsService() {
//        return provideRxRetrofit().create(ProductsService.class);
//    }
//
//
//}
