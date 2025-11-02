package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConvertToNumberTest {
    @Test
    @DisplayName("문자열을 숫자로 변환하면 성공이다.")
    void 문자열_숫자로_변환_성공() {
        List<Integer> result = ConvertToNumber.parse("1, 2, 3, 4, 5, 6");
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("숫자가 아닌 값이 들어가 있으면 예외를 처리한다.")
    void 숫자가_아닌_값이_들어오면_실패() {
        assertThatThrownBy(() -> ConvertToNumber.parse("1, a, 2, 3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
