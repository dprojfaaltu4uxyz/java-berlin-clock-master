package com.ubs.opsit.interviews.tdd;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.TimeConverterImpl;

public class TimeConverterTest{

	private TimeConverter timeConverter = new TimeConverterImpl();

	@Test
	public void testMidnightClock() {
		String time = timeConverter.convertTimeToBerlinClockFormat("00:00:00");
		String expected = "Y\n"
				+ "OOOO\n"
				+ "OOOO\n"
				+ "OOOOOOOOOOO\n"
				+ "OOOO";
		assertEquals(expected, time);
	}

	@Test
	public void testMaximumValue() {
		String time = timeConverter.convertTimeToBerlinClockFormat("24:00:00");
		String expected = "Y\n"
				+ "RRRR\n"
				+ "RRRR\n"
				+ "OOOOOOOOOOO\n"
				+ "OOOO";
		assertEquals(expected, time);
	}
	
	@Test
	public void testInvalidTime() {
		String time = timeConverter.convertTimeToBerlinClockFormat("asdasdasd");
		String expected = "Invalid time";
		assertEquals(expected, time);
	}

	@Test
	public void testHoursOutOfBound() {
		String time = timeConverter.convertTimeToBerlinClockFormat("25:00:00");
		String expected = "Hours out of bound";
		assertEquals(expected, time);
	}
	
	@Test
	public void testMinutesOutOfBound() {
		String time = timeConverter.convertTimeToBerlinClockFormat("00:60:00");
		String expected = "Minutes out of bound";
		assertEquals(expected, time);
	}
	
	@Test
	public void testSecondsOutOfBound() {
		String time = timeConverter.convertTimeToBerlinClockFormat("00:00:60");
		String expected = "Seconds out of bound";
		assertEquals(expected, time);
	}
	
	@Test
	public void testAfterNoonTime() {
		String time = timeConverter.convertTimeToBerlinClockFormat("13:17:01");
		String expected = "O\n"
				+ "RROO\n"
				+ "RRRO\n"
				+ "YYROOOOOOOO\n"
				+ "YYOO";
		
		assertEquals(expected, time);
	}
}
