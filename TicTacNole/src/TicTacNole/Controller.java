// Name: Christelle Nieves
// Program Name: Tic Tac Nole
// Description: A simple Tic Tac Toe game built with JavaFX.

package TicTacNole;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    public Button resetButton;
    public Button topLeft;
    public Button topMid;
    public Button topRight;
    public Button midLeft;
    public Button midmid;
    public Button midRight;
    public Button bottomLeft;
    public Button bottomMid;
    public Button bottomRight;
    public Label label;

    // This keeps track of the last player to take a turn.
    // 0 is player "O" and 1 is player "X"
    private int last = 0;

    // Return true if a square already has an X or O in it.
    private boolean isActive(Button btn) {
        return !btn.getText().equals("");
    }

    // Return true if there are no more empty spaces on the board.
    private boolean boardFull() {
        return isActive(topLeft) && isActive(topRight) && isActive(topMid)
                && isActive(midLeft) && isActive(midmid) && isActive(midRight)
                && isActive(bottomLeft) && isActive(bottomMid) && isActive(bottomRight);
    }

    // This function places an X or O in a square and then calls the checkWin function.
    public void playerTurn(Button btn) {
        // Check if the square is already active.
        if (isActive(btn)) {
            return;
        }

        // If the last player to take a turn was X, place an O.
        if (last == 1) {
            btn.setText("O");
            last = 0;
        } else {
            // If the last player to take a turn was O, place an X.
            btn.setText("X");
            last = 1;
        }

        // Check for any wins or a full board.
        checkForWin();
    }

    // When a player clicks the top left square.
    public void topLeftClicked() {
        playerTurn(topLeft);
    }

    // When a player clicks the top middle square.
    public void topMidClicked() {
        playerTurn(topMid);
    }

    // When a player clicks the top right square.
    public void topRightClicked() {
        playerTurn(topRight);
    }

    // When a player clicks the middle left square.
    public void midLeftClicked() {
        playerTurn(midLeft);
    }

    // When a player clicks the middle middle square.
    public void midMidClicked() {
        playerTurn(midmid);
    }

    // When a player clicks the middle right square.
    public void midRightClicked() {
        playerTurn(midRight);
    }

    // When a player clicks the bottom left square.
    public void bottomLeftClicked() {
        playerTurn(bottomLeft);
    }

    // When a player clicks the bottom middle square.
    public void bottomMidClicked() {
        playerTurn(bottomMid);
    }

    // When a player clicks the bottom right square.
    public void bottomRightClicked() {
        playerTurn(bottomRight);
    }

    // Check if there is a winner or if the board is full.
    private void checkForWin() {
        // Store the text from each square on the board as strings.
        String topL = topLeft.getText();
        String topM = topMid.getText();
        String topR = topRight.getText();
        String midL = midLeft.getText();
        String midM = midmid.getText();
        String midR = midRight.getText();
        String botL = bottomLeft.getText();
        String botM = bottomMid.getText();
        String botR = bottomRight.getText();

        int winner = -1;

        // Check for all possible win combinations.
        if (topL.equals("O") && topM.equals("O") && topR.equals("O")) {
            winner = 0;
        } else if (topL.equals("O") && midL.equals("O") && botL.equals("O")) {
            winner = 0;
        } else if (topL.equals("O") && midM.equals("O") && botR.equals("O")) {
            winner = 0;
        } else if (topM.equals("O") && midM.equals("O") && botM.equals("O")) {
            winner = 0;
        } else if (topR.equals("O") && midM.equals("O") && botL.equals("O")) {
            winner = 0;
        } else if (midL.equals("O") && midM.equals("O") && midR.equals("O")) {
            winner = 0;
        } else if (botL.equals("O") && botM.equals("O") && botR.equals("O")) {
            winner = 0;
        } else if (topR.equals("O") && midR.equals("O") && botR.equals("O")) {
            winner = 0;
        } else if (topL.equals("X") && topM.equals("X") && topR.equals("X")) {
            winner = 1;
        } else if (topL.equals("X") && midL.equals("X") && botL.equals("X")) {
            winner = 1;
        } else if (topL.equals("X") && midM.equals("X") && botR.equals("X")) {
            winner = 1;
        } else if (topM.equals("X") && midM.equals("X") && botM.equals("X")) {
            winner = 1;
        } else if (topR.equals("X") && midM.equals("X") && botL.equals("X")) {
            winner = 1;
        } else if (midL.equals("X") && midM.equals("X") && midR.equals("X")) {
            winner = 1;
        } else if (botL.equals("X") && botM.equals("X") && botR.equals("X")) {
            winner = 1;
        } else if (topR.equals("X") && midR.equals("X") && botR.equals("X")) {
            winner = 1;
        }

        // If winner != -1 then we have a winner
        if (winner != -1) {
            declareWinner(winner);
        } else if (boardFull()) {
            // If the board is full we have no winner
            declareWinner(winner);
        }
        // If no winner was found just let the players continue the game.
    }

    // Set the label on the screen to display the winner of the game.
    private void declareWinner(int wnr) {
        if (wnr == 0) {
            label.setText("O WINS!");
        } else if (wnr == 1) {
            label.setText("X WINS!");
        } else if (wnr == -1) {
            label.setText("NO WINNER :(");
        }

        // Set the text on the reset button to "Play Again"
        resetButton.setText("Play Again");
    }

    // Clear the board whenever the reset button is pressed.
    // This will also clear the winner label.
    public void resetClicked() {
        // Make sure the reset button says "Reset"
        if (resetButton.getText().equals("Play Again")) {
            resetButton.setText("Reset");
        }

        // Reset all the squares on the board and clear the winner.
        last = 0;
        label.setText("");
        topLeft.setText("");
        topMid.setText("");
        topRight.setText("");
        midLeft.setText("");
        midmid.setText("");
        midRight.setText("");
        bottomLeft.setText("");
        bottomMid.setText("");
        bottomRight.setText("");
    }
}
