import javax.swing.*;
import java.awt.*;

public class Clicker extends JFrame {
    private int level = 0;
    private int progress = 0;
    private int clickPower = 1;
    private int coins = 0;
    private int upgradeCost = 10;

    private JLabel levelLabel;
    private JProgressBar progressBar;
    private JLabel progressLabel;
    private JButton clickButton;
    private JButton resetButton;
    private JLabel coinsLabel;
    private JButton upgradeButton;

    public Clicker() {
        setTitle("Кликер.png");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null);

        ImageIcon imageIcon = new ImageIcon("ico.png");
        setIconImage(imageIcon.getImage());

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel gamePanel = new JPanel(new GridLayout(5, 1, 10, 10));
        gamePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        levelLabel = new JLabel("Уровень: 0", SwingConstants.CENTER);
        levelLabel.setFont(new Font("Arial", Font.BOLD, 18));

        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);

        progressLabel = new JLabel("Прогресс: 0 / 100", SwingConstants.CENTER);

        clickButton = new JButton("Кликни (+1)");
        resetButton = new JButton("Сбросить всё");

        clickButton.addActionListener(e -> handleClick());
        resetButton.addActionListener(e -> handleReset());

        gamePanel.add(levelLabel);
        gamePanel.add(progressBar);
        gamePanel.add(progressLabel);
        gamePanel.add(clickButton);
        gamePanel.add(resetButton);

        JPanel upgradesPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        upgradesPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        coinsLabel = new JLabel("Монеты: 0", SwingConstants.CENTER);
        coinsLabel.setFont(new Font("Arial", Font.BOLD, 18));

        upgradeButton = new JButton("Улучшить клик (+1) за 10");
        upgradeButton.addActionListener(e -> handleUpgrade());

        upgradesPanel.add(coinsLabel);
        upgradesPanel.add(upgradeButton);

        tabbedPane.addTab("Игра", gamePanel);
        tabbedPane.addTab("Улучшения", upgradesPanel);

        add(tabbedPane);
        updateGameUI();
        setVisible(true);
    }

    private void handleClick() {
        progress += clickPower;
        if (progress >= 100) {
            coins += 10;
            progress = 0;
            level++;
        }
        updateGameUI();
    }

    private void handleReset() {
        level = 0;
        progress = 0;
        clickPower = 1;
        coins = 0;
        upgradeCost = 10;
        updateGameUI();
    }
    private void handleUpgrade() {
        if (coins >= upgradeCost) {
            coins -= upgradeCost;
            clickPower++;
            upgradeCost += 10;
        }
        updateGameUI();
    }

    private void updateGameUI() {
        if(coins >= upgradeCost){
            upgradeButton.setEnabled(true);
        }
        else {
            upgradeButton.setEnabled(false);
        }
        levelLabel.setText("Уровень: " + level);
        progressBar.setValue(progress);
        progressLabel.setText("Прогресс: " + progress + " / 100");
        clickButton.setText("Кликни (+" + clickPower + ")");
        coinsLabel.setText("Монеты: " + coins);
        upgradeButton.setText("Улучшить клик (+1) за " + upgradeCost);
    }
}