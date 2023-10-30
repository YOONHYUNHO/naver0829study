package controller;

import view.View;

public class Controller {
  View view = new View();

  public void run() {
    view.startGame();
  }
}
