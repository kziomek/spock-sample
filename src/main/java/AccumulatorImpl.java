/**
 * @author Krzysztof Ziomek
 * @since 07/12/2015.
 */
public class AccumulatorImpl implements Accumulator {

    private int total;

    /**
     * Initialize total by value 0.
     */
    public AccumulatorImpl() {
        total = 0;
    }

    public int accumulate(int... values) {
        int sum = 0;

        for (int i : values) {
            sum+=i;
        }
        this.total+=sum;

        return sum;
    }

    public void reset() {
        total = 0;
    }

    public int getTotal() {
        return total;
    }

}
