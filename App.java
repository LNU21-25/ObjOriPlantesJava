package controller;

import java.util.Scanner;
import model.SolarSystem;

/**
 * Starts the application using the console.
 */
public class App {

  public static final Scanner scn = new Scanner(System.in, "UTF-8");

  /**
   * Starts the game.

   * @param args Not used.
   * @throws Exception if bad input
   */
  public static void main(String[] args) throws Exception {
    new SolarSystem();
    
  }
}