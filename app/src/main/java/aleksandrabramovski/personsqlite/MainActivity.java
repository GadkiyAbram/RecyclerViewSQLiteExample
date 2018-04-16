package aleksandrabramovski.personsqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String LOG_TAG = "mylogs";
    Button searchBtn;
    EditText searchTxt;
    RecyclerView pRecyclerView;
    PersonRAdapter prAdapter;
    public LinearLayout linLayoutrecView;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<PersonDetails> persons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linLayoutrecView = (LinearLayout)findViewById(R.id.linLayoutrecyclerView);
        pRecyclerView = (RecyclerView)findViewById(R.id.pRecyclerView);
        searchTxt = (EditText)findViewById(R.id.searchText);
        searchBtn = (Button)findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(this);

        pRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        pRecyclerView.setLayoutManager(mLayoutManager);
        prAdapter = new PersonRAdapter(this, persons);
    }

    @Override
    public void onClick(View view){
        String searchYear = searchTxt.getText().toString();
        switch (view.getId()){
            case R.id.searchBtn:
                retrieve(searchYear);
                break;
        }
    }

    public void retrieve(String search){
        Cursor cursor;
        DataBaseHelper dbHelper = new DataBaseHelper(this);
        dbHelper.getWritableDatabase();
        persons.clear();
        if (search.isEmpty()){
            cursor = dbHelper.getAllData();
        }else{
            cursor = dbHelper.getDbData(search);
        }
        while(cursor.moveToNext()){
//            int _id = cursor.getInt(0);
            String name = cursor.getString(1);
            String year = cursor.getString(2);
            if (!persons.contains(new PersonDetails(0, name, year))){
                persons.add(new PersonDetails(0, name, year));
            }
        }
        if (!(persons.size() < 1)){
            Log.d(LOG_TAG, "person size: " + persons.size());
            pRecyclerView.setAdapter(prAdapter);
        }else{
            Toast.makeText(this, "Nothing to display", Toast.LENGTH_SHORT).show();
        }
    }
}
