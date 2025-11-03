package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int LOTTO_SIZE = 6;

    public List<Lotto> generateLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> number = Randoms.pickUniqueNumbersInRange(MIN, MAX, LOTTO_SIZE)
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            lottos.add(new Lotto(number));
        }
        return lottos;
    }

    public Statistics lottoResult(Lotto lotto, WinnerNumber winnerNumber, BonusNumber bonusNumber) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        List<Integer> winnerNumbers = winnerNumber.getNumbers();

        int matchCount = 0;
        for (int number : lottoNumbers) {
            if (winnerNumbers.contains(number)) {
                matchCount++;
            }
        }
        boolean bonusMatch = lottoNumbers.contains(bonusNumber.getBonusNumber());
        return Statistics.findRank(matchCount, bonusMatch);
    }

    public Map<Statistics, Integer> allLottoResult(List<Lotto> lottos, WinnerNumber winnerNumber, BonusNumber bonusNumber) {
        Map<Statistics, Integer> result = new EnumMap<>(Statistics.class);
        for (Statistics s : Statistics.values()) {
            result.put(s, 0);
        }
        for (Lotto lotto : lottos) {
            Statistics rank = lottoResult(lotto, winnerNumber, bonusNumber);
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    public double calculateProfit(Map<Statistics, Integer> result, int purchaseAmount) {
        long totalPrize = 0;
        for (Statistics s : result.keySet()) {
            totalPrize += (long) s.getPrize() * result.get(s);
        }
        double profit = (double) totalPrize / purchaseAmount * 100;
        return Math.round(profit * 10) / 10.0;
    }
}
