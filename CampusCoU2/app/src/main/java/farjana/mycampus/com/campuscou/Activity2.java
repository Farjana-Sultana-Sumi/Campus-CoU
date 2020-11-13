package farjana.mycampus.com.campuscou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }
}


public class SQLiteDatabaseMain extends Activity
{
    ListView list;
    DatabaseHelper helper;
    SQLiteDatabase db;
    DatabaseAdapter adapter;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.main);

        init();
    }

    public void init()
    {
        helper = new DatabaseHelper(this);

        list = (ListView) findViewById(R.id.listView1);

        db = helper.getWritableDatabase();

        helper.populateGrocery(db);

    }

}