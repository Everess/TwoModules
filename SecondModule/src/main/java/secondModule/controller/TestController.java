package secondModule.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a test controller
 */
@RestController
@Api(value = "test test")
public class TestController {

    /**
     * Connect logger factory for describe logger messages
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * This method allows get index page
     * @return
     */
    @GetMapping("/")
    public String index() {
        logger.error("This is error");
        logger.warn("This is warn");
        logger.info("This is info");
        logger.debug("This is debug");
        logger.trace("This is trace");

        return "index";
    }
}
