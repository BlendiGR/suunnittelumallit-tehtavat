package proxy;

public class DocumentProxy implements IDocumentService {
    private Document document;

    public DocumentProxy(Document document) {
        this.document = document;
    }


    @Override
    public String getContent() {
        return "";
    }

    public String getContent(User user) {
        boolean isAuthed = AccessControlService.getInstance().isAllowed(user, document);
        if (isAuthed) {
            return document.getContent();
        } else {
            throw new AccessDeniedException("Unauthorized!");
        }
    }

    @Override
    public String getCreationDate() {
        return document.getCreationDate();
    }

    @Override
    public String getIdentifier() {
        return document.getIdentifier();
    }

}
