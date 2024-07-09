import org.codelex.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChatEngineTest {
    private ChatEngine chatEngine;

    @BeforeEach
    public void setUp() {
        List<DialogNode> dialogFlow = Main.createDialogFlow();
        chatEngine = new ChatEngine(dialogFlow);
    }

    @Test
    void testChatEngineInitialDialog() {
        String response = chatEngine.receiveInput("");
        assertEquals("Hi there, I'm Jeff 👋", response);
    }

    @Test
    void testChatEngineNameInputs() {
        chatEngine.receiveInput("");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("John");
        chatEngine.receiveInput("Doe");

        String response = chatEngine.receiveInput("");
        assertEquals("Nice to meet you, John Doe!", response);
    }

    @Test
    void testChatEngineEmailInput() {
        chatEngine.receiveInput("");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("John");
        chatEngine.receiveInput("Doe");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("");

        String response = chatEngine.receiveInput("john.doe@example.com");
        assertEquals("Fantastic. We are 70% done with the setup!", response);
    }

    @Test
    void testChatEngineDateInput() {
        chatEngine.receiveInput("");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("John");
        chatEngine.receiveInput("Doe");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("john.doe@example.com");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("");

        String response = chatEngine.receiveInput("01-01-2000");
        assertEquals("And what do you need the money for?", response);
    }

    @Test
    void testChatEnginePurposeInput() {
        chatEngine.receiveInput("");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("John");
        chatEngine.receiveInput("Doe");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("john.doe@example.com");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("01-01-2000");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("");
        chatEngine.receiveInput("");

        String response = chatEngine.receiveInput("2");
        assertEquals("Nice, I already have some options for you", response);
    }
}
