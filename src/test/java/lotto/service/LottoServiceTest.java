package lotto.service;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Statistics;
import lotto.model.WinnerNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService();
    }

    @Test
    @DisplayName("로또가 로또 번호 6개로 제대로 생성되는지 확인한다.")
    void 로또_생성_성공() {
        int generateCnt = 6;
        List<Lotto> lottos = lottoService.generateLotto(generateCnt);
        assertThat(lottos.size()).isEqualTo(generateCnt);

        Lotto lotto = lottos.getFirst();
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호 6개가 모두 일치할 때 1등인지 확인한다.")
    void 로또_번호_6개_일치시_1등_성공() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinnerNumber winnerNumber = new WinnerNumber(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7, winnerNumber);

        Statistics result = lottoService.lottoResult(lotto, winnerNumber, bonusNumber);
        assertThat(result).isEqualTo(Statistics.FIRST);
    }

    @Test
    @DisplayName("로또 번호 5개와 보너스 번호가 일치할 때 2등인지 확인한다.")
    void 로또_번호_5개_일치와_보너스_번호_일치시_2등_성공() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinnerNumber winnerNumber = new WinnerNumber(List.of(1, 2, 3, 4, 5, 7));
        BonusNumber bonusNumber = new BonusNumber(6, winnerNumber);

        Statistics result = lottoService.lottoResult(lotto, winnerNumber, bonusNumber);
        assertThat(result).isEqualTo(Statistics.SECOND);
    }

    @Test
    @DisplayName("수익률 계산이 올바르지 확인한다.")
    void 수익률_계산이_올바르면_성공() {
        Map<Statistics, Integer> result = new EnumMap<>(Statistics.class);
        result.put(Statistics.FIRST, 1);
        result.put(Statistics.SECOND, 0);
        result.put(Statistics.THIRD, 0);
        result.put(Statistics.FOURTH, 0);
        result.put(Statistics.FIFTH, 0);
        result.put(Statistics.NONE, 0);

        int purchaseAmount = 6000;

        double profit = lottoService.calculateProfit(result, purchaseAmount);
        assertThat(profit).isEqualTo(33333333.3);
    }
}
