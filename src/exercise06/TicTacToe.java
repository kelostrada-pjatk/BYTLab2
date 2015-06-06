package exercise06;

public class TicTacToe {

    public StringBuffer board;

    public TicTacToe(String s) {
        board = new StringBuffer(s);
    }

    public TicTacToe(String s, int position, char player) {
        board = new StringBuffer(s);
        board.setCharAt(position, player);
    }

    public int suggestMove(char player) {
        for (int i = 0; i < 9; i++) {
            if (board.charAt(i) == '-') {
                TicTacToe game = makeMove(i, player);
                if (game.winner() == player) {
                    return i;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (board.charAt(i) == '-') {
                return i;
            }
        }

        return -1;
    }

    public TicTacToe makeMove(int i, char player) {
        return new TicTacToe(board.toString(), i, player);
    }

    public char winner() {
        // check for horizontal winner
        for (int i = 0; i < 3; i++) {
            char winner = horizontalWinner(i);
            if (winner != '-') {
                return winner;
            }
        }

        // check for vertical winner
        for (int i = 0; i < 3; ++i) {
            char winner = verticalWinner(i);
            if (winner != '-') {
                return winner;
            }
        }

        // check for diagonal winner
        for (int i = 0; i < 2; ++i) {
            char winner = diagonalWinner(i);
            if (winner != '-') {
                return winner;
            }
        }

        // no winner yet
        return '-';
    }
    
    char horizontalWinner(int i) {
        i *= 3;
        char piece = board.charAt(i);
        if (piece != '-'
                && board.charAt(i + 1) == piece
                && board.charAt(i + 2) == piece) {
            return piece;
        }
        return '-';
    }
    
    char verticalWinner(int i) {
        char piece = board.charAt(i);
        if (piece != '-'
                && board.charAt(i + 3) == piece
                && board.charAt(i + 6) == piece) {
            return piece;
        }
        return '-';
    }
    
    char diagonalWinner(int i) {
        if (i > 1 || i < 0) return '-';
        if (board.charAt(2*i) != '-' && board.charAt(4) == board.charAt(2*i)
                && board.charAt(8 - 2*i) == board.charAt(2*i)) {
            return board.charAt(2*i);
        }
        return '-';
    }
    
}
