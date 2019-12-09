package emreusta.com.sensorservis;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class SensorServisim extends Service implements SensorEventListener {

    private SensorManager sensorManager;
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        Toast.makeText(this,"Servis Başladı",Toast.LENGTH_SHORT).show();
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);

        super.onCreate();
    }

    @Override
    public void onDestroy() {

        Toast.makeText(this,"Servis Durdu",Toast.LENGTH_SHORT).show();
        sensorManager.unregisterListener(this);
        super.onDestroy();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            float[]degerler= event.values;
            float z = degerler[2];
            float x = degerler[0];
            float y = degerler[1];

            if(z>-8.5){
                Log.e("Sensor Durum","x:" + x +" y:"+y+ "z:"+z+ "Telefon Dikey Konumda");
            }else{
                Log.e("Sensor Durum","x:" + x +" y:"+y+ "z:"+z+"Telefon Yüzüstü Duruyor");
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
