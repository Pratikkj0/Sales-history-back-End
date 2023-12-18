package com.sprint.saleshistory.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class TimesPojo {

	private Date timeId;
	private String dayName;
	private int dayInWeek;
	private int dayInMonth;
	private int calendarWeek;
	private int fiscalWeek;
	private Date weekEndingDay;
	private int weekEndingDayId;
	private int calendarMonth;
	private int fiscalMonth;
	private String calendarMonthDesc;
	private int calendarMonthId;
	private String fiscalMonthDesc;
	private int fiscalMonthId;
	private int daysInCalMonth;
	private int daysInFsMonth;
	private Date endOfCalMonth;
	private Date endOfFisMonth;
	private String calendarMonthName;
	private String fiscalMonthName;
	private String calendarQuarterDesc;
	private int calendarQuarterId;
	private String fiscalQuarterDesc;
	private int fiscalQuarterId;
	private int daysInCalQuarter;
	private int daysInFisQuarter;
	private Date endOfCalQuarter;
	private Date endOfFisQuarter;
	private int calendarQuarterInt;
	private int fiscalQuarterInt;
	private int year;

}
