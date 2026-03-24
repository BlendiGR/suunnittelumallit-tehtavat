interface Text {
    void print();
    String getText();
}

class BasicText implements Text {

    private String text;

    public BasicText(String text){
        this.text = text;
    }

    @Override
    public void print() {
        System.out.println(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

class UpperCaseText implements Text {
    private Text text;

    public UpperCaseText(Text text){
        this.text = text;
    }

    @Override
    public void print() {
        System.out.println(text.getText().toUpperCase());
    }

    @Override
    public String getText() {
        return text.getText().toUpperCase();
    }
}

class ExlamationDecorator implements Text {
    private Text text;

    public ExlamationDecorator(Text text){
        this.text = text;
    }

    @Override
    public void print() {
        System.out.println(text.getText() + "!!!!");
    }

    @Override
    public String getText() {
        return text.getText();
    }
}

class Main {
    public static void main(String[] args) {
        Text t = new ExlamationDecorator(new UpperCaseText(new BasicText("hello")));
        t.print();
    }
}


