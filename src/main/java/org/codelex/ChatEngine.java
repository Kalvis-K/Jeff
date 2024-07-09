package org.codelex;

import java.util.*;

public class ChatEngine {
    private final Queue<DialogNode> dialogFlow;
    private final Map<String, String> variables;
    private boolean dialogEnded;

    public ChatEngine(List<DialogNode> dialogNodes) {
        this.dialogFlow = new LinkedList<>(dialogNodes);
        this.variables = new HashMap<>();
        this.dialogEnded = false;
    }

    public String receiveInput(String input) {
        if (!dialogEnded && !dialogFlow.isEmpty()) {
            DialogNode currentNode = dialogFlow.poll();
            String response = currentNode.process(variables, input);

            if (dialogFlow.isEmpty()) {
                dialogEnded = true;
            }

            return response;
        }
        dialogEnded = true;
        return null;
    }

    public boolean isDialogExhausted() {
        return dialogEnded;
    }
}

