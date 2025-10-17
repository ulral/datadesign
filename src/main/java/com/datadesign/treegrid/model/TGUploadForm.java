package com.datadesign.treegrid;

import com.datadesign.TGFormData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@TGFormData
public class TGUploadForm<T extends TGUploadData> {
    @JsonProperty("IO")
    private Map<String, Object> IO;
    @JsonProperty("Changes")
    private List<T> Changes;
    @JsonProperty("Body")
    private List<List<T>> Body;
}
