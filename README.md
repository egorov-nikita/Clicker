# Clicker

A simple clicker game in Java with a graphical interface (Swing). This is a learning project: clicks fill a progress bar and raise your level, levels earn coins, and coins can be spent on upgrades.

## Features

- **"Game" tab**: level, progress bar (0–100), a click button and a reset button.
- **"Upgrades" tab**: a coin counter and a button to buy an upgrade that increases click power.
- Level up: when progress reaches 100, it resets to 0, the level goes up by 1, click power goes up by 1, and you earn 10 coins.
- Upgrade: costs 10 coins, and the price grows by 10 after each purchase. Every purchase adds +1 to click power.
- The "Reset" button returns the game to its initial state.

## How it works

The game state is stored in fields of the `Clicker` class: `level`, `progress`, `clickPower`, `coins`, `upgradeCost`. Player actions are handled by `handleClick()`, `handleUpgrade()` and `handleReset()`, and `updateGameUI()` refreshes everything shown on screen. Buttons are connected to these methods with lambda expressions.

## Project structure

```
src/
├── Main.java     // entry point, creates the game window
└── Clicker.java  // window, game logic and UI
```

## Running

1. Install a JDK (any recent version will do).
2. Open the project in IntelliJ IDEA.
3. Run `Main.java`.

## Credits

The base of the project (the game tab and a placeholder for the upgrades tab) comes from a course assignment. I added the coin system, the "Upgrades" tab with purchasing, the growing upgrade price, and resetting of the new values.

## Built with

Java, Swing (`JFrame`, `JTabbedPane`, `JProgressBar`), IntelliJ IDEA.
