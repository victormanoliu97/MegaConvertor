package com.example.megaconvertor.fragments;

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
import com.example.megaconvertor.model.MeasuresUnitConstant;
import com.example.megaconvertor.utils.CurrencyConverterService;
import com.google.gson.JsonElement;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;


public class Currencies_Fragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    MeasuresUnitConstant measuresUnitConstant = new MeasuresUnitConstant();
    CurrencyConverterService currencyConverterService = new CurrencyConverterService();

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
                if(selectedFromUnit == null || selectedToUnit == null) {
                    Toast.makeText(getActivity(), "You need to select some units", Toast.LENGTH_SHORT).show();
                }
                else if(inputEditText.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "You need to enter a value", Toast.LENGTH_SHORT).show();
                }
                else {
                    Double inputed = Double.valueOf(inputEditText.getText().toString());
                    int SDK_INT = android.os.Build.VERSION.SDK_INT;
                    if(SDK_INT > 8) {

                        // Allow all requests
                        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                                .permitAll().build();
                        StrictMode.setThreadPolicy(policy);

                        String result = "";
                        Double conversionRate = (double) 0;
                        try {
                            JsonElement conversionElement = currencyConverterService.getLatestCurrencyRates(selectedFromUnit, selectedToUnit).get("rates");
                            conversionRate = Double.valueOf(conversionElement.getAsJsonObject().get(selectedToUnit).toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        result = String.valueOf(inputed * conversionRate);
                        resultEditText.setText(result);
                    }
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
