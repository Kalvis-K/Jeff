package org.codelex;

import java.util.Map;

public abstract class DialogNode {
    public abstract String process(Map<String, String> variables, String input);
}
