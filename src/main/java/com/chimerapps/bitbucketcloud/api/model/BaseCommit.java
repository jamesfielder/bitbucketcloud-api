package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;
import java.util.List;

public class BaseCommit {

    @NotNull
    @SerializedName("hash")
    private String mHash = "";

    @Nullable
    @SerializedName("date")
    private OffsetDateTime mDate = null;

    @Nullable
    @SerializedName("author")
    private Author mAuthor = null;

    @NotNull
    @SerializedName("message")
    private String mMessage = "";

    @Nullable
    @SerializedName("summary")
    private CommitMessage mSummary = null;

    @SerializedName("parents")
    private List<BaseCommit> mParents = null;

    @NotNull
    public String getHash() {
        return mHash;
    }

    @Nullable
    public OffsetDateTime getDate() {
        return mDate;
    }

    @Nullable
    public Author getAuthor() {
        return mAuthor;
    }

    @NotNull
    public String getMessage() {
        return mMessage;
    }

    @Nullable
    public CommitMessage getSummary() {
        return mSummary;
    }

    public List<BaseCommit> getParents() {
        return mParents;
    }
}
