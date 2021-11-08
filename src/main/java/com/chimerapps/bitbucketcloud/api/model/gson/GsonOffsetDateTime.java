package com.chimerapps.bitbucketcloud.api.model.gson;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class GsonOffsetDateTime implements JsonSerializer<OffsetDateTime>, JsonDeserializer<OffsetDateTime> {

    @Override
    public JsonElement serialize(OffsetDateTime src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));
    }

    @Override
    public OffsetDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return OffsetDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
}
