package lzk.com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText name,email,mobnum;
    Button write,read,update,remove;
    ScrollView scrlview;
    SQLiteDatabase mydatabase;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydatabase = openOrCreateDatabase("MyDB",MODE_PRIVATE,null);

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

            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydatabase.delete("MyDB", null, null);
            }
        });

    }
}
