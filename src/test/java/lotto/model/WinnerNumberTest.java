package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnerNumberTest {
    @Test
    @DisplayName("우승한 1개의 로또 내에 로또 번호 개수가 6개이면 성공이다.")
    void 우승_로또_번호의_개수가_6개로_성공이다() {
        WinnerNumber lotto = new WinnerNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("우승한 1개의 로또 내에 로또 번호 개수가 6개가 넘어가면 실패이다.")
    void 우승_로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinnerNumber(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("우승한 로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void 우승_로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinnerNumber(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
