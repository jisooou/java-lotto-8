package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    @DisplayName("로또 번호가 1~45 범위 내에 있으면 성공이다.")
    void 로또_번호가_범위_내이면_성공() {
        LottoNumber lottoNumber = new LottoNumber(27);
        assertThat(lottoNumber.getLottoNumber()).isEqualTo(27);
    }

    @Test
    @DisplayName("로또 번호가 1 미만이면 실패이다.")
    void 로또_번호가_1미만_일때_실패() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 45 초과하면 실패이다.")
    void 로또_번호가_45초과_일때_실패() {
        assertThatThrownBy(() -> new LottoNumber(79))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
