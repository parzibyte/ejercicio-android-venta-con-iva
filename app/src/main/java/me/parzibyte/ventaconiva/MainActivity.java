package me.parzibyte.ventaconiva;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener referencia a los elementos
        final EditText editTextPrecio = findViewById(R.id.editText),
                editTextCantidad = findViewById(R.id.editText2);
        Button botonQueCalcula = findViewById(R.id.button);

        // Escuchar el click del botón
        botonQueCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener ambos valores como cadena
                String precioString = editTextPrecio.getText().toString(),
                        cantidadString = editTextCantidad.getText().toString();
                // Si están vacíos no seguimos ejecutando más código
                if (precioString.isEmpty() || cantidadString.isEmpty()) return;

                // Si el código continúa hasta aquí significa que las cosas van bien
                // convertimos cadenas a double
                double precio = Double.parseDouble(precioString),
                        cantidad = Double.parseDouble(cantidadString);
                // Hora de hacer cálculos
                final double IVA = 0.16;
                double totalBruto = precio * cantidad;
                // Calcular por separado el IVA de ese total bruto
                double totalIva = totalBruto * IVA;
                // Finalmente el total neto es la suma de los anteriores
                double totalNeto = totalBruto + totalIva;
                // Ahora creamos un intent y ponemos los 3 datos
                Intent intent = new Intent(MainActivity.this, Actividad2.class);
                intent.putExtra("totalBruto", totalBruto);
                intent.putExtra("totalIva", totalIva);
                intent.putExtra("totalNeto", totalNeto);

                // Hacemos el cambio y nos vemos en Actividad2
                startActivity(intent);
            }
        });
    }
}
