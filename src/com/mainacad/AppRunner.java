package com.mainacad;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mainacad.model.Item;
import com.mainacad.service.WebClient;
import org.glassfish.jersey.examples.jaxb.JaxbXmlRootElement;

import java.util.Arrays;
import java.util.logging.Logger;

public class AppRunner {

    private static Logger logger = Logger.getLogger(AppRunner.class.getName());
    public static void main(String[] args) {
        Item item = WebClient.getItem("https://www.amazon.com/HP-Flagship-Premium-i7-8750H-Keyboard/dp/B07TKXFYCP/ref=sr_1_9?keywords=hp+15+omen&qid=1563466678&s=computers-intl-ship&sr=8-9");
//        logger.info("\n" + item.toString());

        // json
        // {"name" : "value",
        //  "list" : { "element1" : "value1",
        //             "element2" : "value1",
        //             "element3" : "value1",
        //             "element4" : "value1",
        //            }
        // }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            logger.info(objectMapper.writeValueAsString(Arrays.asList(item)));
        } catch (Exception e) {
            e.printStackTrace();
        }



        // csv
        // item ID, name, ..., item URL;
        // 1111, Test item1,..., http...;
        // 2222, Test item2,..., http...;

        // xml
        // <item>
        //      <itemId>1111</itemId>
        //      <name>Test Name</name>
        //      ....
        // </item>


    }

}
