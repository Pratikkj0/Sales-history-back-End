package com.sprint.saleshistory.entities;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "times")
public class TimesEntity {
	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY) -- WE ARE COMMENTING THIS
	// BECAUSE DATE IS NOT AUTO INCREMENTED
	@Column(name = "time_id")
	private Date timeId;

	@Column(name = "day_name", length = 9, nullable = false)
	private String dayName;

	@Column(name = "day_in_week", nullable = false)
	private int dayInWeek;

	@Column(name = "day_in_month", nullable = false)
	private int dayInMonth;

	@Column(name = "calendar_week", nullable = false)
	private int calendarWeek;

	@Column(name = "fiscal_week", nullable = false)
	private int fiscalWeek;

	@Column(name = "week_ending_day", nullable = false)
	private Date weekEndingDay;

	@Column(name = "week_ending_day_id", nullable = false)
	private int weekEndingDayId;

	@Column(name = "calendar_month", nullable = false)
	private int calendarMonth;

	@Column(name = "fiscal_month", nullable = false)
	private int fiscalMonth;

	@Column(name = "calendar_month_desc", length = 9, nullable = false)
	private String calendarMonthDesc;

	@Column(name = "calendar_month_id", nullable = false)
	private int calendarMonthId;

	@Column(name = "fiscal_month_desc", length = 9, nullable = false)
	private String fiscalMonthDesc;

	@Column(name = "fiscal_month_id", nullable = false)
	private int fiscalMonthId;

	@Column(name = "days_in_cal_month", nullable = false)
	private int daysInCalMonth;

	@Column(name = "days_in_fs_month", nullable = false)
	private int daysInFsMonth;

	@Column(name = "end_of_cal_month", nullable = false)
	private Date endOfCalMonth;

	@Column(name = "end_of_fis_month", nullable = false)
	private Date endOfFisMonth;

	@Column(name = "calendar_month_name", length = 9, nullable = false)
	private String calendarMonthName;

	@Column(name = "fiscal_month_name", length = 9, nullable = false)
	private String fiscalMonthName;

	@Column(name = "calendar_quarter_desc", length = 9, nullable = false)
	private String calendarQuarterDesc;

	@Column(name = "calendar_quarter_id", nullable = false)
	private int calendarQuarterId;

	@Column(name = "fiscal_quarter_desc", length = 9, nullable = false)
	private String fiscalQuarterDesc;

	@Column(name = "fiscal_quarter_id", nullable = false)
	private int fiscalQuarterId;

	@Column(name = "days_in_cal_quarter", nullable = false)
	private int daysInCalQuarter;

	@Column(name = "days_in_fis_quarter", nullable = false)
	private int daysInFisQuarter;

	@Column(name = "end_of_cal_quarter", nullable = false)
	private Date endOfCalQuarter;

	@Column(name = "end_of_fis_quarter", nullable = false)
	private Date endOfFisQuarter;

	@Column(name = "calendar_quarter_INT", nullable = false)
	private int calendarQuarterInt;

	@Column(name = "fiscal_quarter_INT", nullable = false)
	private int fiscalQuarterInt;

	@Column(name = "year", nullable = false)
	private int year;

}