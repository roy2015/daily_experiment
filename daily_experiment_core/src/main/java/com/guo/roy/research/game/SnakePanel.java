package com.guo.roy.research.game;

import java.awt.*;

import javax.swing.*;


public class SnakePanel extends JPanel {

    private static final long serialVersionUID = 1197860599866744836L;
    
    private static final Font FONT = new Font("Tahoma", Font.BOLD, 25);
    
    private SnakeController controller;
    
    private SnakeModel model;

    public SnakePanel(SnakeController controller, SnakeModel model) {
        this.controller = controller;
        this.model = model;
        setPreferredSize(new Dimension(GameConfigure.COL_COUNT * GameConfigure.CELL_SIZE,
                GameConfigure.ROW_COUNT * GameConfigure.CELL_SIZE));
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw snake body
        g.setColor(Color.GREEN);
        for(Point snakePoint : model.getSnakePoints()) {
            g.fillRect(snakePoint.x * GameConfigure.CELL_SIZE,
                    snakePoint.y * GameConfigure.CELL_SIZE,
                    GameConfigure.CELL_SIZE,
                    GameConfigure.CELL_SIZE);
        }

        // draw fruit
        if(model.getFruitPos()!=null) {
            g.setColor(Color.RED);
            g.fillOval(model.getFruitPos().x* GameConfigure.CELL_SIZE + 2,
                    model.getFruitPos().y* GameConfigure.CELL_SIZE + 2,
                    GameConfigure.CELL_SIZE - 4, GameConfigure.CELL_SIZE - 4);
        }

        /*
         * Draw the grid on the board. This makes it easier to see exactly
         * where we in relation to the fruit.
         */
        g.setColor(Color.DARK_GRAY);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        for(int x = 0; x < GameConfigure.COL_COUNT; x++) {
            for(int y = 0; y < GameConfigure.ROW_COUNT; y++) {
                g.drawLine(x * GameConfigure.CELL_SIZE, 0, x * GameConfigure.CELL_SIZE, getHeight());
                g.drawLine(0, y * GameConfigure.CELL_SIZE, getWidth(), y * GameConfigure.CELL_SIZE);
            }
        }

        /*
         * Show a message on the screen based on the current game state.
         */
        if(controller.getCurrentState()== SnakeController.SnakeState.GAMEOVER ||
                controller.getCurrentState()==SnakeController.SnakeState.NEW ||
                controller.getCurrentState()==SnakeController.SnakeState.PAUSE) {
            g.setColor(Color.WHITE);

            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            String largeMessage = null;
            String smallMessage = null;
            if(controller.getCurrentState()==SnakeController.SnakeState.NEW) {
                largeMessage = "开始游戏，小萌萌!";
                smallMessage = "Press Enter to Start";
            } else if(controller.getCurrentState()==SnakeController.SnakeState.GAMEOVER) {
                largeMessage = "Game Over，小金!,得分：" + model.length();
                smallMessage = "Press Enter to Restart";
            } else if(controller.getCurrentState()==SnakeController.SnakeState.PAUSE) {
                largeMessage = "Paused,得分：" + model.length();
                smallMessage = "Press P/SPACE to Resume";
            }

            g.setFont(FONT);
            g.drawString(largeMessage, centerX - g.getFontMetrics().stringWidth(largeMessage) / 2, centerY - 50);
            g.drawString(smallMessage, centerX - g.getFontMetrics().stringWidth(smallMessage) / 2, centerY + 50);
        }
    }
}
