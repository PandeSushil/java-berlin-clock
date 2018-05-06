/**
 * 
 */
package com.ubs.opsit.interviews;

import org.junit.Test;

import com.ubs.opsit.interviews.Service.TimeConverterService;

import org.junit.Assert;

/**
 * @author Sushil
 *
 */
public class TimeConverterTest {
	
	TimeConverter timeConverter = new TimeConverterService();
	
	// Yellow lamp that blinks on/off every two seconds
    @Test
    public void testYellowLampThatBlinkOnOffEveryTwoSeconds() {
        Assert.assertEquals("Y", timeConverter.getSeconds(0));
        Assert.assertEquals("O", timeConverter.getSeconds(1));
        Assert.assertEquals("Y", timeConverter.getSeconds(2));
        Assert.assertEquals("O", timeConverter.getSeconds(13));
    }
 
    // Top should have 4 lamps
    @Test
    public void testTopHoursShouldHave4Lamps() {
    	Assert.assertEquals(4, timeConverter.getTopHours(5).length());
        Assert.assertEquals(4, timeConverter.getTopHours(7).length());
        Assert.assertEquals(4, timeConverter.getTopHours(9).length());
    }
 
    // Top hours should light a red lamp for every 5 hours
    @Test
    public void testTopHoursShouldLightRedLampForEvery5Hours() {
        Assert.assertEquals("OOOO", timeConverter.getTopHours(0));
        Assert.assertEquals("ROOO", timeConverter.getTopHours(6));
        Assert.assertEquals("ROOO", timeConverter.getTopHours(9));
        Assert.assertEquals("RROO", timeConverter.getTopHours(12));
        Assert.assertEquals("RRRO", timeConverter.getTopHours(19));
        Assert.assertEquals("RRRR", timeConverter.getTopHours(21));
        Assert.assertEquals("RRRR", timeConverter.getTopHours(24));
    }
 
    // Bottom hours should have 4 lamps
    @Test
    public void testBottomHoursShouldHave4Lamps() {
        Assert.assertEquals(4, timeConverter.getBottomHours(5).length());
    }
 
    // Bottom hours should light a red lamp for every hour left from top hours
    @Test
    public void testBottomHoursShouldLightRedLampForEveryHourLeftFromTopHours() {
        Assert.assertEquals("OOOO", timeConverter.getBottomHours(0));
        Assert.assertEquals("ROOO", timeConverter.getBottomHours(1));
        Assert.assertEquals("RRO", timeConverter.getBottomHours(2));
        Assert.assertEquals("RRRO", timeConverter.getBottomHours(3));
        Assert.assertEquals("RRRR", timeConverter.getBottomHours(4));
    }
 
    // Top minutes should have 11 lamps
    @Test
    public void testTopMinutesShouldHave11Lamps() {
    	Assert.assertEquals(11, timeConverter.getTopMinutes(24).length());
    	Assert.assertEquals(11, timeConverter.getTopMinutes(30).length());
        Assert.assertEquals(11, timeConverter.getTopMinutes(31).length());
    }
 
    // Top minutes should have 3rd, 6th and 9th lamps in red to indicate first quarter, half and last quarter
    @Test
    public void testTopMinutesShouldHave3rd6thAnd9thLampsInRedToIndicateFirstQuarterHalfAndLastQuarter() {
        String minutes32 = timeConverter.getTopMinutes(32);
        Assert.assertEquals("R", minutes32.substring(2, 3));
        Assert.assertEquals("R", minutes32.substring(5, 6));
        Assert.assertEquals("O", minutes32.substring(8, 9));
    }
 
    // Top minutes should light a yellow lamp for every 5 minutes unless it's first quarter, half or last quarter
    @Test
    public void testTopMinutesShouldLightYellowLampForEvery5MinutesUnlessItIsFirstQuarterHalfOrLastQuarter() {
        Assert.assertEquals("OOOOOOOOOOO", timeConverter.getTopMinutes(0));
        Assert.assertEquals("YYROOOOOOOO", timeConverter.getTopMinutes(17));
        Assert.assertEquals("YYRYYRYYRYY", timeConverter.getTopMinutes(59));
    }
 
    // Bottom minutes should have 4 lamps
    @Test
    public void testBottomMinutesShouldHave4Lamps() {
        Assert.assertEquals(4, timeConverter.getBottomMinutes(0).length());
    }
 
    // Bottom minutes should light a yellow lamp for every minute left from top minutes
    @Test
    public void testBottomMinutesShouldLightYellowLampForEveryMinuteLeftFromTopMinutes() {
        Assert.assertEquals("OOOO", timeConverter.getBottomMinutes(0));
        Assert.assertEquals("YYOO", timeConverter.getBottomMinutes(17));
        Assert.assertEquals("YYYY", timeConverter.getBottomMinutes(59));
    }
 
    // Berlin Clock end result {
    @Test
    public void testtimeConverterShouldResultInCorrectSecondsHoursAndMinutes() {
        Assert.assertEquals("YOOOOOOOOOOOOOOOOOOOOOOO", timeConverter.convertTime("00:00:00"));
        Assert.assertEquals("ORROORRROYYROOOOOOOOYYOO", timeConverter.convertTime("13:17:01"));
        Assert.assertEquals("ORRRRRRROYYRYYRYYRYYYYYY", timeConverter.convertTime("23:59:59"));
        Assert.assertEquals("YRRRRRRRROOOOOOOOOOOOOOO", timeConverter.convertTime("24:00:00"));
    }

}
