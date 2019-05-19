package com.example.megaconvertor.utils;

import com.example.megaconvertor.model.MeasuresUnitConstant;

import java.math.BigDecimal;

public class PhysicUnitConvertor {

    public Double convert(String from, String to, Double inputValue) {
        if (from.equalsIgnoreCase(to)) {
            return inputValue;
        }
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
        return 0.0;
    }
}
