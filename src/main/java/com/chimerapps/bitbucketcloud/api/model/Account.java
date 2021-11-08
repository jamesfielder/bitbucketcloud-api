package com.chimerapps.bitbucketcloud.api.model;

import com.google.gson.annotations.SerializedName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.time.OffsetDateTime;

public class Account {
    @NotNull
    @SerializedName("links")
    private Links mLinks = Links.emptyLinks();

    @NotNull
    @SerializedName("username")
    private String mUsername = "";

    @NotNull
    @SerializedName("nickname")
    private String mNickname = "";

    @NotNull
    @SerializedName("account_status")
    private String mAccountStatus = "";

    @NotNull
    @SerializedName("display_name")
    private String mDisplayName = "";

    @NotNull
    @SerializedName("website")
    private String mWebsite = "";

    @Nullable
    @SerializedName("created_on")
    private OffsetDateTime mCreatedOn = null;

    @NotNull
    @SerializedName("uuid")
    private String mUuid = "";

    @Nullable
    @SerializedName("has_2fa_enabled")
    private Boolean mHas2faEnabled = null;

    @NotNull
    public Links getLinks() {
        return mLinks;
    }

    @NotNull
    public String getUsername() {
        return mUsername;
    }

    @NotNull
    public String getNickname() {
        return mNickname;
    }

    @NotNull
    public String getAccountStatus() {
        return mAccountStatus;
    }

    @NotNull
    public String getDisplayName() {
        return mDisplayName;
    }

    @NotNull
    public String getWebsite() {
        return mWebsite;
    }

    @Nullable
    public OffsetDateTime getCreatedOn() {
        return mCreatedOn;
    }

    @NotNull
    public String getUuid() {
        return mUuid;
    }

    @Nullable
    public Boolean getHas2faEnabled() {
        return mHas2faEnabled;
    }
}
