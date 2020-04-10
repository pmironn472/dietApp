package com.example.dietapp;
import android.content.Context;





public class DBSetupInsert {
        /*Variables*/
    private final Context context;


    /*public class*/
    public DBSetupInsert (Context ctx){
        this.context = ctx;
    }

        /*Insert Method*/
    public void setupInsertToFood(String values){

        DBAdapter db = new DBAdapter(context);
        db.open();

        db.insert("food",
                "food_id, food_name, food_manufactor_name, food_serving_size, food_serving_mesurment, food_serving_name_number, food_serving_name_word, food_energy, food_proteins, food_carbohydrates, food_fat, food_energy_calculated, food_proteins_calculated, food_carbohydrates_calculated, food_fat_calculated, food_user_id, food_barcode, food_category_id, food_thumb, food_image_a, food_image_b, food_image_c, food_notes",
                values);
        db.close();





    }


}
