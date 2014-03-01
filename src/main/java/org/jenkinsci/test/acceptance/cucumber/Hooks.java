package org.jenkinsci.test.acceptance.cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.jenkinsci.test.acceptance.controller.JenkinsController;
import org.openqa.selenium.WebDriver;

import javax.inject.Inject;
import java.io.IOException;

/**
 *
 *
 * @author Kohsuke Kawaguchi
 */
public class Hooks {
    @Inject
    WebDriver driver;


    @Inject
    JenkinsController jenkinsController;

    @Before
    public void before() {
        try {
            jenkinsController.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @After
    public void bar() {
        try {
            jenkinsController.stop();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.close();
    }
}