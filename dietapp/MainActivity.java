package com.example.dietapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Stetho */

        Stetho.initializeWithDefaults(this);

        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();

        /* Database */
        DBAdapter db = new DBAdapter(this);
        DBSetupInsert setupInsert = new DBSetupInsert(this);
        db.open();



       // Count raws in food

        int numberRows = db.count("food");


            if(!(numberRows < 1)){
                //Run setup
                /* Create foods for foods table*/

                db.insert("food",
                        "food_id, food_name, food_manufactor_name, food_serving_size, food_serving_mesurment, food_energy_calculated", "NULL , '\n" +
                                "Яйца, цельное, приготовленное, вкрутую', 'Предшествующий', '136.0', 'g','211'");

                db.insert("food",
                        "food_id, food_name, food_manufactor_name, food_serving_size, food_serving_mesurment, food_energy_calculated", "NULL , '\n" +
                                "Стейк', 'Предшествующий', '106.0', 'g','231'");


            }





            setupInsert.setupInsertToFood("NULL, 'Frossen brokkoliblanding', 'Eldorado', '250', 'gram', '0.5', 'pose', '26', '1.9', '4.2', '0.2', '65', '5', '11', '1', NULL, NULL, '12', 'eldorado_frossen_brokkoliblanding_thumb.jpg', 'eldorado_frossen_brokkoliblanding_a.jpg', 'eldorado_frossen_brokkoliblanding_b.jpg', 'eldorado_frossen_brokkoliblanding_c.jpg', NULL");

//         Close database
        db.close();

        Toast.makeText(this, "Database works", Toast.LENGTH_SHORT).show();



    }
}
