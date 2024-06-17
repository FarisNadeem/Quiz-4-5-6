import java.net.http.*;
import java.net.URI;
import java.io.IOException;

public class SpecialCommunicationManager {

    private String commonServiceUrl;
    private String specialServiceUrl;
    private HttpClient client;
    private String conversationHistory = ""; // Store conversation history

    public SpecialCommunicationManager(String commonServiceUrl, String specialServiceUrl) {
        this.commonServiceUrl = commonServiceUrl;
        this.specialServiceUrl = specialServiceUrl;
        this.client = HttpClient.newHttpClient();
    }

    public String startConversation() {
        // ... (Same as in CommunicationManager, using commonServiceUrl)
        return null;
    }

    public String sendMessage(String jsonRequest) {
        String urlToUse = determineServiceUrl(jsonRequest);
        conversationHistory += jsonRequest; // Append new message to history

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlToUse))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException e) {
            // Handle exceptions appropriately
            return null;
        }
    }

    private String determineServiceUrl(String jsonRequest) {
        if (jsonRequest.toLowerCase().contains("help") || conversationHistory.toLowerCase().contains("help")) {
            return specialServiceUrl;
        } else {
            return commonServiceUrl;
        }
    }
}
