package com.happs.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\main\\java\\features", 
				glue = "com/happs/loginStep", 
				monochrome = true,
				tags =  "@Prod or @Sanity"
//				plugin = {"pretty","html:target"}
				)
public class Runner {

}
