package paperrockscissors.strategy;

import paperrockscissors.enums.Choice;
import paperrockscissors.enums.RoundResult;

public interface Strategy {
    RoundResult getRoundResult(Choice firstChoice, Choice secondChoice);
}
