package lotto.view;

import lotto.component.Lotto;
import lotto.constant.MessageConstants;
import lotto.component.Prize;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void requestPurchaseAmount() {
        System.out.println(MessageConstants.REQUEST_PURCHASE_AMOUNT);
    }

    public static void printLottoTickets(int numberOfTickets, List<Lotto> lottos) {
        System.out.println();
        System.out.println(String.format(MessageConstants.PURCHASED_LOTTO_COUNT, numberOfTickets));
        lottos.stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public static void requestWinningNumbers() {
        System.out.println();
        System.out.println(MessageConstants.REQUEST_WINNING_NUMBERS);
    }

    public static void requestBonusNumber() {
        System.out.println();
        System.out.println(MessageConstants.REQUEST_BONUS_NUMBER);
    }

    public static void printResultTitle() {
        System.out.println();
        System.out.println(MessageConstants.WINNING_STATISTICS);
        System.out.println(MessageConstants.STATISTICS_DIVIDER);
    }

    public static void printWinningResults(Map<Prize, Integer> prizeResults) {
        for (Prize prize : Prize.values()) {
            if (prize == Prize.NONE) {
                break;
            }
            String resultMessage = MessageConstants.MATCH_RESULT_FORMAT;
            if (prize.isBonusMatched()) {
                resultMessage = MessageConstants.MATCH_BONUS_RESULT_FORMAT;
            }
            System.out.println(String.format(
                    resultMessage,
                    prize.getCorrectNumberCount(),
                    prize.getPrize(),
                    prizeResults.getOrDefault(prize,0)));
        }
    }

    public static void printBenefitRate(String benefitRate){
        System.out.println(String.format(MessageConstants.TOTAL_RETURN_RATE, benefitRate));

    }
}
