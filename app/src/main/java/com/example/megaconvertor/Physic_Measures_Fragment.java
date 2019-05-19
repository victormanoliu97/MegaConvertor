package com.example.megaconvertor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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

import com.example.megaconvertor.model.MeasuresUnitConstant;
import com.example.megaconvertor.utils.PhysicUnitConvertor;

import java.util.List;


public class Physic_Measures_Fragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    MeasuresUnitConstant measuresUnitConstant = new MeasuresUnitConstant();
    PhysicUnitConvertor physicUnitConvertor = new PhysicUnitConvertor();

    List<String> lengthUnitTextsList = measuresUnitConstant.returnLengthUnits();
    List<String> temperatureUnitTextsList = measuresUnitConstant.returnTemperatureUnits();
    List<String> pressureUnitTextsList = measuresUnitConstant.returnPressureUnits();

    String[] lengthUnitTexts = new String[lengthUnitTextsList.size()];
    String[] temperatureUnitTexts = new String[temperatureUnitTextsList.size()];
    String[] pressureUnitTexts = new String[pressureUnitTextsList.size()];

    String selectedFromUnit = "";
    String selectedToUnit = "";


    public Physic_Measures_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_physic__measures, container, false);

        final Button convertButton = v.findViewById(R.id.convert_button_id);

        final EditText resultEditText = v.findViewById(R.id.result_id);
        final EditText inputEditText = v.findViewById(R.id.input_id);

        final Spinner lengthFromDropdownSpinner = v.findViewById(R.id.from_length_spinner);
        final Spinner lengthToDropdownSpinner = v.findViewById(R.id.to_length_spinner);

        final Spinner temperatureFromDropdownSpinner = v.findViewById(R.id.from_temperature_spinner);
        final Spinner temperatureToDropdownSpinner = v.findViewById(R.id.to_temperature_spinner);

        final Spinner pressurefromDropdownSpinner = v.findViewById(R.id.from_pressure_spinner);
        final Spinner pressureToDropdownSpinner = v.findViewById(R.id.to_pressure_spinner);

        ArrayAdapter<String> lengthAdapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, fromListToArray(lengthUnitTextsList, lengthUnitTexts));
        lengthAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        ArrayAdapter<String> temperatureAdapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, fromListToArray(temperatureUnitTextsList, temperatureUnitTexts));
        lengthAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        ArrayAdapter<String> pressureAdapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, fromListToArray(pressureUnitTextsList, pressureUnitTexts));
        lengthAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        lengthFromDropdownSpinner.setAdapter(lengthAdapter);
        lengthToDropdownSpinner.setAdapter(lengthAdapter);

        temperatureFromDropdownSpinner.setAdapter(temperatureAdapter);
        temperatureToDropdownSpinner.setAdapter(temperatureAdapter);

        pressurefromDropdownSpinner.setAdapter(pressureAdapter);
        pressureToDropdownSpinner.setAdapter(pressureAdapter);

        resultEditText.setEnabled(false);


        //Length
        lengthFromDropdownSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    selectedFromUnit = null;
                    selectedToUnit = null;
                    lengthToDropdownSpinner.setSelection(0);
                    temperatureFromDropdownSpinner.setEnabled(true);
                    temperatureToDropdownSpinner.setEnabled(true);
                    pressurefromDropdownSpinner.setEnabled(true);
                    pressureToDropdownSpinner.setEnabled(true);
                }
                else {
                    selectedFromUnit = lengthFromDropdownSpinner.getSelectedItem().toString();
                    temperatureFromDropdownSpinner.setEnabled(false);
                    temperatureToDropdownSpinner.setEnabled(false);
                    pressurefromDropdownSpinner.setEnabled(false);
                    pressureToDropdownSpinner.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        lengthToDropdownSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedToUnit = lengthToDropdownSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Pressure
        pressurefromDropdownSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0) {
                    selectedFromUnit = null;
                    selectedToUnit = null;
                    pressureToDropdownSpinner.setSelection(0);
                    temperatureFromDropdownSpinner.setEnabled(true);
                    temperatureToDropdownSpinner.setEnabled(true);
                    lengthFromDropdownSpinner.setEnabled(true);
                    lengthToDropdownSpinner.setEnabled(true);
                }
                else {
                    selectedFromUnit = pressurefromDropdownSpinner.getSelectedItem().toString();
                    temperatureFromDropdownSpinner.setEnabled(false);
                    temperatureToDropdownSpinner.setEnabled(false);
                    lengthFromDropdownSpinner.setEnabled(false);
                    lengthToDropdownSpinner.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        pressureToDropdownSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedToUnit = pressureToDropdownSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //Temperature
        temperatureFromDropdownSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedFromUnit = null;
                selectedToUnit = null;
                temperatureToDropdownSpinner.setSelection(0);
                pressurefromDropdownSpinner.setEnabled(true);
                pressureToDropdownSpinner.setEnabled(true);
                lengthFromDropdownSpinner.setEnabled(true);
                lengthToDropdownSpinner.setEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedFromUnit = temperatureFromDropdownSpinner.getSelectedItem().toString();
                pressurefromDropdownSpinner.setEnabled(false);
                pressureToDropdownSpinner.setEnabled(false);
                lengthFromDropdownSpinner.setEnabled(false);
                lengthToDropdownSpinner.setEnabled(false);
            }
        });

        temperatureToDropdownSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedToUnit = temperatureToDropdownSpinner.getSelectedItem().toString();
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
                    String result = Double.toString(physicUnitConvertor.convert(selectedFromUnit, selectedToUnit, inputed));
                    resultEditText.setText(result);
                }
            }
        });


        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
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

    public String[] fromListToArray(List<String> list, String[] result) {
        result = new String[list.size()];
        result = list.toArray(result);
        return result;
    }
}
