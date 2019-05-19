package com.example.megaconvertor.model;

import java.util.ArrayList;
import java.util.List;

public  class MeasuresUnitConstant {

    public final String NOTHING_SELECTED = ".";

    // Length
    private final List<String> lengthUnits = new ArrayList<>();
    public final static String METER = "M";
    public final static String CM = "CM";
    public static final String FEET = "FT";
    public static final String INCHES = "IN";
    public static final String YARDS = "YD";

    // Temperature
    private final List<String> temperatureUnits = new ArrayList<>();
    private final static String CELSIUS = "CELSIUS";
    private final static String KELVIN = "KELVIN";
    private final static String FAHRENHEIT = "FAHRENHEIT";

    //Pressure
    private final List<String> pressureUnits = new ArrayList<>();
    private final static String PASCAL = "PA";
    private final static String ATM = "ATM";
    private final static String TORR = "TORR";


    public List<String> returnLengthUnits() {
        lengthUnits.add(NOTHING_SELECTED);
        lengthUnits.add(METER);
        lengthUnits.add(CM);
        lengthUnits.add(FEET);
        lengthUnits.add(INCHES);
        lengthUnits.add(YARDS);
        return lengthUnits;
    }

    public List<String> returnTemperatureUnits() {
        temperatureUnits.add(NOTHING_SELECTED);
        temperatureUnits.add(CELSIUS);
        temperatureUnits.add(KELVIN);
        temperatureUnits.add(FAHRENHEIT);
        return temperatureUnits;
    }

    public List<String> returnPressureUnits() {
        pressureUnits.add(NOTHING_SELECTED);
        pressureUnits.add(PASCAL);
        pressureUnits.add(ATM);
        pressureUnits.add(TORR);
        return pressureUnits;
    }
}
