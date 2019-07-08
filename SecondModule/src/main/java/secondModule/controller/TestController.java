package secondModule.controller;

import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * This is a test controller for check logback and swagger
 */
@RestController
@RequestMapping("/")
@Api(description = "Test controller for test swagger")
@ApiModel(value = "test")
public class TestController {

    /**
     * Connect logger factory for describe logger messages
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * This method allows get index page
     * @return
     */
    @ApiOperation(value = "Get log message")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "All works")
    })
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
