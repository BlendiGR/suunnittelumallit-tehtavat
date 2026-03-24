package memento;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Model model;
    private Gui gui;
    private int index = 0;
    private List<IMemento> history; // Memento history

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
        history.add(model.createMemento());

    }

    public void setOption(int optionNumber, int choice) {
        model.setOption(optionNumber, choice);
        saveToHistory();
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        model.setIsSelected(isSelected);
        saveToHistory();
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public List<IMemento> getHistory() {
        return history;
    }

    public void restoreToIndex(int i) {
        index = i;
        model.restoreState(history.get(i));
        gui.updateGui();
    }

    public void redo() {
        if (!history.isEmpty()) {
            if (history.size() - 1 > index) {
                System.out.println("Memento found in history");
                IMemento nextState = history.get(index + 1);
                model.restoreState(nextState);
                gui.updateGui();
                index++;
                System.out.println(index + " index now ");
            }
        }
    }

    public void undo() {
        if (!history.isEmpty()) {
            if (index > 0) {
                System.out.println("Memento found in history");
                IMemento previousState = history.get(index - 1);
                model.restoreState(previousState);
                gui.updateGui();
                index--;
                System.out.println(index + " index now ");
            }
        }
    }

    private void saveToHistory() {
        history.subList(index + 1, history.size()).clear();
        IMemento currentState = model.createMemento();
        history.add(currentState);
        index++;
        System.out.println(index + " index now ");
    }
}
