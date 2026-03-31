package proxy;

public class Document implements IDocumentService {
    private String identifier;
    private String creationDate;
    protected String content;

    public Document(String identifier, String creationDate, String content) {
        this.identifier = identifier;
        this.creationDate = creationDate;
        this.content = content;
    }


    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getCreationDate() {
        return creationDate;
    }

    public String getIdentifier() {
        return identifier;
    }
}
