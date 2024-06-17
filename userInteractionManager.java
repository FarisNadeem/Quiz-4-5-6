import java.util.Scanner;

public class userInteractionManager {
    private Communication commManager;
    private String conversationId;

    public userInteractionManager(String remoteServiceUrl) {
        this.commManager = new Communication(remoteServiceUrl);
        this.conversationId = commManager.startConversation(); // Get ID when starting
    }

    public void startInteraction() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("You: ");
            String messageContent = scanner.nextLine();

            if (messageContent.equalsIgnoreCase("exit")) {
                break;
            }

            String jsonRequest = buildJsonRequest(messageContent);
            String jsonResponse = commManager.sendMessage(jsonRequest);
            processResponse(jsonResponse);
        }
        scanner.close();
    }

    private String buildJsonRequest(String messageContent) {
        // Construct JSON using the format from Quiz#4, including conversationId
        // ... (implementation based on Quiz#4's JSON structure)
        return messageContent;
    }

    private void processResponse(String jsonResponse) {
        // Parse JSON, extract chatbot's message, and display to the user
        // ... (implementation to handle chatbot's response)
    }
}
