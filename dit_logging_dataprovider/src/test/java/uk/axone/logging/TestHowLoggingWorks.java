package uk.axone.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

/**
 * @author Karthik.Gandhinathan
 */
public class TestHowLoggingWorks {

    protected static final Logger LOG = LogManager.getLogger();

    @Test
    public void testHowLog4jWorks(){
        LOG.trace("This is a trace message");
        LOG.debug("This is a debug message");
        LOG.info("This is an information message");
        LOG.warn("This is a warning message");
        LOG.error("This is an error message");
        LOG.fatal("This is a fatal message");

    }
}
