package a111rosario.comunaalvear;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Formulario extends AppCompatActivity {


    EditText edt_idmedidor;
    EditText edt_direccion;
    EditText edt_consumo;

    Button btn_leercodigo;
    Button btn_enviar;

   Spinner spn_novedades;
    String novedad[]={"Opcion 1","Opcion 2","Opcion 3","Opcion 4",};

    Bundle Codigodevuelto;//el Bundle sirve para poder mover información de un activity a otro

    private final int REQUEST_ACCES_FINE=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        //solicitar permisos para celulares mas nuevo

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){//si los permisos no están dados, los pide
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},REQUEST_ACCES_FINE);
        }


        //instanciando elementos
        edt_idmedidor=findViewById(R.id.edt_idmedidor);
        edt_direccion=findViewById(R.id.edt_direccion);
        edt_consumo=findViewById(R.id.edt_consumo);

        btn_leercodigo=findViewById(R.id.btn_leercodigo);
        btn_enviar=findViewById(R.id.btn_enviar);


        //en este caso al Spinner hay que agregarle el array String que cree en values/arreglonovedades
        spn_novedades=findViewById(R.id.spn_novedades);
        ArrayAdapter<String> adapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,novedad);
        spn_novedades.setAdapter(adapter);
        Codigodevuelto=this.getIntent().getExtras();
        if(Codigodevuelto!=null){
            String codigoDebarra=Codigodevuelto.getString("codigo");
            edt_idmedidor.setText(codigoDebarra);

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) { //esto nos muestra el cartel si se dieron o no los permisos
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==REQUEST_ACCES_FINE){
            if(grantResults.length>0&& grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"Permisos de cámara concedidos",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Permisos de cámara denegados",Toast.LENGTH_SHORT).show();
            }
        }


    }

    public void obtenercodigo(View v){


        Intent intent=new Intent(this,LeerCodigodeBarras.class);
        startActivity(intent);


    }
    public void set_Codigo(String codigo){
        edt_idmedidor.setText(codigo);
    }
}
