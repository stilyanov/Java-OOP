package WorkingWithAbstraction.Exercise.P05_JediGalaxy;

public class Field {
    private int[][] field;

    public Field(int[][] field) {
        this.field = field;
        this.setFieldValue();
    }

    public int getLength() {
        return field.length;
    }

    public int getRowLength(int row) {
        return field[row].length;
    }

    public void setNewValue(int row, int col, int newValue) {
        field[row][col] = newValue;
    }

    public int getValue(int row, int col) {
        return field[row][col];
    }

    private void setFieldValue() {
        int value = 0;

        for (int row = 0; row < this.field.length; row++) {
            for (int col = 0; col < this.field[row].length; col++) {
                field[row][col] = value++;
            }
        }
    }
}
