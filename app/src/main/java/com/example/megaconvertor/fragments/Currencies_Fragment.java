package com.example.megaconvertor.fragments;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.megaconvertor.R;
import com.example.megaconvertor.database.AppDatabase;
import com.example.megaconvertor.entity.ExchangeRates;
import com.example.megaconvertor.model.MeasuresUnitConstant;
import com.example.megaconvertor.service.MakeCurrencyRequestService;
import com.example.megaconvertor.utils.CurrencyConverter;
import com.google.gson.JsonElement;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;


public class Currencies_Fragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    MeasuresUnitConstant measuresUnitConstant = new MeasuresUnitConstant();
    CurrencyConverter currencyConverterService = new CurrencyConverter();

    List<String> currencyUnitTextList = measuresUnitConstant.returnCurrencyUnits();
    String[] currencyUnitTexts = new String[currencyUnitTextList.size()];

    String selectedFromUnit = "";
    String selectedToUnit = "";

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

        final AppDatabase appDatabase = Room.databaseBuilder(getContext(), AppDatabase.class, "my-db").allowMainThreadQueries().build();

        final Button convertButton = v.findViewById(R.id.convert_currency_button_id);

        final EditText inputEditText = v.findViewById(R.id.input_currency_id);

        final EditText resultEditText = v.findViewById(R.id.result_currency_id);
        resultEditText.setEnabled(false);

        final Spinner currencyFromDropdownSpinner = v.findViewById(R.id.from_currency_spinner);
        final Spinner currencyToDropdownSpinner = v.findViewById(R.id.to_currency_spinner);

        ArrayAdapter<String> currencyAdapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, fromListToArray(currencyUnitTextList, currencyUnitTexts));
        currencyAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        currencyFromDropdownSpinner.setAdapter(currencyAdapter);
        currencyToDropdownSpinner.setAdapter(currencyAdapter);

        currencyFromDropdownSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    selectedFromUnit = null;
                    selectedToUnit = null;
                }
                else {
                    selectedFromUnit = currencyFromDropdownSpinner.getSelectedItem().toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        currencyToDropdownSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedToUnit = currencyToDropdownSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MakeCurrencyRequestService makeCurrencyRequestService = new MakeCurrencyRequestService();
                if(selectedFromUnit == null || selectedToUnit == null) {
                    Toast.makeText(getActivity(), "You need to select some units", Toast.LENGTH_SHORT).show();
                }
                else if(inputEditText.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "You need to enter a value", Toast.LENGTH_SHORT).show();
                }
                else {
                    Double inputed = Double.valueOf(inputEditText.getText().toString());

                    Double conversionRate = makeCurrencyRequestService.returnConvertionRate(selectedFromUnit, selectedToUnit);

                    String result = String.valueOf(inputed * conversionRate);
                    resultEditText.setText(result);

                    //Save currency as history
                    ExchangeRates exchangeRateHistEntity = new ExchangeRates();
                    exchangeRateHistEntity.setBase(selectedFromUnit);
                    exchangeRateHistEntity.setSymbol(selectedToUnit);
                    exchangeRateHistEntity.setValue(conversionRate);

                    appDatabase.exchangeRatesDAO().insertResult(exchangeRateHistEntity);
                }
            }
        });


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
        void onFragmentInteraction(Uri uri);
    }

    public String[] fromListToArray(List<String> list, String[] result) {
        result = new String[list.size()];
        result = list.toArray(result);
        return result;
    }
}
