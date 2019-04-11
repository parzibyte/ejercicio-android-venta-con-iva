package me.parzibyte.ventaconiva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);

        // Obtener referencia
        TextView textView1 = findViewById(R.id.textView),
                textView2 = findViewById(R.id.textView2),
                textView3 = findViewById(R.id.textView3);

        // Recuperar valores
        Intent intent = getIntent();
        // El defaultValue es lo que se regresa si no se encuentra valor con la clave especificada
        double totalBruto = intent.getDoubleExtra("totalBruto", 0);
        double totalIva = intent.getDoubleExtra("totalIva", 0);
        double totalNeto = intent.getDoubleExtra("totalNeto", 0);

        // Ahora preparamos unos mensajes para ponerlos en los TextView
        String mensajeTotalBruto = "Bruto: " + totalBruto;
        String mensajeTotalIva = "IVA: " + totalIva;
        String mensajeTotalNeto = "Neto: " + totalNeto;

        // Finalmente le ponemos ese mensaje a cada TextView
        textView1.setText(mensajeTotalBruto);
        textView2.setText(mensajeTotalIva);
        textView3.setText(mensajeTotalNeto);
    }
}
