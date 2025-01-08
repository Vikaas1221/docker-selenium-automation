package util;

import tests.vendorportal.VendorPortalTest;
import tests.vendorportal.model.VendorPortalTestData;

public class demo
{
    public static void main(String[] args) {
        VendorPortalTestData testData =JsonUtil.getTestData("test-data/vendor-portal/sam.json");
        System.out.println(testData.getUsername());
    }
}
