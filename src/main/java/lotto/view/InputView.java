package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.ConvertToNumber;

import java.util.List;

public class InputView {
    private static final String PURCHASE_INPUT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String readPurchasePrice() {
        System.out.println(PURCHASE_INPUT);
        return Console.readLine();
    }

    public List<Integer> readWinningNumber() {
        System.out.println(WINNING_NUMBER);
        String input = Console.readLine();
        return ConvertToNumber.parse(input);
    }

    public int readBonusNumber() {
        System.out.println(BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }
}
