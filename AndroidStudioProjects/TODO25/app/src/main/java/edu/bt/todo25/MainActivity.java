package edu.bt.todo25;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static edu.bt.todo25.DataBaseHelper.TABLE_NAME;
import static edu.bt.todo25.DataBaseHelper.VAL_1;
import static edu.bt.todo25.DataBaseHelper.VAL_2;
import static edu.bt.todo25.DataBaseHelper.VAL_3;
import static edu.bt.todo25.DataBaseHelper.VAL_4;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper dataBaseHelper;
    EditText fname, lname, itwMaark, idNo;
    Button btn_addData, btn_viewAll, btn_update, btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        dataBaseHelper = new DataBaseHelper(this);
        itwMaark = findViewById(R.id.itwMaark);
        idNo = findViewById(R.id.idNo);
        btn_addData = findViewById(R.id.btn_addData);
        btn_viewAll = findViewById(R.id.btn_viewAll);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);

        btn_addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = dataBaseHelper.insertData(idNo.getText().toString(),
                fname.getText().toString(),
                lname.getText().toString(),
                itwMaark.getText().toString());
                if (isInserted == true) {
                    Toast.makeText(MainActivity.this, "Data is inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data is not inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res  = dataBaseHelper.getAllData();
                if(res.getCount()==0){
                    showMessage("Error","Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Employee Id: "+res.getString(0)+"\n");
                    buffer.append("First Name: "+res.getString(1)+"\n");
                    buffer.append("Last Name: "+res.getString(2)+"\n");
                    buffer.append("ITW202 Marks: "+res.getString(3)+"\n");
                }
                showMessage("List of employee",buffer.toString());
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = dataBaseHelper.updateData(idNo.getText().toString(),
                        fname.getText().toString(),
                        lname.getText().toString(),itwMaark.getText().toString());
                if(isUpdate==true){
                    Toast.makeText(MainActivity.this, "Data Updated successfully", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(MainActivity.this, "Data is not updatad", Toast.LENGTH_SHORT).show();
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRow = dataBaseHelper.deleteData(idNo.getText().toString());
                if(deletedRow>0)
                    Toast.makeText(MainActivity.this, "Dadta is deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Data is not deleted", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }



}