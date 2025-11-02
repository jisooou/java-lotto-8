package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @Test
    @DisplayName("보너스 번호가 1~45 범위 내에 있으면 성공이다.")
    void 보너스_번호가_범위_내이면_성공() {
        WinnerNumber winnerNumber = new WinnerNumber(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winnerNumber);
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }

    @Test
    @DisplayName("로또 번호가 1 미만이면 실패이다.")
    void 보너스_번호가_1미만_일때_실패() {
        WinnerNumber winnerNumber = new WinnerNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(-3, winnerNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 45 초과하면 실패이다.")
    void 로또_번호가_45초과_일때_실패() {
        WinnerNumber winnerNumber = new WinnerNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(73, winnerNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 번호와 로또 번호가 중복되면 실패이다.")
    void 보너스_번호와_로또_번호가_중복이면_실패() {
        WinnerNumber winnerNumber = new WinnerNumber(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new BonusNumber(6, winnerNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
