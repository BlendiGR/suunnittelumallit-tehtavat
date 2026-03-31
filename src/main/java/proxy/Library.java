package proxy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.UUID;

public class Library {
    private HashMap<String, IDocumentService> documents;

    public Library(){
        this.documents = new HashMap<>();
    };

    public HashMap<String, IDocumentService> getDocuments() {
        return documents;
    }

    public void addToLibrary(IDocumentService document){
        documents.put(document.getIdentifier(), document);
    }

    public IDocumentService createDocument(String content){
        Document document = new Document(UUID.randomUUID().toString(), LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), content);
        addToLibrary(document);
        return document;
    }

    public IDocumentService createProtectedDocument(String content) {
        Document document = new Document(UUID.randomUUID().toString(), LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), content);
        IDocumentService proxy = new DocumentProxy(document);
        addToLibrary(proxy);

        return proxy;
    }
}
