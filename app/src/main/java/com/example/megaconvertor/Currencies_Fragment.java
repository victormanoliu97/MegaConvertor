package com.example.megaconvertor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;


public class Currencies_Fragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public Currencies_Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_currencies, container, false);

        final Button convertButton = v.findViewById(R.id.convert_currency_button_id);

        final EditText inputEditText = v.findViewById(R.id.input_currency_id);
        final EditText resultEditText = v.findViewById(R.id.result_currency_id);

        final Spinner currencyFromDropdownSpinner = v.findViewById(R.id.from_currency_spinner);
        final Spinner currencyToDropdownSpinner = v.findViewById(R.id.to_currency_spinner);

        return inflater.inflate(R.layout.fragment_currencies, container, false);
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
        void onFragmentInteraction(Uri uri);
    }

    public String[] fromListToArray(List<String> list, String[] result) {
        result = new String[list.size()];
        result = list.toArray(result);
        return result;
    }
}
