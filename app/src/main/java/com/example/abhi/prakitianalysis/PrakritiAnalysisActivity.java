package com.example.abhi.prakitianalysis;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class PrakritiAnalysisActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    PrakritiAdapter adapter;
    ArrayList<ModelPrakriti> mylist = new ArrayList<>();
    PrakritiDbHelper helper;
    ModelPrakriti modelPrakriti;
    Button btnSave,btnReset;
    int vataCount = 0, pittacount = 0 , kaphacount = 0;
    String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prakriti_analysis);

        btnSave = findViewById(R.id.save);
        btnReset =findViewById(R.id.reset);
        recyclerView = findViewById(R.id.rv_qus);
        helper = new PrakritiDbHelper(this);
        helper.insert();


        if (helper.getAll() != null){
            Cursor cursor = helper.getAll();
            cursor.moveToFirst();
            do {
                String q = cursor.getString(cursor.getColumnIndexOrThrow(PrakritiContract.PrakritiQuestion.COLUMN_PRAKRITI_QUESTION));
                String v = cursor.getString(cursor.getColumnIndexOrThrow(PrakritiContract.PrakritiQuestion.COLUMN_VATA));
                String p = cursor.getString(cursor.getColumnIndexOrThrow(PrakritiContract.PrakritiQuestion.COLUMN_PITTA));
                String k = cursor.getString(cursor.getColumnIndexOrThrow(PrakritiContract.PrakritiQuestion.COLUMN_KAPHA));
//                Toast.makeText(this, q, Toast.LENGTH_SHORT).show();
                modelPrakriti = new ModelPrakriti(q,v,p,k);
                mylist.add(modelPrakriti);
            }while (cursor.moveToNext());
        }
//
        adapter = new PrakritiAdapter(mylist,PrakritiAnalysisActivity.this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int vataCount = 0, pittacount = 0 , kaphacount = 0;
                for (int i = 0; i < mylist.size(); i++) {
                    ModelPrakriti prakritiQues = mylist.get(i);
                    if (prakritiQues.getAnswer() != null) {
                        if (prakritiQues.getAnswer().equals("vata")){
                            vataCount = vataCount + 1;
                            Toast.makeText(PrakritiAnalysisActivity.this, "vataCount: "+vataCount, Toast.LENGTH_SHORT).show();
                        }
                        else if (prakritiQues.getAnswer().equals("pitta")){

                            pittacount = pittacount + 1;
                            //                  Toast.makeText(PrakritiAnalysisActivity.this, ""+pittacount, Toast.LENGTH_SHORT).show();
                        }
                        else if (prakritiQues.getAnswer().equals("kapha")){

                            kaphacount = kaphacount + 1;
                            //                  Toast.makeText(PrakritiAnalysisActivity.this, ""+kaphacount, Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                if ((vataCount + kaphacount + pittacount) == 10) {
                    if((kaphacount >= vataCount) && (kaphacount >=pittacount))
                    {    result = "kapha";
                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();}
                    else if((pittacount >= vataCount)&&(pittacount >=kaphacount)) {
                        result = "pitta";
                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
                    }
                    else if((vataCount >= pittacount) && (vataCount >=kaphacount))
                    {
                        result = "vata";
                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Please give answer of all question", Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(PrakritiAnalysisActivity.this,PrakritiResultActivity.class);
                intent.putExtra("result",result);
                startActivity(intent);

            }
        });

    }
}
