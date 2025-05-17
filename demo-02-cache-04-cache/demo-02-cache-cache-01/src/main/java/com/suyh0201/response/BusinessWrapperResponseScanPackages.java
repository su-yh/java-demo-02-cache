package com.suyh0201.response;

import com.suyh.base.web.response.WrapperResponseScanPackages;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author suyh
 * @since 2025-05-17
 */
@Component
public class BusinessWrapperResponseScanPackages implements WrapperResponseScanPackages {
    @Override
    public Collection<String> getScanPackages() {
        return Arrays.asList("com.suyh0201.business.controller", "com.suyh0201.sys.controller");
    }
}
