package com.example.megaconvertor.utils;

import com.example.megaconvertor.model.MeasuresUnitConstant;

public class PhysicUnitConvertor {

    public Double convert(String from, String to, Double inputValue) {
        if (from.equalsIgnoreCase(to)) {
            return inputValue;
        }
        //Lengths
        if(from.equalsIgnoreCase(MeasuresUnitConstant.METER) && to.equalsIgnoreCase(MeasuresUnitConstant.CM)) {
            return inputValue * 100;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.METER) && to.equalsIgnoreCase(MeasuresUnitConstant.FEET)) {
            return inputValue * 3.28;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.METER) && to.equalsIgnoreCase(MeasuresUnitConstant.INCHES)) {
            return inputValue * 39.37;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.METER) && to.equalsIgnoreCase(MeasuresUnitConstant.YARDS)) {
            return inputValue * 1.09;
        }

        if(from.equalsIgnoreCase(MeasuresUnitConstant.CM) && to.equalsIgnoreCase(MeasuresUnitConstant.METER)) {
            return inputValue * 0.01;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.CM) && to.equalsIgnoreCase(MeasuresUnitConstant.FEET)) {
            return inputValue * 0.0328;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.CM) && to.equalsIgnoreCase(MeasuresUnitConstant.INCHES)) {
            return inputValue * 0.3937;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.CM) && to.equalsIgnoreCase(MeasuresUnitConstant.YARDS)) {
            return inputValue * 0.0109;
        }

        if(from.equalsIgnoreCase(MeasuresUnitConstant.FEET) && to.equalsIgnoreCase(MeasuresUnitConstant.CM)) {
            return inputValue * 30.48;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.FEET) && to.equalsIgnoreCase(MeasuresUnitConstant.METER)) {
            return inputValue * 0.3048;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.FEET) && to.equalsIgnoreCase(MeasuresUnitConstant.INCHES)) {
            return inputValue * 12;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.FEET) && to.equalsIgnoreCase(MeasuresUnitConstant.YARDS)) {
            return inputValue * 0.3333;
        }

        if(from.equalsIgnoreCase(MeasuresUnitConstant.INCHES) && to.equalsIgnoreCase(MeasuresUnitConstant.CM)) {
            return inputValue * 2.54;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.INCHES) && to.equalsIgnoreCase(MeasuresUnitConstant.METER)) {
            return inputValue * 0.0254;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.INCHES) && to.equalsIgnoreCase(MeasuresUnitConstant.YARDS)) {
            return inputValue * 0.0277777778;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.INCHES) && to.equalsIgnoreCase(MeasuresUnitConstant.FEET)) {
            return inputValue * 0.0833333333;
        }

        if(from.equalsIgnoreCase(MeasuresUnitConstant.YARDS) && to.equalsIgnoreCase(MeasuresUnitConstant.CM)) {
            return inputValue * 91.44;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.YARDS) && to.equalsIgnoreCase(MeasuresUnitConstant.METER)) {
            return inputValue * 0.9144;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.YARDS) && to.equalsIgnoreCase(MeasuresUnitConstant.FEET)) {
            return inputValue * 3;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.YARDS) && to.equalsIgnoreCase(MeasuresUnitConstant.INCHES)) {
            return inputValue * 36;
        }

        //Temperature
        if(from.equalsIgnoreCase(MeasuresUnitConstant.CELSIUS) && to.equalsIgnoreCase(MeasuresUnitConstant.FAHRENHEIT)) {
            return inputValue * 1.8 + 32;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.CELSIUS) && to.equalsIgnoreCase(MeasuresUnitConstant.KELVIN)) {
            return inputValue + 273.15;
        }

        if(from.equalsIgnoreCase(MeasuresUnitConstant.FAHRENHEIT) && to.equalsIgnoreCase(MeasuresUnitConstant.CELSIUS)) {
            return (inputValue - 32) / 1.8;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.FAHRENHEIT) && to.equalsIgnoreCase(MeasuresUnitConstant.KELVIN)) {
            return (inputValue + 459.67) * 5/9;
        }

        if(from.equalsIgnoreCase(MeasuresUnitConstant.KELVIN) && to.equalsIgnoreCase(MeasuresUnitConstant.CELSIUS)) {
            return inputValue - 273.15;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.KELVIN) && to.equalsIgnoreCase(MeasuresUnitConstant.FAHRENHEIT)) {
            return inputValue * 9/5 - 459.67;
        }

        //Pressure
        if(from.equalsIgnoreCase(MeasuresUnitConstant.PASCAL) && to.equalsIgnoreCase(MeasuresUnitConstant.ATM)) {
            return inputValue * 9.86923267;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.PASCAL) && to.equalsIgnoreCase(MeasuresUnitConstant.TORR)) {
            return inputValue * 0.00750061683;
        }

        if(from.equalsIgnoreCase(MeasuresUnitConstant.ATM) && to.equalsIgnoreCase(MeasuresUnitConstant.PASCAL)) {
            return inputValue * 133.32268;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.ATM) && to.equalsIgnoreCase(MeasuresUnitConstant.TORR)) {
            return inputValue * 760;
        }

        if(from.equalsIgnoreCase(MeasuresUnitConstant.TORR) && to.equalsIgnoreCase(MeasuresUnitConstant.ATM)) {
            return inputValue * 0.00131578947;
        }
        if(from.equalsIgnoreCase(MeasuresUnitConstant.TORR) && to.equalsIgnoreCase(MeasuresUnitConstant.PASCAL)) {
            return inputValue * 133.322368;
        }


        return 0.0;
    }
}
