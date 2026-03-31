package proxy;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        User matti = new User("Matti");
        User blendi = new User("Blendi");

        IDocumentService publicDoc = library.createDocument("This is a public document.");
        IDocumentService protectedDoc1 = library.createProtectedDocument("Top secret content for Matti.");
        IDocumentService protectedDoc2 = library.createProtectedDocument("Confidential content for Blendi.");

        matti.addPermissionToDocument(protectedDoc1.getIdentifier());
        blendi.addPermissionToDocument(protectedDoc2.getIdentifier());

        System.out.println("=== Public Document ===");
        System.out.println("Creation date: " + publicDoc.getCreationDate());
        System.out.println("Content: " + publicDoc.getContent());

        System.out.println("\n=== Matti accessing his document ===");
        System.out.println("Creation date: " + protectedDoc1.getCreationDate());
        try {
            System.out.println("Content: " + ((DocumentProxy) protectedDoc1).getContent(matti));
        } catch (AccessDeniedException e) {
            System.out.println("Access denied: " + e.getMessage());
        }

        System.out.println("\n=== Blendi trying to access Matti's document ===");
        try {
            System.out.println("Content: " + ((DocumentProxy) protectedDoc1).getContent(blendi));
        } catch (AccessDeniedException e) {
            System.out.println("Access denied: " + e.getMessage());
        }

        System.out.println("\n=== Blendi accessing his document ===");
        try {
            System.out.println("Content: " + ((DocumentProxy) protectedDoc2).getContent(blendi));
        } catch (AccessDeniedException e) {
            System.out.println("Access denied: " + e.getMessage());
        }

        System.out.println("\n=== Creation dates (no auth needed) ===");
        System.out.println("protectedDoc1 date: " + protectedDoc1.getCreationDate());
        System.out.println("protectedDoc2 date: " + protectedDoc2.getCreationDate());
    }
}
