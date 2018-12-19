package a111rosario.comunaalvear;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

import static android.support.constraint.Constraints.TAG;

public class LeerCodigodeBarras extends Activity implements ZBarScannerView.ResultHandler {
    private ZBarScannerView mScannerView;

    EditText edt_idmedidor;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZBarScannerView(this);    // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view

        edt_idmedidor=findViewById(R.id.edt_idmedidor);

    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here

        //Log.e(TAG,rawResult.getContents()); // Prints scan results
        //Log.e(TAG, rawResult.getBarcodeFormat().getName()); // Prints the scan format (qrcode, pdf417 etc.)

        String codigo=rawResult.getContents().toString();//creo un string en el cual asigno el número del codigo de barra que lee la funcion


        if(codigo!=null) {//Si el string codigo no está vacio quiere decir que la app pudo leer el codigo de barra entonces vuelva a la activity del formulario


            Intent volver = new Intent(this, Formulario.class);
            volver.putExtra("codigo", codigo);
            startActivity(volver);
        }

        //mScannerView.resumeCameraPreview(this); esto es para que se vaya actualizando la cámara para seguir tomando codigos, en nuestro caso no nos sirve porque sólo necesitamos que lea de a un código a la vez
    }
}