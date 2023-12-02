package HW03ttt;
// Один
// ����� ������ ����� ������
// ����� ������ ������ �
// ��� ������ ������ �
// ��� ������ �������� ��������� ������ ������
// ��� ��� (������ �����������)
// ���������� ����� � ������� ���������� � 0

// 1. ������� ���������� ���������
// 2. ������� �������� � �������
// 3. ����� ��� ���������� ��������� ��������� � ��������� (�������, �����, �����)
// 4. ������� ���������� - ��� ��� ����������. ����� createBoard -> inputCellCoordinates ->
//     -> makePlayerTurn -> startGameLoop -> getRandomEmptyCellCoordinates ->
//     -> makeBotTurn -> checkGameState
// 5. ����� ��������� ���������� ���������� (��. �������), ����� - ��� (board). ���� ��
//    ������ ��������� ������� - ������� ������ ���� � ��� ��. ����� ������ ��� ���������
//    ������ � ������ ��� �����.

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int TABLE_SIZE = 3; // �������� ������� ����� _ - ����� ���������� ���������� ���������

    private static String CELL_STATE_EMPTY = " ";
    private static String CELL_STATE_X = "x";
    private static String CELL_STATE_O = "o";

    private static String GAME_STATE_X_WON = "Player wins!";
    private static String GAME_STATE_O_WON = "Bot wins!";
    private static String GAME_STATE_DRAW = "It's draw! Friendship wins!";
    private static String GAME_STATE_NOT_FINISHED = "The game continues.";

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();


    public static void main(String[] args) {

//        String[][] board = createBoard();
//        board[0][0] = CELL_STATE_X;
//        inputCellCoordinates(board);

        System.out.println("Do you want to play TicTacToe? (y/n) ");
        String s1 = scanner.nextLine();

        while (!s1.equals("n"))
        {
            startGameRound();
            System.out.println("Do you want to play TicTacToe another time? (y/n) ");
            s1 = scanner.nextLine();
        }
    }

    public static void startGameRound() {
        System.out.println("Let's start the game!");
        printBoard(createBoard());

        String[][] board = createBoard(); // ������� ����, �������� ��� � board
        startGameloop(board);
        // startGameLoop

    }

    public static String[][] createBoard(){ // ���������
        String[][] board = new String[TABLE_SIZE][TABLE_SIZE];

        for (int row = 0; row < TABLE_SIZE; row++) { // row and col not i and j for clear. No magic numbers
            for (int col = 0; col < TABLE_SIZE; col++) {
                board[row][col] = CELL_STATE_EMPTY;
            }
        }
        return board;
    }

    public static void startGameloop(String[][] board) {
        boolean playerTurn = true;

        do {
            if (playerTurn) {
                makePlayerTurn(board);
                printBoard(board);
            } else {
                makeBotTurn(board);
                printBoard(board);
            }

            playerTurn = !playerTurn;

            String gameState = checkGameState(board);


            if (!Objects.equals(gameState, GAME_STATE_NOT_FINISHED)) {
                System.out.println(gameState);
                return;
            }

        } while (true);


        // while (gameNotOver)
        // playerTurn (������ �� ������, �� ������� �� ������� ���� � ��)
        // botTurn
        // checkGameState (�_WIN, O_WIN, DRAW, GAME_NOT_OVER_
    }

    public static void makePlayerTurn(String[][] board) {
        int[] coordinates = inputCellCoordinates(board);
        board[coordinates[0]][coordinates[1]] = CELL_STATE_X;
        System.out.println("Player made his move!");
    }

    public static int[] inputCellCoordinates(String[][] board){ // ����� �������, ������� ����� ��������� 2 ���������� ����� ������
        System.out.println("Enter coordinates from 0 to 2 separated by a space: ");

        // ��������� - �� ��������� �� ������� ������� � ������������ ����

        do {
            String[] input = scanner.nextLine().split(" ");

            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);

            if ((row < 0) || (row >= TABLE_SIZE) || (col < 0) || (col >= TABLE_SIZE)){
                System.out.println("There is no cell with such coordinates!\n" +
                        "Please, enter coordinates of rows and columns from " +
                        "0 to 2 separated by a space!");
            } else if (board[row][col] != CELL_STATE_EMPTY) {
                System.out.println("This cell is already occupied!");
            } else {
                return new int[]{row, col};
            }
        } while (true);

    }

    public static void makeBotTurn(String[][] board){
        System.out.println("Bot made his move!");
        int[] coordinates = getRandomEmptyCellCoordinates(board);
        board[coordinates[0]][coordinates[1]] = CELL_STATE_O;
    }

    public static int[] getRandomEmptyCellCoordinates(String[][] board) {
        do {
            int row = random.nextInt(TABLE_SIZE);
            int col = random.nextInt(TABLE_SIZE);

            if (Objects.equals(board[row][col], CELL_STATE_EMPTY)) {
                return new int[]{row, col};
            }
        } while (true);
    }

    public static String checkGameState(String[][] board) { // �������� ��� �������
        ArrayList<Integer> sums = new ArrayList<>();

        // iterate rows
        for (int row = 0; row < TABLE_SIZE; row++) {
            int rowSum = 0;
            for (int col = 0; col < TABLE_SIZE; col++) {
                rowSum += calculateNumValue(board[row][col]);
            }
            sums.add(rowSum);
        }

        // iterate columns
        for (int col = 0; col < TABLE_SIZE; col++) {
            int colSum = 0;
            for (int row = 0; row < TABLE_SIZE; row++) {
                colSum += calculateNumValue(board[row][col]);
            }
            sums.add(colSum);
        }

        // iterate diagonal 0 0 - 2 2
        int leftDiagonalSum = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            leftDiagonalSum += calculateNumValue(board[i][i]);
        }
        sums.add(leftDiagonalSum);

        // iterate diagonal 2 0 - 0 2
        int rightDiagonalSum = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            rightDiagonalSum += calculateNumValue(board[i][TABLE_SIZE - 1 - i]);
        }
        sums.add(rightDiagonalSum);

        if (sums.contains(3)) {
            return GAME_STATE_X_WON;
        } else if (sums.contains(-3)) {
            return GAME_STATE_O_WON;
        } else if (areAllCellsTaken(board)) {
            return GAME_STATE_DRAW;
        } else {
            return GAME_STATE_NOT_FINISHED;
        }

/*       ���� ���� - ��������� ���. ������ ���������:
         x == 1, o == (-1), empty == 0
         count sums for rows, columns, diagonals

         if sum.countains(3) -> x won
         if sum.contains(-3) -> y won
         if allCellsTaken() -> draw
         else -> game not over*/
    }

    private static int calculateNumValue(String cellState) {
        if (Objects.equals(cellState, CELL_STATE_X)) {
            return 1;
        } else if (Objects.equals(cellState, CELL_STATE_O)) {
            return -1;
        } else {
            return 0;
        }
    }

    public static boolean areAllCellsTaken(String[][] board) {
        for (int row = 0; row < TABLE_SIZE; row++) {
            for (int col = 0; col < TABLE_SIZE; col++) {
                if (Objects.equals(board[row][col], CELL_STATE_EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printBoard (String[][] board) {
        System.out.println("~~ ~~~ ~~");
        for (int row = 0; row < TABLE_SIZE; row++) {
            String line = "| ";
            for (int col = 0; col < TABLE_SIZE; col++){
                line += board[row][col] + " ";
            }
            line += "|";

            System.out.println(line);
        }
        System.out.println("~~ ~~~ ~~");
    }
}
