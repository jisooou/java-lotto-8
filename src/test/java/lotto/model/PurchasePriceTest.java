package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchasePriceTest {

    @Test
    @DisplayName("구매 금액을 제대로 입력하면 성공이다.")
    void 구매_금액_정상_입력() {
        PurchasePrice purchasePrice = new PurchasePrice("4000");
        assertThat(purchasePrice.getCount()).isEqualTo(4);
    }

    @Test
    @DisplayName("구매 금액에 문자열을 입력하면 예외처리한다.")
    void 구매_금액_문자열_입력시_실패() {
        assertThatThrownBy(() -> new PurchasePrice("2000원"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 금이 1000원 단위가 아니면 예외처리한다.")
    void 구매_금액_1000원_단위_아니면_실패() {
        assertThatThrownBy(() -> new PurchasePrice("2700"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
