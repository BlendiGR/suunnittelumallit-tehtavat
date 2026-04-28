package facade;

import java.io.IOException;

public class APIFacade {
    private final ApiClient api;

    public APIFacade() {
        this.api = new ApiClient();
    }

    public String getAttributeValueFromJson(String urlString, String attributeName) throws IllegalArgumentException, IOException {
            String result = api.fetch(urlString, attributeName);
            return result;
    }
}
