package com.chimerapps.bitbucketcloud.api;

import com.chimerapps.bitbucketcloud.api.model.Links;
import com.chimerapps.bitbucketcloud.api.model.gson.GsonLinks;
import com.chimerapps.bitbucketcloud.api.model.gson.GsonLocalDateTime;
import com.chimerapps.bitbucketcloud.api.model.gson.GsonOffsetDateTime;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

/**
 * @author nicolaverbeeck
 */
public class Bitbucket {

    private final BitbucketApi mApi;
    private final OkHttpClient mOkHttpClient;
    private final Gson gson;

    public Bitbucket(@NotNull final String username, @NotNull final String appToken) {
        this.gson = buildGsonInstance();

        mOkHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new AuthenticationInterceptor(username, appToken))
                .build();
        final Retrofit retrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .baseUrl("https://api.bitbucket.org/2.0/")
                .addConverterFactory(GsonConverterFactory.create(this.gson))
                .build();
        mApi = retrofit.create(BitbucketApi.class);
    }

    public BitbucketApi getApi() {
        return mApi;
    }

    public void shutdown() {
        mOkHttpClient.dispatcher().executorService().shutdown();
        mOkHttpClient.connectionPool().evictAll();
        try {
            final Cache cache = mOkHttpClient.cache();
            if (cache != null)
                cache.close();
        } catch (final IOException ignored) {
        }
    }

    private Gson buildGsonInstance() {
        final GsonBuilder gsonBuilder =
                new GsonBuilder()
                        .registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTime())
                        .registerTypeAdapter(OffsetDateTime.class, new GsonOffsetDateTime())
                        .registerTypeAdapter(Links.class, new GsonLinks());

        return gsonBuilder.create();
    }
}
