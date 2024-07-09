package org.codelex;

import java.util.Map;

public class MessageNode extends DialogNode {
    private final String content;

    public MessageNode(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String process(Map<String, String> variables, String input) {
        return Message.displayMessage(variables, getContent());
    }
}
