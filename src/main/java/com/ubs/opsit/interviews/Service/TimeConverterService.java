/**
 * 
 */
package com.ubs.opsit.interviews.Service;

import java.util.ArrayList;
import java.util.List;

import com.ubs.opsit.interviews.TimeConverter;

/**
 * @author Sushil
 *
 */
public class TimeConverterService implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		List<Integer> parts = new ArrayList<Integer>();
		for (String part : aTime.split(":")) {
			parts.add(Integer.parseInt(part));
		}
		return getSeconds(parts.get(2)) + System.lineSeparator() + getTopHours(parts.get(0)) + System.lineSeparator()
				+ getBottomHours(parts.get(0)) + System.lineSeparator() + getTopMinutes(parts.get(1))
				+ System.lineSeparator() + getBottomMinutes(parts.get(1));
	}
	
	@Override
	public String getSeconds(int number) {
        if (number % 2 == 0) return "Y";
        else return "O";
	}
	
	@Override
	public String getTopHours(int number) {
        return getOnOff(4, getTopNumberOfOnSigns(number));
    }
	
	private int getTopNumberOfOnSigns(int number) {
        return (number - (number % 5)) / 5;
	}
	
	private String getOnOff(int lamps, int onSigns, String onSign) {
        String out = "";
        // String multiplication would be useful
        for (int i = 0; i < onSigns; i++) {
            out += onSign;
        }
        for (int i = 0; i < (lamps - onSigns); i++) {
            out += "O";
        }
        return out;
	}
	
	// Default value for onSign would be useful
    private String getOnOff(int lamps, int onSigns) {
        return getOnOff(lamps, onSigns, "R");
    }
	
    @Override
    public String getBottomHours(int number) {
        return getOnOff(4, number % 5);
    }
    
    @Override
    public String getTopMinutes(int number) {
        return getOnOff(11, getTopNumberOfOnSigns(number), "Y").replaceAll("YYY", "YYR");
    }
	
    @Override
    public String getBottomMinutes(int number) {
        return getOnOff(4, number % 5, "Y");
    }

    
}
