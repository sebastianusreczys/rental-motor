
package com.java.web.config;

import lombok.Data;

@Data
public final class FlashMessage {
    private String content;
    private String type;
    private String cssClass;

    public FlashMessage(String content, String type, String cssClass) {
        this.content = content;
        this.type = type;
        this.cssClass = cssClass;
    }
    
    
    
}
