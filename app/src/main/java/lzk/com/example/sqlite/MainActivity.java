package lzk.com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,email,mobnum;
    Button write,read,update,remove;
    ScrollView scrlview;
    MyHelper myHelper;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myHelper = new MyHelper(this);
        //myHelper.getWritableDatabase();


        name = findViewById(R.id.ename);
        email = findViewById(R.id.eemail);
        mobnum = findViewById(R.id.emobnum);

        write=findViewById(R.id.write);
        read=findViewById(R.id.read);
        update=findViewById(R.id.update);
        remove=findViewById(R.id.remove);


        info=findViewById(R.id.DBinfo);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().toString().isEmpty()&&
                        email.getText().toString().isEmpty()&&
                        mobnum.getText().toString().isEmpty()
                ){
                    Toast.makeText(MainActivity.this, "Empty info!", Toast.LENGTH_SHORT).show();
                }else{

                SQLiteDatabase db =myHelper.getWritableDatabase();
                ContentValues values = new ContentValues();

                values.put("name",name.getText().toString());
                values.put("email",email.getText().toString());
                values.put("mobnum",mobnum.getText().toString());
                db.insert("t_user",null,values);
                db.close();
                Toast.makeText(MainActivity.this, "Added!", Toast.LENGTH_SHORT).show();

                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db =myHelper.getWritableDatabase();
                Cursor cursor = db.query("t_user",null,null,null,null,null,null,null);

                if (cursor.getCount()==0){
                    Toast.makeText(MainActivity.this, "NO DATA", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "DB GET!", Toast.LENGTH_SHORT).show();
                    cursor.moveToFirst();
                    info.setText("Name: "+cursor.getString(0)+"\nEmail: "+cursor.getString(1)+"\nPhone num: "+cursor.getString(2)+"\n");
                }
                while (cursor.moveToNext()){
                    info.append("\n"+"Name: "+cursor.getString(0)+"\nEmail: "+cursor.getString(1)+"\nPhone num: "+cursor.getString(2)+"\n");

                }
                cursor.close();
                db.close();

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().toString().isEmpty()&&
                        email.getText().toString().isEmpty()&&
                        mobnum.getText().toString().isEmpty()
                ){
                    Toast.makeText(MainActivity.this, "Empty info!", Toast.LENGTH_SHORT).show();
                }else {

                    SQLiteDatabase db = myHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("name", name.getText().toString());
                    db.update("t_user", values, "mobnum=?", new String[]{mobnum.getText().toString()});

                    values.put("email", email.getText().toString());
                    db.update("t_user", values, "mobnum=?", new String[]{mobnum.getText().toString()});

                    db.close();
                    Toast.makeText(MainActivity.this, "Update Complete", Toast.LENGTH_SHORT).show();
                }


            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db =myHelper.getWritableDatabase();
                db.delete("t_user",null,null);
                Toast.makeText(MainActivity.this, "DB All clear!", Toast.LENGTH_SHORT).show();
                db.close();
                info.setText("No Data");
            }
        });

    }
}
