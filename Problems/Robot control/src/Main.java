enum Direction {
	UP(0, 1),
	DOWN(0, -1),
	LEFT(-1, 0),
	RIGHT(1, 0);

	private final int dx;
	private final int dy;

	Direction(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public Direction turnLeft() {
		switch (this) {
			case UP:
				return LEFT;
			case DOWN:
				return RIGHT;
			case LEFT:
				return DOWN;
			case RIGHT:
				return UP;
			default:
				throw new IllegalStateException();
		}
	}

	public Direction turnRight() {
		switch (this) {
			case UP:
				return RIGHT;
			case DOWN:
				return LEFT;
			case LEFT:
				return UP;
			case RIGHT:
				return DOWN;
			default:
				throw new IllegalStateException();
		}
	}

	public int dx() {
		return dx;
	}

	public int dy() {
		return dy;
	}
}

//Don't change code below

class Move {
	public static void moveRobot(Robot robot, int toX, int toY) {
		moveToX(robot, toX);
		moveToY(robot, toY);
	}

	private static void moveToY(Robot robot, int toY) {
		if (toY > robot.getY()) {
			switch (robot.getDirection()) {
				case UP:
					moveByY(robot, toY);
					break;
				case DOWN:
					robot.turnRight();
					robot.turnRight();
					moveByY(robot, toY);
					break;
				case LEFT:
					robot.turnRight();
					moveByY(robot, toY);
					break;
				case RIGHT:
					robot.turnLeft();
					moveByY(robot, toY);
					break;
				default:
					throw new IllegalStateException();
			}
		} else {
			switch (robot.getDirection()) {
				case UP:
					robot.turnRight();
					robot.turnRight();
					moveByY(robot, toY);
					break;
				case DOWN:
					moveByY(robot, toY);
					break;
				case LEFT:
					robot.turnLeft();
					moveByY(robot, toY);
					break;
				case RIGHT:
					robot.turnRight();
					moveByY(robot, toY);
					break;
				default:
					throw new IllegalStateException();
			}
		}
	}

	private static void moveToX(Robot robot, int toX) {
		if (toX > robot.getX()) {
			switch (robot.getDirection()) {
				case UP:
					robot.turnRight();
					moveByX(robot, toX);
					break;
				case DOWN:
					robot.turnLeft();
					moveByX(robot, toX);
					break;
				case LEFT:
					robot.turnLeft();
					robot.turnLeft();
					moveByX(robot, toX);
					break;
				case RIGHT:
					moveByX(robot, toX);
					break;
				default:
					throw new IllegalStateException();
			}
		} else {
			switch (robot.getDirection()) {
				case UP:
					robot.turnLeft();
					moveByX(robot, toX);
					break;
				case DOWN:
					robot.turnRight();
					moveByX(robot, toX);
					break;
				case LEFT:
					moveByX(robot, toX);
					break;
				case RIGHT:
					robot.turnRight();
					robot.turnRight();
					moveByX(robot, toX);
					break;
				default:
					throw new IllegalStateException();
			}
		}
	}

	private static void moveByX(Robot robot, int coordinate) {
		while (robot.getX() != coordinate) {
			robot.stepForward();
		}
	}

	private static void moveByY(Robot robot, int coordinate) {
		while (robot.getY() != coordinate) {
			robot.stepForward();
		}
	}
}

class Robot {
	private int x;
	private int y;
	private Direction direction;

	public Robot(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public void turnLeft() {
		direction = direction.turnLeft();
	}

	public void turnRight() {
		direction = direction.turnRight();
	}

	public void stepForward() {
		x += direction.dx();
		y += direction.dy();
	}

	public Direction getDirection() {
		return direction;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}