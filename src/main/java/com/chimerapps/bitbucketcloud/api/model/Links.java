package com.chimerapps.bitbucketcloud.api.model;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Links {

    public Links() { }

    public Links(@NotNull HashMap<String, Href> mLinks) {
        this.mLinks = mLinks;
    }

    @NotNull
    private HashMap<String, Href> mLinks = new LinkedHashMap<>();

    @NotNull
    public HashMap<String, Href> getLinks() {
        return mLinks;
    }

    @NotNull
    public static Links emptyLinks() {
        return new Links();
    }
}
