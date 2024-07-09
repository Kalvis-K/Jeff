package org.codelex;

import java.util.Map;

public class TextInputNode extends DialogNode {
    private final String content;
    private final String variable;

    public TextInputNode(String content, String variable) {
        this.content = content;
        this.variable = variable;
    }

    public String getContent() {
        return content;
    }

    public String getVariable() {
        return variable;
    }

    @Override
    public String process(Map<String, String> variables, String input) {
        String userInput = input.trim();
        variables.put(variable, userInput);
        return Message.displayMessage(variables, getContent());
    }
}
