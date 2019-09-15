package com.example.android.justjava2;

import android.content.Context;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.justjava2.R;


public class MainActivity extends AppCompatActivity {


    int iloscKaw = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Oblicza cenę zamówenia
     *
     * @return całkowita cena
     */

    private int obliczCene() {
        return iloscKaw * 5; //5 PLN za kawe
    }

    /**
     * Przygotowuje wiadomość pod zamówieniem
     *
     * @param cena     zamówienia
     * @param smietana mówi czy ma być smietana
     * @return wiadomość do wyświetlenia
     */
    private String przygotujZamowienie(int cena, boolean smietana) {

        String czyJest = (smietana) ? "Tak, proszę." : "Nie, dziękuję."; //to cudo to skrócony If Else :)
        String wiadomosc = "Dodać śmietanę? " + czyJest;
        wiadomosc += "\nIlość kaw: " + iloscKaw;
        wiadomosc += "\nRazem: " + NumberFormat.getCurrencyInstance().format(cena) + "\nDziękujemy! :)";
        return wiadomosc;
    }

    public void zlozZamowienie(View view) {

        CheckBox bitaSmietanaCheckbox = findViewById(R.id.toppings);
        boolean maSmietane = bitaSmietanaCheckbox.isChecked();
        // proste sprawdzenie logiem czy działa tak jak chcemy - do usunięcia potem
        //  Log.v("Main activity","Czy ma być śmietana: " + maSmietane);


        /** prosty toast, który informuje przy zamówieniu czy checkbox był checked czy nie

         if (maSmietane) {
         Context context = getApplicationContext();
         CharSequence text = "checked!";
         int duration = Toast.LENGTH_SHORT;
         Toast toast = Toast.makeText(context, text, duration);
         toast.show();
         } else {
         Context context = getApplicationContext();
         CharSequence text = "unchecked!";
         int duration = Toast.LENGTH_SHORT;
         Toast toast = Toast.makeText(context, text, duration);
         toast.show();
         }
         */


        if (iloscKaw > 0) {
            pokazWiadomosc(przygotujZamowienie(obliczCene(), maSmietane));
        } else {
            pokazWiadomosc("Wybierz ilość kaw.");
        }
    }

    private void pokazWiadomosc(String wiadomosc) {
        TextView newOrder = findViewById(R.id.id_zamowienie_tv);
        newOrder.setText(wiadomosc);
    }

    //te ponizej sa dla buttonów + i -
    public void zwieksza(View view) {
        iloscKaw++;
        pokazIlosc(iloscKaw);
    }

    public void zmniejsza(View view) {
        if (iloscKaw > 0) {
            iloscKaw--;
        }
        pokazIlosc(iloscKaw);
    }
    //to pokazuje ilość kaw

    private void pokazIlosc(int liczbaKaw) {
        TextView iloscTextView = findViewById(R.id.id_ilosc_kaw_TV);
        iloscTextView.setText(Integer.toString(liczbaKaw));
    }
/**
 * Integer.toString konwertuje int iloscKaw na String, ktory musi byc w setText
 * Używam tego, żeby nie pisać jak łoś:("" + liczbaKaw)*/

}