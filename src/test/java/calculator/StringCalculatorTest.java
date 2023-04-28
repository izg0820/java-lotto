package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {


    private StringCalculator stringCalculator;

    @BeforeEach
    public void beforeEach() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void isNullOrEmpty() {
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.isNullOrEmpty(null));
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.isNullOrEmpty(""));
    }

    @Test
    public void split() {
        assertThat(stringCalculator.split("1 + 2 / 3").size()).isEqualTo(5);
        assertThat(stringCalculator.split("1 + 2").size()).isEqualTo(3);
    }

    @Test
    public void isOnlyNumAndOperator() {
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.isOnlyNumAndOperator("1 + 2 ) 3"));
    }

    @Test
    public void calculateTest() {
        assertThat(stringCalculator.calculate("1 + 2 / 3 * 5")).isEqualTo(5);
        assertThat(stringCalculator.calculate("1 + 2 * 3 * 5")).isEqualTo(45);
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.calculate("1 + 2 * 3 @ 5"));
    }
}
