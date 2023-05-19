package lotto.domain;

import lotto.domain.generator.LottoGenerator;
import lotto.domain.number.LottoNumber;
import lotto.util.Util;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final String LOTTO_SIZE_ERROR = "로또 숫자의 입력값은 6개로 이루어져야 합니다.";
    private final Set<LottoNumber> lottoNumbers = new HashSet<>();

    public Lotto(LottoGenerator lottoGenerator) {
        this.lottoNumbers.addAll(lottoGenerator.generate());
    }

    public Lotto(String[] lottoNumbers) {
        lottoSizeCheck(lottoNumbers);
        Arrays.stream(lottoNumbers).forEach(lottoNumber ->
            this.lottoNumbers.add(new LottoNumber(Util.convertInt(lottoNumber))
        ));
    }

    public int findMatchCount(Lotto winningLotto) {
        return (int) lottoNumbers.stream()
                .filter(winningLotto::contains)
                .count();
    }

    public boolean hasBonusLottoNumber(LottoNumber bonusLottoNumber) {
        return lottoNumbers.contains(bonusLottoNumber);
    }

    private void lottoSizeCheck(String[] lottoNumbers) {
        if (lottoNumbers.length != LOTTO_SIZE) {
            throw new IllegalStateException(LOTTO_SIZE_ERROR);
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashSet)) return false;
        return Objects.equals(this.lottoNumbers, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return lottoNumbers.stream().map(LottoNumber::toString).collect(Collectors.joining(", ", "[", "]"));
    }


}
