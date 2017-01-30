package com.vincenzodevivo.jdutils.examples;

import com.vincenzodevivo.jdutils.regex.RegexUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by vdevivo on 24/01/2017.
 */
public class RegexUtilsExamples {
    private static final Logger logger = LoggerFactory.getLogger(RegexUtilsExamples.class);

    @Test
    public void findAllEmail() throws Exception {
        String text = "Lorem ipsum dolor sit amet," +
                " consectetur adipiscing elit," +
                " sed do eiusmod tempor info@test.com@ incididunt" +
                " ut labore et dolore magna aliqua." +
                " Ut enim ad minim veniam," +
                " quis nostrud exercitation ullamco test@test.org" +
                " laboris nisi ut aliquip ex ea commodo consequat." +
                " Duis aute irure dolor in reprehenderit in voluptate" +
                " velit test56@testtest.it esse cillum dolore" +
                " eu fugiat nulla pariatur." +
                " Excepteur sint occaecat cupidatat non proident," +
                " sunt in culpa qui officia deserunt" +
                " test_123-12b@test.co.uk mollit anim id est laborum.";

        List<String> emails = RegexUtils
                .create()
                .email()
                .findAll(text);
        /*
        Results:

        info@test.com
        test@test.org
        test56@testtest.it
        test_123-12b@test.co.uk
        */
        for (String email : emails) {
            System.out.println(email);
        }
        assertArrayEquals(new String[]{
                "info@test.com",
                "test@test.org",
                "test56@testtest.it",
                "test_123-12b@test.co.uk"
        }, emails.toArray());
    }

    @Test
    public void findAllFruitInDollars() throws Exception {
        String text = "Apples £0.94, Bananas $0.68, Oranges €1.50," +
                " Pineapple $0.69, Mango $0.75";

        Map<String, String> fruitInDollars = RegexUtils
                .create()
                .group("key")
                    .letters()
                .endGroup()
                .space()
                .group("value")
                    .constant("$")
                    .number()
                .endGroup()
                .findMap(text);

        /*
        Results:

        Bananas -> $0.68
        Mango -> $0.75
        Pineapple -> $0.69
        */

        for (Map.Entry<String, String> entry : fruitInDollars.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        assertEquals(3, fruitInDollars.size());
        assertEquals("$0.68", fruitInDollars.get("Bananas"));
        assertEquals("$0.75", fruitInDollars.get("Mango"));
        assertEquals("$0.69", fruitInDollars.get("Pineapple"));
    }
}