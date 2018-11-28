package csc207project.gamecentre.MemoryMatchingPics;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import csc207project.gamecentre.SlidingTiles.StartingActivity;

public class MovementController {

    private BoardManager boardManager;

    private Context mContext;

    MovementController(){
    }

    void setBoardManager(BoardManager boardManager){this.boardManager = boardManager;}

    void processTapMovement(Context context, int position, boolean display){
        this.mContext = context;

        boardManager.touchMove(position);
        if (boardManager.cardAllMatched()) {
            Toast.makeText(context, "YOU WIN", Toast.LENGTH_SHORT).show();
            mContext.deleteFile(MatchingStartingActivity.TEMP_SAVE_FILENAME);
//                long duration = boardManager.getDuration();
//                String min = getUsedTime(duration)[0];
//                String sec = getUsedTime(duration)[1];
//                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
//                builder.setTitle("You Win!")
//                        .setMessage("You have used " + minutes + "minutes " + seconds + "seconds.")
//                        .setPositiveButton("Take me to ScoreBoard",
//                                new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        Intent toScoreBoardIntent =
//                                                new Intent(mContext, ScoreBoardActivity.class);//TODO: create scoreBoard.
//                                        toScoreBoardIntent.putExtra("score", duration);
//                                        mContext.startActivity(toScoreBoardIntent);
//                                    }
//                                })
//                        .show();
        }
    }

    /**
     * Get the time in milliseconds to readable format.
     *
     * @param duration time player used in the game
     * @return readable format of time
     */
    private String[] getUsedTime(long duration) {
        long minute = (duration / 1000) / 60;
        long second = (duration / 1000) % 60;
        return new String[]{String.valueOf(minute), String.valueOf(second)};
    }
}
