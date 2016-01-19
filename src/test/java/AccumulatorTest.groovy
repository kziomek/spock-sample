import spock.lang.Specification


/**
 * @author Krzysztof Ziomek
 * @since 07/12/2015.
 */
class AccumulatorTest extends Specification {


    def "The initial value of the running sum is 0."() {
        when:
        Accumulator accumulator = new AccumulatorImpl()

        then:
        accumulator.getTotal() == 0
    }


    def "The total sum can be set to 0 by calling reset(). Test reset as first call."() {

        given:
        Accumulator accumulator = new AccumulatorImpl();

        when:
        accumulator.reset()

        then:
        accumulator.getTotal() == 0

    }

    def "The total sum can be set to 0 by calling reset(). Should reset after accumulate. "() {

        given:
        Accumulator accumulator = new AccumulatorImpl();

        when:
        int firstSum = accumulator.accumulate(1);
        accumulator.reset()

        then:
        firstSum == 1
        accumulator.getTotal() == 0

    }

    def "The total sum can be set to 0 by calling reset(). Should reset between accumulate calls" () {

        given:
        Accumulator accumulator = new AccumulatorImpl();

        when:
        int firstSum = accumulator.accumulate(1);
        accumulator.reset()
        int secondSum = accumulator.accumulate(2);

        then:
        firstSum == 1
        secondSum == 2
        accumulator.getTotal() == 2

    }

    def "Adds one value to the running sum." () {

        given:
        Accumulator accumulator = new AccumulatorImpl();

        when:
        int firstSum = accumulator.accumulate(1);

        then:
        firstSum == 1
        accumulator.getTotal() == 1

    }

    def "Adds more values to the running sum. Test by one accumulate call" () {

        given:
        Accumulator accumulator = new AccumulatorImpl();

        when:
        int firstSum = accumulator.accumulate(1, 2);

        then:
        firstSum == 3
        accumulator.getTotal() == 3

    }

    def "Adds more values to the running sum. Test by two accumulate calls" () {

        given:
        Accumulator accumulator = new AccumulatorImpl();

        when:
        int firstSum = accumulator.accumulate(1);
        int secondSum = accumulator.accumulate(2);

        then:
        firstSum == 1
        secondSum == 2
        accumulator.getTotal() == 3

    }


    def "In this case, the value of {@code firstSum} is 6, {@code secondSum} is 4 and the value of {@code total} is 10. "() {

        given:
        Accumulator accumulator = new AccumulatorImpl();

        when:
        int firstSum = accumulator.accumulate(1, 2, 3);
        int secondSum = accumulator.accumulate(4);
        int total = accumulator.getTotal();

        then:
        firstSum == 6;
        secondSum == 4;
        total == 10
    }


}