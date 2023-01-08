package paperrockscissors;

import paperrockscissors.controller.GameController;

public class GameApplication {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.start();
    }
}
