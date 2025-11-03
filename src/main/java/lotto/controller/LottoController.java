package lotto.controller;

import lotto.model.*;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        try {
            PurchasePrice purchasePrice = getPurchasePrice();
            List<Lotto> lottos = generateAndPrintLotto(purchasePrice);

            WinnerNumber winnerNumber = getWinnerNumber();
            BonusNumber bonusNumber = getBonusNumber(winnerNumber);

            printResult(lottos, winnerNumber, bonusNumber, purchasePrice);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            run();
        }
    }

    private PurchasePrice getPurchasePrice() {
        return new PurchasePrice(inputView.readPurchasePrice());
    }

    private List<Lotto> generateAndPrintLotto(PurchasePrice purchasePrice) {
        List<Lotto> lottos = lottoService.generateLotto(purchasePrice.getCount());
        outputView.printLotto(lottos);
        return lottos;
    }

    private WinnerNumber getWinnerNumber() {
        return new WinnerNumber(inputView.readWinningNumber());
    }

    private BonusNumber getBonusNumber(WinnerNumber winnerNumber) {
        return new BonusNumber(inputView.readBonusNumber(), winnerNumber);
    }

    private void printResult(List<Lotto> lottos, WinnerNumber winnerNumber, BonusNumber bonusNumber, PurchasePrice purchasePrice) {
        Map<Statistics, Integer> result = lottoService.allLottoResult(lottos, winnerNumber, bonusNumber);
        double profit = lottoService.calculateProfit(result, purchasePrice.getAmount());
        outputView.printResult(result, profit);
    }
}