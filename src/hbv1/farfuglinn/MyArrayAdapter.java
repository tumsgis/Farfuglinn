/*
 * Tumi Snær Gíslason
 * 25.10.2014
 * Custom array adapter for inserting an ArrayList<Flight> to ListView
 */
package hbv1.farfuglinn;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import hbv1.farfuglinn.R;

public class MyArrayAdapter extends ArrayAdapter<Flight> {

	public MyArrayAdapter (Context context, ArrayList<Flight> flights) {
		super (context, 0, flights);
	}

	@Override
	public View getView (int pos, View convertView, ViewGroup parent) {

		Flight flight = getItem(pos);

		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
		}

		TextView to = (TextView)convertView.findViewById(R.id.to);
		TextView realArrival = (TextView)convertView.findViewById(R.id.realArrival);
		TextView airline = (TextView)convertView.findViewById(R.id.airline);

		to.setText(flight.to);
		realArrival.setText(flight.realArrival);
		airline.setText(flight.airline);

		return convertView;

	}

}
