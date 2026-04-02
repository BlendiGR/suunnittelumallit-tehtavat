package builder;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<PCPart> parts;

    public Computer() {
        this.parts = new ArrayList<>();
    }

    public void addPart(PCPart part){
        parts.add(part);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (PCPart part : parts) {
            sb.append(part.getPartName());
            sb.append(" ").append(part.getSpecifications());
            sb.append("\n");
        }
        return sb.toString();
    }

}
