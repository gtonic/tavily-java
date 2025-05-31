package io.github.gtonic.tavily.sdk.demo;

import io.github.gtonic.tavily.sdk.TavilyClient;
import io.github.gtonic.tavily.sdk.model.SearchResponse;
import io.github.gtonic.tavily.sdk.model.SearchResult;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // IMPORTANT: Replace with your actual Tavily API key.
        // It's recommended to load the API key from an environment variable or a
        // configuration file in production.
        String apiKey = "tvly-XXX"; // This key is for example purposes
        TavilyClient tavilyClient = new TavilyClient(apiKey);

        try {
            String query = "What are the latest News from the National Football League (NFL)?";
            System.out.println("Performing search for: " + query);
            SearchResponse response = tavilyClient.search(query);

            System.out.println("\nQuery: " + response.getQuery());
            System.out.println("Response Time: " + response.getResponseTime() + "s");

            if (response.getAnswer() != null) {
                System.out.println("Answer: " + response.getAnswer());
            }

            if (response.getFollowUpQuestions() != null && !response.getFollowUpQuestions().isEmpty()) {
                System.out.println("Follow-up Questions:");
                for (String question : response.getFollowUpQuestions()) {
                    System.out.println("- " + question);
                }
            }

            System.out.println("\nResults:");
            if (response.getResults() != null) {
                for (SearchResult result : response.getResults()) {
                    System.out.println("\n  Title: " + result.getTitle());
                    System.out.println("  URL: " + result.getUrl());
                    System.out.println("  Content: " + result.getContent());
                    System.out.println("  Score: " + result.getScore());
                    if (result.getRawContent() != null) {
                        System.out.println("  Raw Content: " + result.getRawContent());
                    }
                }
            } else {
                System.out.println("No results found.");
            }

        } catch (IOException e) {
            System.err.println("An error occurred during the search: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                tavilyClient.close();
                System.out.println("\nTavily client closed.");
            } catch (IOException e) {
                System.err.println("Failed to close Tavily client: " + e.getMessage());
            }
        }
    }
}
