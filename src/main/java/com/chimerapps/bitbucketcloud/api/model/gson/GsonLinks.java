package com.chimerapps.bitbucketcloud.api.model.gson;

import com.chimerapps.bitbucketcloud.api.model.Href;
import com.chimerapps.bitbucketcloud.api.model.Links;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class GsonLinks implements JsonSerializer<Links>, JsonDeserializer<Links> {

    @Override
    public Links deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        HashMap<String, Href> links = new LinkedHashMap<>();
        json.getAsJsonObject().entrySet().forEach(e -> {
            Href href = context.deserialize(e.getValue(), Href.class);
            links.put(e.getKey(), href);
        });

        return new Links(links);
    }

    @Override
    public JsonElement serialize(Links src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject linksObject = new JsonObject();

        src.getLinks().forEach((name, href) -> linksObject.add(name, context.serialize(href)));

        return linksObject;
    }
}
