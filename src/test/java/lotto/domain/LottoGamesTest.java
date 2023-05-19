package lotto.domain;

import lotto.domain.generator.TestLottoGenerator;
import lotto.domain.number.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGamesTest {

    private TestLottoGenerator testLottoGenerator;

    @BeforeEach
    public void beforeEach() {
        testLottoGenerator = new TestLottoGenerator();
    }

    @Test
    @DisplayName("보너스 번호 일치")
    public void bonusCheck() {
        //given
        Lotto lotto = new Lotto(new TestLottoGenerator());
        List<Lotto> lottoList = List.of(lotto);
        LottoGames lottoGames = new LottoGames(lottoList);
        Lotto winningLotto = new Lotto(new String[]{"1", "2", "3", "41", "42", "6"});
        LottoNumber bonusNumber = new LottoNumber(43);
        EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class){{
            put(Rank.SECOND, 1);
        }};

        //when
        lottoGames.calculatePrizeCount(winningLotto, bonusNumber);

        //then
        assertThat(lottoGames.getLottoResult().entrySet()).isEqualTo(result.entrySet());
    }

    @Test
    @DisplayName("로또 총상금 계산")
    public void sum() {
        //given
        Lotto lotto = new Lotto(testLottoGenerator);
        List<Lotto> lottoList = List.of(lotto);
        LottoGames lottoGames = new LottoGames(lottoList);
        Lotto winningLotto = new Lotto(new String[]{"1", "2", "3", "4", "5", "6"});

        //when
        lottoGames.calculatePrizeCount(winningLotto, new LottoNumber(45));
        int totalPrize = lottoGames.calculateTotalPrize();

        //then
        assertThat(totalPrize).isEqualTo(5000);
    }

    @Test
    @DisplayName("로또 수익률 계산")
    public void returnRate() {
        Lotto lotto = new Lotto(testLottoGenerator);
        List<Lotto> lottoList = List.of(lotto);
        LottoGames lottoGames = new LottoGames(lottoList);
        Lotto winningLotto = new Lotto(new String[]{"1", "2", "3", "4", "5", "6"});
        lottoGames.calculatePrizeCount(winningLotto, new LottoNumber(45));
        assertThat(lottoGames.calculateReturn()).isEqualTo(5);
    }

    @Test
    @DisplayName("인풋만큼 로또 게임 생성")
    public void gameMakeTest() {
        LottoPurchase lottoPurchase = new LottoPurchase("14000", "0");
        LottoGames lottoGames = new LottoGames(lottoPurchase, new ArrayList<>());
        assertThat(lottoGames.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("상금별 당첨이 몇개가 있는지 확인")
    public void calculatePrizeCountTest() {
        //given
        Lotto lotto = new Lotto(testLottoGenerator);
        List<Lotto> lottoList = List.of(lotto);
        LottoGames lottoGames = new LottoGames(lottoList);
        Lotto winningLotto = new Lotto(new String[]{"1", "2", "3", "4", "5", "6"});
        HashMap<Rank, Integer> result = new HashMap<>(){{
            put(Rank.FIFTH, 1);
        }};

        //when
        lottoGames.calculatePrizeCount(winningLotto, new LottoNumber(45));

        //then
        assertThat(lottoGames.getLottoResult().entrySet()).isEqualTo(result.entrySet());
    }
}
