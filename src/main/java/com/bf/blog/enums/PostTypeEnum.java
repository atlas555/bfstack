package com.bf.blog.enums;

import java.util.HashMap;
import java.util.Map;

public enum PostTypeEnum {

    Normal(0, "热"), //

    ;

    private String description;

    private int type;

    private static Map<Integer, PostTypeEnum> statusMap;

    static {
        statusMap = new HashMap<Integer, PostTypeEnum>();
        for (PostTypeEnum type : PostTypeEnum.values()) {
            statusMap.put(type.getType(), type);
        }
    }

    public static PostTypeEnum getArtileTypeEnum(int type) {
        return statusMap.get(type);
    }

    private PostTypeEnum(int type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getType() {
        return type;
    }
}
