package com.sumit.a8080.agriculture;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by amd A10 on 20-Jan-17.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Activity context , ArrayList<Word> words)
    {
        super(context,0,words);
    }
    public View getView(int position , View convertView , ViewGroup parent)
    {
        View listItemView = convertView;
        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.dealer_item_list,parent,false);
        }
        Word currentWord = getItem(position);
        TextView miwokTextView = (TextView)listItemView.findViewById(R.id.phone_number);
        miwokTextView.setText(currentWord.getPhNo());
        TextView defaultTextView = (TextView)listItemView.findViewById(R.id.adddress);
        defaultTextView.setText(currentWord.getAddress());
        TextView aTextView = (TextView)listItemView.findViewById(R.id.company_name);
        aTextView.setText(currentWord.getmName());
        return listItemView;
    }
}
