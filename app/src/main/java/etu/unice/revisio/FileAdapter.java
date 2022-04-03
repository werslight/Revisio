package etu.unice.revisio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FileAdapter extends BaseAdapter {
    private ListOfFile mListP;
    private Context mContext;
    private LayoutInflater mInflater;

    public FileAdapter(Context context, ListOfFile aListP) {
        mContext = context;
        mListP = aListP;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mListP.size();
    }

    @Override
    public Object getItem(int i) {
        return mListP.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LinearLayout layoutItem;

        if(view == null) {
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.activity_files,
                    viewGroup, false);
        }
        else {
            layoutItem = (LinearLayout) view;
        }

        TextView txtName = layoutItem.findViewById(R.id.name);
        txtName.setText(mListP.get(i).getName());
        txtName.setTag(i);
        txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer position = (Integer)v.getTag();
                sendListener(mListP.get(position), position);
            }
        });

        return layoutItem;
    }

    public interface FileAdapterListener {
        void onClickName(File item, int position);
    }

    private ArrayList<FileAdapterListener> mListListener = new ArrayList<>();

    public void addListener(FileAdapterListener aListener) {
        mListListener.add(aListener);
    }

    private void sendListener(File item, int position) {
        for(int i = mListListener.size()-1; i >= 0; i--) {
            mListListener.get(i).onClickName(item, position);
        }
    }
}
