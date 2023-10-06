package com.guo.roy.research.game;

import java.awt.*;
import java.util.LinkedList;

import com.google.common.collect.Lists;

public class SnakeModel {

    private LinkedList<Point> snakePoints = Lists.newLinkedList();

    private Point fruitPoint;

    private SnakeDirection direction = SnakeDirection.UP;

    private boolean shrink;

    public Point peekFirst() {
        return snakePoints.peekFirst();
    }

    public Point peekLast() {
        return snakePoints.peekLast();
    }

    public void addFirst(Point newPoint) {
        snakePoints.addFirst(newPoint);
    }

    public Point removeFirst() {
        return snakePoints.removeFirst();
    }

    public Point removeLast() {
        return snakePoints.removeLast();
    }

    public void clear() {
        snakePoints.clear();
    }

    public int length() {
        return snakePoints.size();
    }

    public LinkedList<Point> getSnakePoints() {
        return Lists.newLinkedList(snakePoints);
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public Point getFruitPos() {
        return fruitPoint;
    }

    public boolean isShrink() {
        return shrink;
    }

    public void setShrink(boolean shrink) {
        this.shrink = shrink;
    }

    public boolean isBody(int x, int y) {
        return snakePoints.contains(new Point(x, y));
    }

    /**
     * 是否在角落
     * @param col
     * @param row
     * @param x
     * @param y
     * @return
     */
    public boolean isCorner(int col, int row, int x, int y) {
        return x <=3 || x>= col-3 || y<=3 || y >=  row-3;
    }

    /**
     * compute fruit point, 从上往下，从左往右 for扫描
     * @param index
     */
    public void spawnFruit(int index) {
        int freeFound = -1;
        for(int y = 0; y < GameConfigure.ROW_COUNT; y++) {
            for(int x = 0; x < GameConfigure.COL_COUNT; x++) {
                //不是蛇的身体并且freeFound==index
                if(!isBody(x, y)
                        && !isCorner(GameConfigure.COL_COUNT, GameConfigure.ROW_COUNT, x, y)
                        && ++freeFound == index) {
                    fruitPoint = new Point(x, y);
                    break;
                }
            }
        }
    }
}
