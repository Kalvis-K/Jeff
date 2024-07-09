package org.codelex;

import java.util.Map;

public class Message {

    public static String displayMessage(Map<String, String> variables, String content) {
        for (Map.Entry<String, String> entry : variables.entrySet()) {
            content = content.replace("${" + entry.getKey() + "}", entry.getValue());
        }
        return content;
    }
}
