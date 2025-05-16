package com.suyh0201.mp.typehandler.enlist;

import com.suyh0201.sys.constant.enums.HourOfDayEnums;

/**
 * @author suyh
 * @since 2024-09-03
 */
public class HourOfDayListTypeHandler extends AbstractEnumListTypeHandler<HourOfDayEnums> {
    public HourOfDayListTypeHandler() {
        super(HourOfDayEnums.class);
    }
}
