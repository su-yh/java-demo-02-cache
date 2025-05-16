package com.suyh0201.mp.typehandler.enlist;

import com.suyh0201.sys.constant.enums.DaysOfWeekEnums;

/**
 * @author suyh
 * @since 2024-09-03
 */
public class DaysOfWeekListTypeHandler extends AbstractEnumListTypeHandler<DaysOfWeekEnums> {
    public DaysOfWeekListTypeHandler() {
        super(DaysOfWeekEnums.class);
    }
}
