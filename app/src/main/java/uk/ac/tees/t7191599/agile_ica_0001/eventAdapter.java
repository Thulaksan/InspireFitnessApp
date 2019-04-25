package uk.ac.tees.t7191599.agile_ica_0001;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Powerman984 on 27/02/2019.
 */

public class eventAdapter extends BaseAdapter
{
    Activity context;
    ArrayList<Event> events;
    private static LayoutInflater inflater = null;
    public eventAdapter(Activity context, ArrayList<Event> events) {
        this.context = context;
        this.events = events;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public Event getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View itemView = convertView;
        itemView = (itemView == null) ? inflater.inflate(R.layout.event_list_item,null): itemView;
        TextView textViewName = (TextView) itemView.findViewById(R.id.textView_name);
        TextView textViewdate = (TextView) itemView.findViewById(R.id.textView_date);
        Event selectEvent = events.get(position);
        textViewName.setText(selectEvent.getName());
        return itemView;
    }
}
