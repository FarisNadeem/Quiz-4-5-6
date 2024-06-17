import java.net.http.*; // For HTTP requests
import java.net.URI;
import java.io.IOException;

public class CommunicationManager {
    private String remoteServiceUrl;
    private HttpClient client;

    public CommunicationManager(String remoteServiceUrl) {
        this.remoteServiceUrl = remoteServiceUrl;
        this.client = HttpClient.newHttpClient();
    }

    public String startConversation() {
        // Send an initial request to the chatbot to get a conversation ID
        // ... (implementation to initiate a new conversation)
        return null;
    }

    public String sendMessage(String jsonRequest) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(remoteServiceUrl))
                    .header("Content-Type", "application/json") // Essential for JSON
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body(); // JSON response from the chatbot

        } catch (IOException | InterruptedException e) {
            // Handle exceptions appropriately (log, retry, etc.)
            return null; // Or an error message
        }
    }
}
