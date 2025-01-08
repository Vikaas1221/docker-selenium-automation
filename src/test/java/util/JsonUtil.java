package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.vendorportal.model.VendorPortalTestData;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtil
{
    private static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static VendorPortalTestData getTestData(String path){
        try {
            InputStream stream = ResourceLoader.getResource(path);
            return mapper.readValue(stream, VendorPortalTestData.class);
        } catch (Exception e) {
            log.error("Unable to read the test data {}",path,e);
        }
        return null;
    }
}
