package com.zino.undue.com.zino.undue.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Jo_seungwan on 2017. 5. 5..
 */
@ToString
public class JinhoReqestModel {
    @Getter
    @Setter
    @NonNull
    @JsonProperty("name")
    private String name;
}
