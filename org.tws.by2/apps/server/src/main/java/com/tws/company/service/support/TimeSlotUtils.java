package com.tws.company.service.support;

import java.time.LocalTime;

public final class TimeSlotUtils {

    private TimeSlotUtils() {}

    public static int timeToMinutes(LocalTime time) {
        if (time == null) {
            return 0;
        }
        return time.getHour() * 60 + time.getMinute();
    }

    public static boolean doIntervalsOverlap(
        LocalTime startA,
        LocalTime endA,
        boolean isOvernightA,
        LocalTime startB,
        LocalTime endB,
        boolean isOvernightB
    ) {
        int startAMinutes = timeToMinutes(startA);
        int endAMinutes = timeToMinutes(endA);
        int startBMinutes = timeToMinutes(startB);
        int endBMinutes = timeToMinutes(endB);

        int effectiveEndA = isOvernightA && endAMinutes <= startAMinutes ? endAMinutes + 1440 : endAMinutes;
        int effectiveEndB = isOvernightB && endBMinutes <= startBMinutes ? endBMinutes + 1440 : endBMinutes;

        return startAMinutes < effectiveEndB && startBMinutes < effectiveEndA;
    }
}
