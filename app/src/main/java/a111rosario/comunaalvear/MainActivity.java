package a111rosario.comunaalvear;

import android.content.Intent;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText edt_usuario;
    EditText edt_pass;

    Button btn_login;
    //ImageView img_logo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //relacionar los elementos del XML con la lógica en Java

        edt_usuario=findViewById(R.id.edt_usuario);
        edt_pass=findViewById(R.id.edt_pass);
        btn_login=findViewById(R.id.btn_login);
        //img_logo=findViewById(R.id.img_logo);
    }

public void onClick(View v){

    Intent cambiandoAct=new Intent(MainActivity.this,Formulario.class);//una vez creado el intent hay que poner el contexto en el que se está, en este caso Main Activity y al que se quiere ir FotoActivity
    startActivity(cambiandoAct);//empieza el activity al que se quiere ir


}


}
