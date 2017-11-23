package io.github.alexlondon07.finalproject.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;

import io.github.alexlondon07.finalproject.R;
import tourguide.tourguide.ChainTourGuide;
import tourguide.tourguide.Overlay;
import tourguide.tourguide.Sequence;
import tourguide.tourguide.ToolTip;

public class TourActivity extends AppCompatActivity {

    private static final long DURATION = 600;
    private ImageButton btn1, btn2, btn3;
    private AlphaAnimation alphaAnimation, exitAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
        loadView();
    }

    private void loadView() {
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);

        initAnimationTour();
        runAnimationTour();
    }

    private void initAnimationTour() {
        alphaAnimation = new AlphaAnimation(0f, 1f);
        alphaAnimation.setDuration(DURATION);
        alphaAnimation.setFillAfter(true);

        exitAnimation = new AlphaAnimation(0f, 1f);
        exitAnimation.setDuration(DURATION);
        exitAnimation.setFillAfter(true);
    }

    private void runAnimationTour(){
        ChainTourGuide chainTourGuideButton1 = ChainTourGuide.init(this)
                .setToolTip(new ToolTip().setTitle("Bienvenido")
                        .setDescription("En la App encontraras un listado igual como se muestra aquí")
                        .setGravity(Gravity.BOTTOM))
                .playLater(btn1);

        ChainTourGuide chainTourGuideButton2 = ChainTourGuide.init(this)
                .setToolTip(new ToolTip().setTitle("Detalle de la pelicula")
                        .setDescription("Al dar click en cada item, puedes observar más información")
                        .setGravity(Gravity.BOTTOM| Gravity.LEFT))
                .playLater(btn2);

        ChainTourGuide chainTourGuideButton3 = ChainTourGuide.init(this)
                .setToolTip(new ToolTip().setTitle("Localización de pelicula")
                        .setDescription("Encontrarás las ubicaciones  de donde será su estreno")
                        .setGravity(Gravity.BOTTOM| Gravity.TOP))
                .playLater(btn3);



        Sequence sequence = new Sequence.SequenceBuilder()
                .add(chainTourGuideButton1,chainTourGuideButton2,chainTourGuideButton3)
                .setDefaultOverlay(new Overlay()
                        .setEnterAnimation(alphaAnimation)
                        .setExitAnimation(exitAnimation)
                ).setDefaultPointer(null)
                .setContinueMethod(Sequence.ContinueMethod.Overlay)
                .build();

        ChainTourGuide.init(this).playInSequence(sequence);

        /* setup 3rd button, when clicked, run cleanUp() */
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TourActivity.this, RecordActivity.class);
                startActivity(intent);
            }
        });


    }
}
