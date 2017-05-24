package cell;

/**
 * ionutciuta24@gmail.com on 24.05.2017.
 */
public enum Equipment {
    EQ1("eq1", 0),
    EQ2("eq2", 1),
    EQ3("eq3", 2);

    private String name;
    private int numericVal;

    Equipment(String name, int numericVal) {
        this.name = name;
        this.numericVal = numericVal;
    }

    public String getName() {
        return name;
    }

    public int getNumericVal() { return numericVal; }
}
