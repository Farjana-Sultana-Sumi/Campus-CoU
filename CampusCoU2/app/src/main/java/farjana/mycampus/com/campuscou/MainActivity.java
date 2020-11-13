package farjana.mycampus.com.campuscou;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnreg, _btnlogin;
    EditText _txtfname, _txtpass, _txtemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openHelper=new DatabaseHelper(this);
        _btnreg=(Button)findViewById(R.id.btnreg);
        _txtfname=(EditText)findViewById(R.id.txt);
        _txtpass=(EditText)findViewById(R.id.txtpass);
        _txtemail=(EditText)findViewById(R.id.txtemail);
        _btnlogin=(Button)findViewById(R.id.btnlogin);
        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                String fname = _txtfname.getText().toString();
                String pass = _txtpass.getText().toString();
                String email = _txtemail.getText().toString();
                insertdata(fname, pass, email);
                Toast.makeText(getApplicationContext(), "register successfully", Toast.LENGTH_LONG).show();


            }
            });
        _btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,login.class);
                startActivity(intent);
            }
        });



    }
    public void insertdata(String fname,String pass,String email){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_2, fname);
        contentValues.put(DatabaseHelper.COL_3, pass);
        contentValues.put(DatabaseHelper.COL_4, email);
        long id= db.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
    }

}
