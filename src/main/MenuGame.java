package main;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuGame extends JMenu {

    Map<JMenuItem, List<String>> itemToPlayerMap = new HashMap<>();

    public MenuGame(String str) {
        super(str);

        JMenuItem menuHumanHuman = new JMenuItem("Human vs Human");
        JMenuItem menuHumanRobot = new JMenuItem("Human vs Robot");
        JMenuItem menuRobotHuman = new JMenuItem("Robot vs Human");
        JMenuItem menuRobotRobot = new JMenuItem("Robot vs Robot");
        JMenuItem menuExit = new JMenuItem("Exit");

        itemToPlayerMap.put(menuHumanHuman, List.of("Human", "Human"));
        itemToPlayerMap.put(menuHumanRobot, List.of("Human", "Robot"));
        itemToPlayerMap.put(menuRobotHuman, List.of("Robot", "Human"));
        itemToPlayerMap.put(menuRobotRobot, List.of("Robot", "Robot"));

        menuHumanHuman.addActionListener(this::clickHandler);
        menuHumanRobot.addActionListener(this::clickHandler);
        menuRobotHuman.addActionListener(this::clickHandler);
        menuRobotRobot.addActionListener(this::clickHandler);
        menuExit.addActionListener(this::clickHandler);

        menuHumanHuman.setMnemonic(KeyEvent.VK_H);
        menuHumanRobot.setMnemonic(KeyEvent.VK_R);
        menuRobotHuman.setMnemonic(KeyEvent.VK_U);
        menuRobotRobot.setMnemonic(KeyEvent.VK_O);
        menuExit.setMnemonic(KeyEvent.VK_X);

        add(menuHumanHuman);
        add(menuHumanRobot);
        add(menuRobotHuman);
        add(menuRobotRobot);
        addSeparator();
        add(menuExit);

    }

    void clickHandler(ActionEvent e) {
        var clickedBtn = (JMenuItem) e.getSource();
        var playerX = "";
        var playerO = "";

        if (!itemToPlayerMap.containsKey(clickedBtn)) {
            // the only menu item that doesn't exist is the Exit
            System.exit(0);
        }

        playerX = itemToPlayerMap.get(clickedBtn).get(0);
        playerO = itemToPlayerMap.get(clickedBtn).get(1);

        Main.controlPanel.btnPlayerX.setText(playerX);
        Main.controlPanel.btnPlayerO.setText(playerO);

        Main.controlPanel.startGame();

    }

}
