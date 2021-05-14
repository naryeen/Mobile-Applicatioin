package bt.edu.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Sports> mSportsData;
    private SportsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mSportsData = new ArrayList<>();

        mAdapter = new SportsAdapter(this,mSportsData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();
    }

    private void initializeData() {
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_img);
        String[] sportsList = getResources().getStringArray(R.array.sports_titles);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);

        mSportsData.clear();

        for(int i=0; i<sportsList.length;i++){
            mSportsData.add(new Sports(sportsList[i],sportsInfo[i],sportsImageResources.getResourceId(i,0)));
        }
        mAdapter.notifyDataSetChanged();
        sportsImageResources.recycle();
    }
}