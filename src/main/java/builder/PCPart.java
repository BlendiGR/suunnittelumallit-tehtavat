package builder;

public class PCPart {
    private String partName;
    private String specifications;

    public PCPart(String partName, String specifications) {
        this.partName = partName;
        this.specifications = specifications;
    }

    public String getPartName() {
        return partName;
    }

    public String getSpecifications() {
        return specifications;
    }
}
