package com.ubs.opsit.interviews;

import java.util.Arrays;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.constant.ClockConstant;

/**
 * <p>The {@code TimeconverterImpl} class implements the Timeconverter interface and converts the standard time format to Berlin Clock time format</p>
 * @author omthacker
 * 
 */
public class TimeConverterImpl implements TimeConverter{

	private String formattedTime;
	private static final Logger LOG = LoggerFactory.getLogger(TimeConverterImpl.class);

	/**
	 * <p>This method takes the current time as argument and process it for conversion into Berlin clock time format</p>
	 * @param time
	 * @return Berlin clock time representation or error message if any
	 */

	@Override
	public String convertTimeToBerlinClockFormat(String aTime) {

		LOG.debug("convertTimeToBerlinClockFormat begins"+aTime);
		
		if(aTime == null || "".equals(aTime)){
			return ClockConstant.TIME_NOT_PROVIDED;
		}

		String[] timesArray = aTime.split(":", 3);

		if(timesArray.length != 3){ 
			return ClockConstant.INVALID_TIME;
		}

		int hours, minutes, seconds = 0;

		try {
			hours = Integer.parseInt(timesArray[0]);
			minutes = Integer.parseInt(timesArray[1]);
			seconds = Integer.parseInt(timesArray[2]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(ClockConstant.NUMERIC_TIME);
		}

		if (hours < 0 || hours > 24){ 
			return "Hours out of bound";
		}
		if (minutes < 0 || minutes > 59){ 
			return "Minutes out of bound";
		}
		if (seconds < 0 || seconds > 59){ 
			return "Seconds out of bound";
		}

		this.formattedTime = processBerlinClockTime(hours, minutes, seconds);

		LOG.debug("convertTimeToBerlinClockFormat ends"+this.formattedTime);
		
		return this.formattedTime;
	}

	/**
	 * <p>This method contains the main logic of creating different rows of Berlin clock</p>
	 * @param hours
	 * @param minutes
	 * @param seconds
	 * @return the final string after joining all the rows
	 */

	private String processBerlinClockTime(int hours, int minutes, int seconds) {
		
		LOG.debug("processBerlinClockTime begins"+hours+" "+minutes+" "+seconds);

		String rowOne = (seconds % 2 == 0) ? "Y" : "O";
		String rowTwo = berlinClockRowString(hours / 5, 4, "R");
		String rowThree = berlinClockRowString(hours % 5, 4, "R");
		String rowFour = berlinClockRowString(minutes / 5, 11, "Y").replaceAll("YYY", "YYR");
		String rowFive = berlinClockRowString(minutes % 5, 4, "Y");

		LOG.debug("processBerlinClockTime ends"+hours+" "+minutes+" "+seconds);
		
		return String.join(ClockConstant.NEW_LINE, Arrays.asList(rowOne, rowTwo, rowThree, rowFour, rowFive));

	}

	/**
	 * <p>This method process rows of Berlin clock. It converts the number hours, minutes and seconds into actual representation accepted by the clock</p> 
	 * @param litLights
	 * @param lightsInRow
	 * @param lampType
	 * @return row value of Berlin clock
	 */

	private String berlinClockRowString(int litLamps, int lampsInRow, String lampType) {

		LOG.debug("berlinClockRowString begins"+litLamps+" "+lampsInRow+" "+lampType);
		
		int unlitLamps = lampsInRow - litLamps;
		String lit = String.join("", Collections.nCopies(litLamps, lampType));
		String unlit = String.join("", Collections.nCopies(unlitLamps, "O"));
		
		LOG.debug("berlinClockRowString ends"+lit+" "+unlit);
		
		return lit + unlit;
	}

}
