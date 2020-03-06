package lzk.com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
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
        myHelper.getWritableDatabase();

        //mydatabase = openOrCreateDatabase("MyDB",MODE_PRIVATE,null);

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

                }else{

                SQLiteDatabase db =myHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name",name.getText().toString());
                values.put("email",email.getText().toString());
                values.put("mobnum",mobnum.getText().toString());
                long id = db.insert("mydb.db",null,values);
                db.close();
                }





            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db =myHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //values.put("");




            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }
}
