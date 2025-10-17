package com.datadesign.treegrid;

import com.datadesign.Deserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

@Data
public class TGUploadData {
    @JsonProperty String id;
    @JsonProperty String Def;
    @JsonProperty @JsonDeserialize(using = Deserializer.class) boolean Selected;
    @JsonProperty @JsonDeserialize(using = Deserializer.class) boolean Deleted;
    @JsonProperty @JsonDeserialize(using = Deserializer.class) boolean Changed;
    @JsonProperty int Moved;
    @JsonProperty @JsonDeserialize(using = Deserializer.class) boolean Added;
    @JsonProperty String Prev;
    @JsonProperty String Next;
    @JsonProperty String Copy;
}
