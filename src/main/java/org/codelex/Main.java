package org.codelex;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<DialogNode> dialogFlow = createDialogFlow();
        ChatEngine chatEngine = new ChatEngine(dialogFlow);
        Scanner scanner = new Scanner(System.in);

        while (!chatEngine.isDialogExhausted()) {
            String output = chatEngine.receiveInput(scanner.nextLine());
            System.out.println(output);
        }
    }

    public static List<DialogNode> createDialogFlow() {
        return List.of(
                new MessageNode("Hi there, I'm Jeff 👋"),
                new MessageNode("Your new best friend for finding great loan offers!"),
                new MessageNode("First things first - let's get your account set up 🛠"),
                new TextInputNode("What is your first name?", "firstName"),
                new TextInputNode("And what is your last name?", "lastName"),
                new MessageNode("Nice to meet you, ${firstName} ${lastName}!"),
                new MessageNode("${firstName}, what's your email address?"),
                new TextInputNode("", "email"),
                new MessageNode("Fantastic. We are 70% done with the setup!"),
                new TextInputNode("Your age is another important value for finding the best offers. \nPlease enter your date of birth 📅", "date"),
                new MessageNode("And what do you need the money for?"),
                new SingleChoiceInputNode("Please choose an option:", List.of("Home", "Car", "Holidays", "Big Event"), "purpose"),
                new MessageNode("Nice, I already have some options for you")
        );
    }
}
