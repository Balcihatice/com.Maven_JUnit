package day18_log4J;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;



public class C01_Log4J {

   //3. Logger object olustur:
    //    private static Logger logger = LogManager.getLogger(Demo1.class.getName());
//4. Logger fonksiyonuyla istenilen fonksiyonu kullan
//        logger.debug("Debug logger");
//        logger.info("Info logger");
//        logger.error("Error logger");
//        logger.fatal("Fatal logger");
    private static Logger logger = LogManager.getLogger(C01_Log4J.class.getName());
    @Test
    public void log4JTest(){
        //logger objesi ile yazdirma islemini yap
        logger.debug("Debug Log!");
        logger.info("Info Log!");
        logger.error("Error Log!");
        logger.fatal("Fatal Log!");
        logger.warn("Warning Log!");

    }
}
