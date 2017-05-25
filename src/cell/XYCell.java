package cell;

/**
 * ionutciuta24@gmail.com on 25.05.2017.
 */
public class XYCell {
    public int x, y;

    public XYCell(int x, int y) {
        this.x = x; this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        XYCell xyCell = (XYCell) o;

        if (x != xyCell.x) return false;
        return y == xyCell.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
