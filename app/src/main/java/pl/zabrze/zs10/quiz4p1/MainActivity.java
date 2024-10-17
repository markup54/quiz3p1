package pl.zabrze.zs10.quiz4p1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pytanie> listaPytan = new ArrayList<>();
    private TextView textView;
    private Button buttonNastepne;
    private Button buttonTak;
    private Button buttonNie;
    private Button buttonPodpowiedz;
    private int licznikPytan = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uwtorzPytania();
        textView = findViewById(R.id.textViewTrescPytania);
        przygotujWidokPytania(0);
        buttonNastepne = findViewById(R.id.button4);
        buttonNastepne.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        licznikPytan++;
                        if(licznikPytan == listaPytan.size()){
                           int punkciki = podliczPunkty();
                           textView.setText("Test zakończono zdobyto "+Integer.toString(punkciki)+" punkty");
                            buttonNastepne.setVisibility(View.INVISIBLE);
                            buttonTak.setVisibility(View.INVISIBLE);
                            buttonNie.setVisibility(View.INVISIBLE);
                        }
                        else {
                            przygotujWidokPytania(licznikPytan);
                        }

                    }
                }
        );

        buttonTak = findViewById(R.id.buttonTak);
        buttonTak.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //zaznaczyć jezeli to dobra odpowiedz
                        zaznaczOdpowiedz(true);
                    }
                }
        );
        buttonNie = findViewById(R.id.buttonNie);
        buttonNie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        zaznaczOdpowiedz(false);
                    }
                }
        );
        buttonPodpowiedz = findViewById(R.id.button3);
        buttonPodpowiedz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this,PodpowiedzActivity.class);
                        intent.putExtra("PODPOWIEDZ",listaPytan.get(licznikPytan).getPodpowiedz());
                        startActivity(intent);
                    }
                }
        );
    }
    private int podliczPunkty(){
        int punkty = 0;
        for (Pytanie pytanie:listaPytan) {
            if(pytanie.isCzyUdzielonoPoprawnejOdpowiedzi()){
                punkty++;
            }
        }
        return punkty;
    }


    private void zaznaczOdpowiedz(boolean odpowiedz){
        Pytanie pytanie = listaPytan.get(licznikPytan);
        if(pytanie.isOdpPoprawna() == odpowiedz){
            listaPytan.get(licznikPytan).setCzyUdzielonoPoprawnejOdpowiedzi();
        }
    }

    private void przygotujWidokPytania(int i){
        Pytanie pytanie = listaPytan.get(i);
        textView.setText(pytanie.getTresc());
    }

    private void uwtorzPytania(){
        listaPytan.add(new Pytanie("Czy U2 jest z Irlandii?",
                "Zespół powstał w Dublinie w 1976, pod nazwą U2 występujący od 1978. W jego skład wchodzą: Bono, The Edge, Adam Clayton i Larry Mullen Jr. Larry Mullen Jr. Do połowy lat 80." ,
                true));
        listaPytan.add(new Pytanie("Czy Kurt Cobain był perkisistą Nirvany",
                "amerykański piosenkarz i muzyk grunge’owy, najbardziej znany jako wokalista, gitarzysta, kompozytor i autor tekstów założonego w 1987 wraz z Kristem Novoselicem i Aaronem Burckhardem zespołu Nirvana.",
                false
                ));
        listaPytan.add(new Pytanie ("Czy Vonda Shepard występowała w filmie Ally McBeal",
                "Vonda Shepard (ur. 7 lipca 1963 w Nowym Jorku) – piosenkarka popowa, znana głównie ze swoich występów muzycznych w serialu Ally McBeal, gdzie grała piosenkarkę w barze, w którym postacie z serialu zawsze spotykały się po pracy. Gra na pianinie, gitarze i basie.",
                true
        ));
    }

}