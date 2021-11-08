package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;

public class CommitMessage {

    @NotNull
    @SerializedName("raw")
    private String mRaw = "";

    @NotNull
    @SerializedName("markup")
    private String mMarkup = "";

    @NotNull
    @SerializedName("html")
    private String mHtml = "";

    @NotNull
    @SerializedName("type")
    private String mType = "";

    public String getRaw() {
        return mRaw;
    }

    public String getMarkup() {
        return mMarkup;
    }

    public String getHtml() {
        return mHtml;
    }

    public String getType() {
        return mType;
    }
}
