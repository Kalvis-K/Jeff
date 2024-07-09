package org.codelex;

import java.util.List;
import java.util.Map;

public class SingleChoiceInputNode extends DialogNode {
    private final String content;
    private final List<String> options;
    private final String variable;


    public SingleChoiceInputNode(String content, List<String> options, String variable) {
        this.content = content;
        this.options = options;
        this.variable = variable;
    }

    public String getContent() {
        return content;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getVariable() {
        return variable;
    }

    @Override
    public String process(Map<String, String> variables, String input) {
        String userInput = input.trim();
        variables.put(getVariable(), userInput);
        return Message.displayMessage(variables, getContent());
    }
}
