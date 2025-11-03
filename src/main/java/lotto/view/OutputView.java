package lotto.view;

import lotto.model.Lotto;
import lotto.model.Statistics;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PRINT_PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String PRINT_WINNER_MESSAGE = "당첨 통계";
    private static final String PRINT_DIVIDING_LINE = "---";
    private static final String PRINT_MATCH_COUNT_THREE = "3개 일치 (5,000원) - ";
    private static final String PRINT_MATCH_COUNT_FOUR = "4개 일치 (50,000원) - ";
    private static final String PRINT_MATCH_COUNT_FIVE = "5개 일치 (1,500,000원) - ";
    private static final String PRINT_MATCH_COUNT_FIVE_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String PRINT_MATCH_COUNT_SIX = "6개 일치 (2,000,000,000원) - ";
    private static final String PRINT_PROFIT_MESSAGE_PREFIX = "총 수익률은 ";
    private static final String PRINT_PROFIT_MESSAGE_SUFFIX = "%입니다.";

    public void printLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + PRINT_PURCHASE_MESSAGE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printResult(Map<Statistics, Integer> result, double profit) {
        System.out.println(PRINT_WINNER_MESSAGE);
        System.out.println(PRINT_DIVIDING_LINE);

        System.out.printf("%s%d개%n", PRINT_MATCH_COUNT_THREE, result.getOrDefault(Statistics.FIFTH, 0));
        System.out.printf("%s%d개%n", PRINT_MATCH_COUNT_FOUR, result.getOrDefault(Statistics.FOURTH, 0));
        System.out.printf("%s%d개%n", PRINT_MATCH_COUNT_FIVE, result.getOrDefault(Statistics.THIRD, 0));
        System.out.printf("%s%d개%n", PRINT_MATCH_COUNT_FIVE_BONUS, result.getOrDefault(Statistics.SECOND, 0));
        System.out.printf("%s%d개S%n", PRINT_MATCH_COUNT_SIX, result.getOrDefault(Statistics.FIRST, 0));

        System.out.println(PRINT_PROFIT_MESSAGE_PREFIX + profit + PRINT_PROFIT_MESSAGE_SUFFIX);
    }

}
