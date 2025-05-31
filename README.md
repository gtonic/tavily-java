# Tavily Java SDK

This is an initial basic and unofficial Java SDK for the Tavily API.  
Beware of vibe-coding!

## Installation

To use this SDK in your Maven project, add the following dependency to your `pom.xml` file:

```xml
<dependency>
    <groupId>io.github.gtonic.tavily.sdk</groupId>
    <artifactId>tavily-java-sdk</artifactId>
    <version>1.0-SNAPSHOT</version> <!-- Or the latest version -->
</dependency>
```

Make sure to replace `1.0-SNAPSHOT` with the latest released version if applicable.

## Usage

To use the Tavily Java SDK, you will typically need to:

1.  **Import the necessary classes** from the SDK.
2.  **Instantiate the Tavily client** by providing your API key.
3.  **Call the desired methods** on the client instance to interact with the Tavily API.

### Example

```java
import io.github.gtonic.tavily.sdk.TavilyClient;
import io.github.gtonic.tavily.sdk.model.SearchRequest;
import io.github.gtonic.tavily.sdk.model.SearchResponse;

public class TavilyExample {

    public static void main(String[] args) {
        // Replace "YOUR_API_KEY" with your actual Tavily API key
        String apiKey = "YOUR_API_KEY";

        // Instantiate the client
        TavilyClient tavilyClient = new TavilyClient(apiKey);

        // Create a search request
        SearchRequest request = new SearchRequest("your search query");

        try {
            // Perform the search
            SearchResponse response = tavilyClient.search(request.getQuery());

            // Process the response
            System.out.println("Query: " + response.getQuery());
            System.out.println("Answer: " + response.getAnswer());
            System.out.println("Results: " + response.getResults());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                tavilyClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```

**Note:** The example above uses the actual classes provided by the SDK: `TavilyClient`, `SearchRequest`, and `SearchResponse` in the `io.github.gtonic.tavily.sdk` package.

## Building the SDK

To build the SDK from source, you can use Maven:

```bash
mvn clean install
```

This will compile the code, run tests (if any), and install the JAR file into your local Maven repository.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.
