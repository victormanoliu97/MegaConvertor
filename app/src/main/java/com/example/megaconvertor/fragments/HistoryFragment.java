package com.example.megaconvertor.fragments;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.megaconvertor.R;
import com.example.megaconvertor.database.AppDatabase;
import com.example.megaconvertor.utils.CurrencyConverter;


public class HistoryFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final AppDatabase appDatabase = Room.databaseBuilder(getContext(), AppDatabase.class, "my-db").allowMainThreadQueries().build();

        View v = inflater.inflate(R.layout.fragment_history, container, false);
        EditText physicHistoryTextView = v.findViewById(R.id.history_id);
        EditText currencyExchangeTextView = v.findViewById(R.id.exchange_hist_id);

        physicHistoryTextView.setEnabled(false);
        currencyExchangeTextView.setEnabled(false);

        physicHistoryTextView.setText(appDatabase.conversionResultsDAO().getMostRecent().toString());
        currencyExchangeTextView.setText(appDatabase.exchangeRatesDAO().getMostRecent().toString());


        return v;
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
