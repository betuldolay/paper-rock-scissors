package paperrockscissors.strategy;

import paperrockscissors.enums.Choice;
import paperrockscissors.enums.RoundResult;

import java.util.HashMap;
import java.util.Map;

import static paperrockscissors.enums.Choice.P;
import static paperrockscissors.enums.Choice.R;
import static paperrockscissors.enums.Choice.S;

public class PaperRockScissorsStrategy implements Strategy {

    private static final Map<Choice, Choice> BEATS_MAP = new HashMap<>();

    static {
        BEATS_MAP.put(P, R);
        BEATS_MAP.put(R, S);
        BEATS_MAP.put(S, P);
    }

    @Override
    public RoundResult getRoundResult(Choice first, Choice second) {
        return first.equals(second) ? RoundResult.TIE : BEATS_MAP.get(first).equals(second) ? RoundResult.WON : RoundResult.LOST;
    }
}
