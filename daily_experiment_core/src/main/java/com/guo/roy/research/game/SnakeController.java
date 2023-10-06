package com.guo.roy.research.game;

import org.squirrelframework.foundation.component.SquirrelProvider;
import org.squirrelframework.foundation.fsm.AnonymousCondition;
import org.squirrelframework.foundation.fsm.DotVisitor;
import org.squirrelframework.foundation.fsm.HistoryType;
import org.squirrelframework.foundation.fsm.TransitionType;
import org.squirrelframework.foundation.fsm.annotation.*;
import org.squirrelframework.foundation.fsm.impl.AbstractUntypedStateMachine;

import java.awt.*;
import java.util.Random;

/**
 * This is an example on how to use state machine to build a game controller. The state machine was defined in declarative manner.
 *
 * @author Henry.He
 *
 */
@States({
        @State(name="NEW"),
        @State(name="MOVE", historyType=HistoryType.DEEP),
        @State(parent="MOVE", name="UP", initialState=true),
        @State(parent="MOVE", name="LEFT"),
        @State(parent="MOVE", name="RIGHT"),
        @State(parent="MOVE", name="DOWN"),
        @State(name="PAUSE"),
        @State(name="GAMEOVER")
})
@Transitions({
        @Transit(from="NEW", to="MOVE", on="PRESS_START", callMethod="onStart"),
        @Transit(from = "GAMEOVER", to = "MOVE", on = "PRESS_START", callMethod = "onStart"),
        @Transit(from = "MOVE", to = "GAMEOVER", on = "MOVE_AHEAD", callMethod = "onEnd"),
        @Transit(from = "UP", to = "UP", on = "MOVE_AHEAD", callMethod = "onMove", type = TransitionType.INTERNAL, when = SnakeController.ContinueRunningCondition.class),
        @Transit(from = "DOWN", to = "DOWN", on = "MOVE_AHEAD", callMethod = "onMove", type = TransitionType.INTERNAL, when = SnakeController.ContinueRunningCondition.class),
        @Transit(from = "LEFT", to = "LEFT", on = "MOVE_AHEAD", callMethod = "onMove", type = TransitionType.INTERNAL, when = SnakeController.ContinueRunningCondition.class),
        @Transit(from = "RIGHT", to = "RIGHT", on = "MOVE_AHEAD", callMethod = "onMove", type = TransitionType.INTERNAL, when = SnakeController.ContinueRunningCondition.class),
        @Transit(from="MOVE", to="PAUSE", on="PRESS_PAUSE", callMethod="onPause"),
        @Transit(from="PAUSE", to="MOVE", on="PRESS_PAUSE", callMethod="onResume"),
        @Transit(from="UP", to="LEFT", on="TURN_LEFT", callMethod="onChangeDirection"),
        @Transit(from="UP", to="RIGHT", on="TURN_RIGHT", callMethod="onChangeDirection"),
        @Transit(from="DOWN", to="LEFT", on="TURN_LEFT", callMethod="onChangeDirection"),
        @Transit(from="DOWN", to="RIGHT", on="TURN_RIGHT", callMethod="onChangeDirection"),
        @Transit(from="LEFT", to="UP", on="TURN_UP", callMethod="onChangeDirection"),
        @Transit(from="LEFT", to="DOWN", on="TURN_DOWN", callMethod="onChangeDirection"),
        @Transit(from="RIGHT", to="UP", on="TURN_UP", callMethod="onChangeDirection"),
        @Transit(from="RIGHT", to="DOWN", on="TURN_DOWN", callMethod="onChangeDirection")
})
@StateMachineParameters(stateType= SnakeController.SnakeState.class, eventType= SnakeController.SnakeEvent.class, contextType=SnakeModel.class)
public class SnakeController extends AbstractUntypedStateMachine {

    public enum SnakeState {
        NEW, UP, LEFT, RIGHT, DOWN, MOVE, PAUSE, GAMEOVER
    }

    public enum SnakeEvent {
        PRESS_START, TURN_UP, TURN_LEFT, TURN_RIGHT, TURN_DOWN, MOVE_AHEAD, PRESS_PAUSE
    }

    public static class ContinueRunningCondition extends AnonymousCondition<SnakeModel> {
        @Override
        public boolean isSatisfied(SnakeModel context) {
            Point nextPoint = computeNextPoint(context.peekFirst(), context.getDirection());
            boolean insideBorder = nextPoint.x >= 0 && nextPoint.x < GameConfigure.COL_COUNT &&
                    nextPoint.y >= 0 && nextPoint.y < GameConfigure.ROW_COUNT;
            boolean bodyNotCollapsed = context.getSnakePoints().contains(nextPoint)==false;
            return insideBorder && bodyNotCollapsed;
        }
    }

    private Random random = new Random();

    protected void onStart(SnakeState from, SnakeState to, SnakeEvent event, SnakeModel snakeModel) {
        snakeModel.clear();
        Point startPoint = new Point(GameConfigure.COL_COUNT / 2, GameConfigure.ROW_COUNT / 2);
        snakeModel.addFirst(startPoint);
        snakeModel.setDirection(snakeModel.getDirection());

        // generate random fruit point
        snakeModel.spawnFruit(getNextFruitIndex(snakeModel));
    }

    private int getNextFruitIndex(SnakeModel snakeModel) {
//        return random.nextInt(GameConfigure.COL_COUNT * GameConfigure.ROW_COUNT - snakeModel.length());
        return GameConfigure.ROW_COUNT * 8 - 55;
    }

    private void shrink (SnakeModel snakeModel) {
        int snakeLength = snakeModel.length();
        if (snakeLength > GameConfigure.MAX_SNAKE_LENGTH) {
            snakeModel.setShrink(true);
            snakeModel.removeLast();
        } else if (snakeModel.isShrink()) {
            snakeModel.removeLast();
        } else if (snakeLength <= GameConfigure.MIN_SNAKE_LENGTH ) {
            snakeModel.setShrink(false);
        } else {}
    }

    protected void onMove(SnakeState from, SnakeState to, SnakeEvent event, SnakeModel snakeModel) {
        Point nextSnakePoint = computeNextPoint(snakeModel.peekFirst(), snakeModel.getDirection());
        if (nextSnakePoint.equals(snakeModel.getFruitPos())) {
            //运动中下一个蛇头点吃到食物
            snakeModel.addFirst(nextSnakePoint);
            snakeModel.spawnFruit(getNextFruitIndex(snakeModel));
        } else if (snakeModel.length() >= GameConfigure.MIN_SNAKE_LENGTH) {
            //没有吃到食物，蛇尾去掉一格蛇头加一格
            snakeModel.removeLast();
            snakeModel.addFirst(nextSnakePoint);
        } else {
            snakeModel.setShrink(false);
            //蛇身初始化时的生成
            snakeModel.addFirst(nextSnakePoint);
        }
//        shrink(snakeModel);
    }

    protected void onPause(SnakeState from, SnakeState to, SnakeEvent event, SnakeModel snakeModel) {

    }

    protected void onResume(SnakeState from, SnakeState to, SnakeEvent event, SnakeModel snakeModel) {

    }

    protected void onChangeDirection(SnakeState from, SnakeState to, SnakeEvent event, SnakeModel snakeModel) {
        snakeModel.setDirection(getSnakeDirection(to));
    }

    public static SnakeDirection getSnakeDirection(SnakeState state) {
        switch (state) {
            case DOWN:
                return SnakeDirection.DOWN;

            case LEFT:
                return SnakeDirection.LEFT;

            case RIGHT:
                return SnakeDirection.RIGHT;
        }
        return SnakeDirection.UP;
    }

    protected void onEnd(SnakeState from, SnakeState to, SnakeEvent event, SnakeModel context) {

    }

    public static Point computeNextPoint(Point snakePos, SnakeDirection direction) {
        Point nextPoint=new Point(snakePos);
        switch (direction) {
            case UP:
                nextPoint.y--;
                break;

            case DOWN:
                nextPoint.y++;
                break;

            case LEFT:
                nextPoint.x--;
                break;

            case RIGHT:
                nextPoint.x++;
                break;
        }
        return nextPoint;
    }

    public void export() {
        // export snake game state machine
        DotVisitor visitor = SquirrelProvider.getInstance().newInstance(DotVisitor.class);
        this.accept(visitor);
        visitor.convertDotFile("SnakeStateMachine");
    }
}
