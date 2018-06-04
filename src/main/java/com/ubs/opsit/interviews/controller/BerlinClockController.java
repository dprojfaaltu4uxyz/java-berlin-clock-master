package com.ubs.opsit.interviews.controller;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.TimeConverterImpl;
import com.ubs.opsit.interviews.constant.ClockConstant;

public class BerlinClockController {

	public String convertTimeToBerlinClockFormat(String time){
		TimeConverter timeConverter = new TimeConverterImpl();

		if(time == null || "".equals(time)){
			return ClockConstant.TIME_NOT_PROVIDED;
		}
		
		return timeConverter.convertTimeToBerlinClockFormat(time);
	}
}
