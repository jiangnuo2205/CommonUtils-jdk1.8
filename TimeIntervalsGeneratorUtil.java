package io.renren.modules.salesTimelineDashboard.Util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Title: Get time period tool class
 * Function: Get time period tool class Dimension 1 is the current day dimension. For example, from October 1 to October 7, 2023, get the date of each day
 * 1-Day dimension 3-Month dimension 4-Season dimension 5-Year dimension
 *
 * author: JiangNuo
 * Since: 1.0.0 2024年12月30日13:53:59
 */
@Slf4j
@Component
public class TimeIntervalsGeneratorUtil {

    /**
     * EXAMPLE
     * @param args
     */
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date startDate = dateFormat.parse("2022-08-02");
            Date endDate = dateFormat.parse("2023-08-18");

            List<String> dayIntervals = generateDayIntervals(startDate, endDate);
            List<String> weekIntervals = generateWeekIntervals(startDate, endDate);
            List<String> monthIntervals = generateMonthIntervals(startDate, endDate);
            List<String> quarterIntervals = generateQuarterIntervals(startDate, endDate);
            List<String> yearIntervals = generateYearIntervals(startDate, endDate);

            log.info("Day array: " + dayIntervals);
            log.info("Week array: " + weekIntervals);
            log.info("Month array: " + monthIntervals);
            log.info("Quarter array: " + quarterIntervals);
            log.info("Year array: " + yearIntervals);

            //日数组: [2022-08-02, 2022-08-03, 2022-08-04, 2022-08-05, 2022-08-06, 2022-08-07, 2022-08-08, 2022-08-09, 2022-08-10, 2022-08-11, 2022-08-12, 2022-08-13, 2022-08-14, 2022-08-15, 2022-08-16, 2022-08-17, 2022-08-18, 2022-08-19, 2022-08-20, 2022-08-21, 2022-08-22, 2022-08-23, 2022-08-24, 2022-08-25, 2022-08-26, 2022-08-27, 2022-08-28, 2022-08-29, 2022-08-30, 2022-08-31, 2022-09-01, 2022-09-02, 2022-09-03, 2022-09-04, 2022-09-05, 2022-09-06, 2022-09-07, 2022-09-08, 2022-09-09, 2022-09-10, 2022-09-11, 2022-09-12, 2022-09-13, 2022-09-14, 2022-09-15, 2022-09-16, 2022-09-17, 2022-09-18, 2022-09-19, 2022-09-20, 2022-09-21, 2022-09-22, 2022-09-23, 2022-09-24, 2022-09-25, 2022-09-26, 2022-09-27, 2022-09-28, 2022-09-29, 2022-09-30, 2022-10-01, 2022-10-02, 2022-10-03, 2022-10-04, 2022-10-05, 2022-10-06, 2022-10-07, 2022-10-08, 2022-10-09, 2022-10-10, 2022-10-11, 2022-10-12, 2022-10-13, 2022-10-14, 2022-10-15, 2022-10-16, 2022-10-17, 2022-10-18, 2022-10-19, 2022-10-20, 2022-10-21, 2022-10-22, 2022-10-23, 2022-10-24, 2022-10-25, 2022-10-26, 2022-10-27, 2022-10-28, 2022-10-29, 2022-10-30, 2022-10-31, 2022-11-01, 2022-11-02, 2022-11-03, 2022-11-04, 2022-11-05, 2022-11-06, 2022-11-07, 2022-11-08, 2022-11-09, 2022-11-10, 2022-11-11, 2022-11-12, 2022-11-13, 2022-11-14, 2022-11-15, 2022-11-16, 2022-11-17, 2022-11-18, 2022-11-19, 2022-11-20, 2022-11-21, 2022-11-22, 2022-11-23, 2022-11-24, 2022-11-25, 2022-11-26, 2022-11-27, 2022-11-28, 2022-11-29, 2022-11-30, 2022-12-01, 2022-12-02, 2022-12-03, 2022-12-04, 2022-12-05, 2022-12-06, 2022-12-07, 2022-12-08, 2022-12-09, 2022-12-10, 2022-12-11, 2022-12-12, 2022-12-13, 2022-12-14, 2022-12-15, 2022-12-16, 2022-12-17, 2022-12-18, 2022-12-19, 2022-12-20, 2022-12-21, 2022-12-22, 2022-12-23, 2022-12-24, 2022-12-25, 2022-12-26, 2022-12-27, 2022-12-28, 2022-12-29, 2022-12-30, 2022-12-31, 2023-01-01, 2023-01-02, 2023-01-03, 2023-01-04, 2023-01-05, 2023-01-06, 2023-01-07, 2023-01-08, 2023-01-09, 2023-01-10, 2023-01-11, 2023-01-12, 2023-01-13, 2023-01-14, 2023-01-15, 2023-01-16, 2023-01-17, 2023-01-18, 2023-01-19, 2023-01-20, 2023-01-21, 2023-01-22, 2023-01-23, 2023-01-24, 2023-01-25, 2023-01-26, 2023-01-27, 2023-01-28, 2023-01-29, 2023-01-30, 2023-01-31, 2023-02-01, 2023-02-02, 2023-02-03, 2023-02-04, 2023-02-05, 2023-02-06, 2023-02-07, 2023-02-08, 2023-02-09, 2023-02-10, 2023-02-11, 2023-02-12, 2023-02-13, 2023-02-14, 2023-02-15, 2023-02-16, 2023-02-17, 2023-02-18, 2023-02-19, 2023-02-20, 2023-02-21, 2023-02-22, 2023-02-23, 2023-02-24, 2023-02-25, 2023-02-26, 2023-02-27, 2023-02-28, 2023-03-01, 2023-03-02, 2023-03-03, 2023-03-04, 2023-03-05, 2023-03-06, 2023-03-07, 2023-03-08, 2023-03-09, 2023-03-10, 2023-03-11, 2023-03-12, 2023-03-13, 2023-03-14, 2023-03-15, 2023-03-16, 2023-03-17, 2023-03-18, 2023-03-19, 2023-03-20, 2023-03-21, 2023-03-22, 2023-03-23, 2023-03-24, 2023-03-25, 2023-03-26, 2023-03-27, 2023-03-28, 2023-03-29, 2023-03-30, 2023-03-31, 2023-04-01, 2023-04-02, 2023-04-03, 2023-04-04, 2023-04-05, 2023-04-06, 2023-04-07, 2023-04-08, 2023-04-09, 2023-04-10, 2023-04-11, 2023-04-12, 2023-04-13, 2023-04-14, 2023-04-15, 2023-04-16, 2023-04-17, 2023-04-18, 2023-04-19, 2023-04-20, 2023-04-21, 2023-04-22, 2023-04-23, 2023-04-24, 2023-04-25, 2023-04-26, 2023-04-27, 2023-04-28, 2023-04-29, 2023-04-30, 2023-05-01, 2023-05-02, 2023-05-03, 2023-05-04, 2023-05-05, 2023-05-06, 2023-05-07, 2023-05-08, 2023-05-09, 2023-05-10, 2023-05-11, 2023-05-12, 2023-05-13, 2023-05-14, 2023-05-15, 2023-05-16, 2023-05-17, 2023-05-18, 2023-05-19, 2023-05-20, 2023-05-21, 2023-05-22, 2023-05-23, 2023-05-24, 2023-05-25, 2023-05-26, 2023-05-27, 2023-05-28, 2023-05-29, 2023-05-30, 2023-05-31, 2023-06-01, 2023-06-02, 2023-06-03, 2023-06-04, 2023-06-05, 2023-06-06, 2023-06-07, 2023-06-08, 2023-06-09, 2023-06-10, 2023-06-11, 2023-06-12, 2023-06-13, 2023-06-14, 2023-06-15, 2023-06-16, 2023-06-17, 2023-06-18, 2023-06-19, 2023-06-20, 2023-06-21, 2023-06-22, 2023-06-23, 2023-06-24, 2023-06-25, 2023-06-26, 2023-06-27, 2023-06-28, 2023-06-29, 2023-06-30, 2023-07-01, 2023-07-02, 2023-07-03, 2023-07-04, 2023-07-05, 2023-07-06, 2023-07-07, 2023-07-08, 2023-07-09, 2023-07-10, 2023-07-11, 2023-07-12, 2023-07-13, 2023-07-14, 2023-07-15, 2023-07-16, 2023-07-17, 2023-07-18, 2023-07-19, 2023-07-20, 2023-07-21, 2023-07-22, 2023-07-23, 2023-07-24, 2023-07-25, 2023-07-26, 2023-07-27, 2023-07-28, 2023-07-29, 2023-07-30, 2023-07-31, 2023-08-01, 2023-08-02, 2023-08-03, 2023-08-04, 2023-08-05, 2023-08-06, 2023-08-07, 2023-08-08, 2023-08-09, 2023-08-10, 2023-08-11, 2023-08-12, 2023-08-13, 2023-08-14, 2023-08-15, 2023-08-16, 2023-08-17, 2023-08-18]
            //周数组: [2022-08-01至2022-08-07, 2022-08-08至2022-08-14, 2022-08-15至2022-08-21, 2022-08-22至2022-08-28, 2022-08-29至2022-09-04, 2022-09-05至2022-09-11, 2022-09-12至2022-09-18, 2022-09-19至2022-09-25, 2022-09-26至2022-10-02, 2022-10-03至2022-10-09, 2022-10-10至2022-10-16, 2022-10-17至2022-10-23, 2022-10-24至2022-10-30, 2022-10-31至2022-11-06, 2022-11-07至2022-11-13, 2022-11-14至2022-11-20, 2022-11-21至2022-11-27, 2022-11-28至2022-12-04, 2022-12-05至2022-12-11, 2022-12-12至2022-12-18, 2022-12-19至2022-12-25, 2022-12-26至2023-01-01, 2023-01-02至2023-01-08, 2023-01-09至2023-01-15, 2023-01-16至2023-01-22, 2023-01-23至2023-01-29, 2023-01-30至2023-02-05, 2023-02-06至2023-02-12, 2023-02-13至2023-02-19, 2023-02-20至2023-02-26, 2023-02-27至2023-03-05, 2023-03-06至2023-03-12, 2023-03-13至2023-03-19, 2023-03-20至2023-03-26, 2023-03-27至2023-04-02, 2023-04-03至2023-04-09, 2023-04-10至2023-04-16, 2023-04-17至2023-04-23, 2023-04-24至2023-04-30, 2023-05-01至2023-05-07, 2023-05-08至2023-05-14, 2023-05-15至2023-05-21, 2023-05-22至2023-05-28, 2023-05-29至2023-06-04, 2023-06-05至2023-06-11, 2023-06-12至2023-06-18, 2023-06-19至2023-06-25, 2023-06-26至2023-07-02, 2023-07-03至2023-07-09, 2023-07-10至2023-07-16, 2023-07-17至2023-07-23, 2023-07-24至2023-07-30, 2023-07-31至2023-08-06, 2023-08-07至2023-08-13, 2023-08-14至2023-08-20]
            //月数组: [2022-08, 2022-09, 2022-10, 2022-11, 2022-12, 2023-01, 2023-02, 2023-03, 2023-04, 2023-05, 2023-06, 2023-07, 2023-08]
            //季度数组: [2022年3季度, 2022年4季度, 2023年1季度, 2023年2季度, 2023年3季度]
            //年数组: [2022, 2023]
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *Generate time intervals based on the time dimension
     * @param startDate
     * @param endDate
     * @param dateDimension
     * @return
     */
    public  static  List<String> generateIntervals(Date startDate, Date endDate, Integer dateDimension){
        List<String> Intervals;
        if(dateDimension==1){
            Intervals=generateDayIntervals(startDate, endDate);
        }else if(dateDimension==2){
            Intervals= io.renren.modules.salesTimelineDashboard.Util.TimeIntervalsGeneratorUtil.generateWeekIntervals(startDate, endDate);
        }else if(dateDimension==3){
            Intervals= io.renren.modules.salesTimelineDashboard.Util.TimeIntervalsGeneratorUtil.generateMonthIntervals(startDate, endDate);
        }else if(dateDimension==4){
            Intervals= io.renren.modules.salesTimelineDashboard.Util.TimeIntervalsGeneratorUtil.generateQuarterIntervals(startDate, endDate);
        }else if(dateDimension==5){
            Intervals= io.renren.modules.salesTimelineDashboard.Util.TimeIntervalsGeneratorUtil.generateYearIntervals(startDate, endDate);
        }else {
            Intervals= io.renren.modules.salesTimelineDashboard.Util.TimeIntervalsGeneratorUtil.generateDayIntervals(startDate, endDate);
        }
        return Intervals;
    }

    public static List<String> generateDayIntervals(Date startDate, Date endDate) {
        List<String> dayIntervals = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        while (calendar.getTime().before(endDate) || calendar.getTime().equals(endDate)) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dayIntervals.add(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }

        return dayIntervals;
    }

    public static List<String> generateWeekIntervals(Date startDate, Date endDate) {
        List<String> weekIntervals = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        calendar.setTime(startDate);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDates = dateFormat.format(calendar.getTime());
        int aa= calendar.get(Calendar.DAY_OF_WEEK);

        String weekStart = "";
        String weekEnd = "";
        int a= calendar.get(Calendar.DAY_OF_WEEK);
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            calendar.add(Calendar.DAY_OF_MONTH, -6);
            weekStart = dateFormat.format(calendar.getTime());
        }else{
            int c=Calendar.DAY_OF_WEEK;
            calendar.add(Calendar.DAY_OF_MONTH, -(a-2));
            int b= calendar.get(Calendar.DAY_OF_WEEK);
            weekStart = dateFormat.format(calendar.getTime());
        }

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            weekEnd = dateFormat.format(calendar.getTime());
            weekIntervals.add(weekStart + "至" + weekEnd);  // "至" Chinese character "to"
        }else{
            calendar.add(Calendar.DAY_OF_MONTH, +6);
            weekEnd = dateFormat.format(calendar.getTime());
            weekIntervals.add(weekStart + "至" + weekEnd); //"至" Chinese character "to"
        }

        while (calendar.getTime().before(endDate) || calendar.getTime().equals(endDate)) {
            calendar.add(Calendar.DAY_OF_MONTH, +1);
            weekStart = dateFormat.format(calendar.getTime());
            calendar.add(Calendar.DAY_OF_MONTH, +6);
            weekEnd = dateFormat.format(calendar.getTime());
            weekIntervals.add(weekStart + "至" + weekEnd); //"至" Chinese character "to"
        }
        return weekIntervals;
    }

    public static List<String> generateMonthIntervals(Date startDate, Date endDate) {
        List<String> monthIntervals = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");

        while (calendar.getTime().before(endDate) || calendar.getTime().equals(endDate)) {
            monthIntervals.add(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.MONTH, 1);
        }

        return monthIntervals;
    }

    public static List<String> generateQuarterIntervals(Date startDate, Date endDate) {
        List<String> quarterIntervals = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        int currentQuarter = (calendar.get(Calendar.MONTH) / 3) + 1;
        int currentYear = calendar.get(Calendar.YEAR);

        while (calendar.getTime().before(endDate) || calendar.getTime().equals(endDate)) {
            int newQuarter = (calendar.get(Calendar.MONTH) / 3) + 1;
            int newYear = calendar.get(Calendar.YEAR);
            if (newQuarter != currentQuarter) {
                quarterIntervals.add(String.format("%d年%d季度", currentYear, currentQuarter)); //"年" Chinese character "year" "季度" Chinese character "quarter
                currentQuarter = newQuarter;
                currentYear = newYear;
            }
            calendar.add(Calendar.MONTH, 1);
        }

        // 添加结束日期的季度 Add quarter ending date
        quarterIntervals.add(String.format("%d年%d季度", calendar.get(Calendar.YEAR), currentQuarter));//"年" Chinese character "year" "季度" Chinese character "quarter

        return quarterIntervals;
    }

    public static List<String> generateYearIntervals(Date startDate, Date endDate) {
        List<String> yearIntervals = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");

        while (calendar.getTime().before(endDate) || calendar.getTime().equals(endDate)) {
            yearIntervals.add(dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.YEAR, 1);
        }

        return yearIntervals;
    }




}
