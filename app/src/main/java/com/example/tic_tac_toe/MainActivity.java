package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // player define... 0-->X ; 1-->O;
    boolean gameactive=true;
    int activeplayer=0;
    int[] gamestate={2,2,2,2,2,2,2,2,2};

    int[][] winningpos={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playertap(View view){

        ImageView img= (ImageView)view;
        int tappedimage = Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            gamereset(view);
        }
        if(gamestate[tappedimage]==2){
            gamestate[tappedimage]=activeplayer;
            img.setTranslationY(-1000f);

            if(activeplayer==0){
                img.setImageResource(R.drawable.x);
                activeplayer=1;
                TextView status =findViewById(R.id.statusbar);
                status.setText("0's turn-> tap to play");

            }
            else{
                img.setImageResource(R.drawable.o);
                activeplayer=0;
                TextView status =findViewById(R.id.statusbar);
                status.setText("X's turn-> tap to play");

            }


            img.animate().translationYBy(1000f).setDuration(300);
        }

        // when some one has won

        for(int[] i:winningpos){
            if(gamestate[i[0]]==gamestate[i[1]] && gamestate[i[1]]==gamestate[i[2]] && gamestate[i[0]]!=2){
                String winstr;
                gameactive=false;
                if(gamestate[i[0]]==0){
                    winstr="X has won";
                }
                else{
                    winstr="0 has won";
                }

                TextView status =findViewById(R.id.statusbar);
                status.setText(winstr);

            }

        }

    }
    public void gamereset(View view){
        gameactive=true;
        activeplayer=0;
        int[] gamestate={2,2,2,2,2,2,2,2,2};
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);

    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}