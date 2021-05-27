package edu.bt.todo_22ii;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class BookLoader extends AsyncTaskLoader {
    private String nQueryString;

    BookLoader(Context context, String queryString) {
        super(context);
        nQueryString = queryString;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        forceLoad();
    }

    @Nullable
    @Override
    public Object loadInBackground() {
        return NetworkUtils.getBookInfo(nQueryString);
    }
}
