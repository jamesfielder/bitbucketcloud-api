package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Author {

    @NotNull
    @SerializedName("raw")
    private String mRaw = "";

    @Nullable
    @SerializedName("user")
    private Account mUser;

    @NotNull
    public String getRaw() {
        return mRaw;
    }

    @Nullable
    public Account getUser() {
        return mUser;
    }
}
