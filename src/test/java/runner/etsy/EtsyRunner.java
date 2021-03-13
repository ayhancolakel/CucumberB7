package runner.etsy;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com.etsy/EtsySearchOutline.feature",
        glue={"steps/com/etsy","steps/Hook"},
        // glue is step definition package
       // glue="steps",
        dryRun = false,  // this comes true don't forget to change it to false
        tags="@outline"
       // tags="@smoke"
       // tags="@pin or @hat"
       // tags="@smoke and @regression"
)

public class EtsyRunner {


}
