package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions(
        features = "feature/pesquisaProduto.feature",
        glue = {"steps"},
        tags = {"@BuscaPorProdutoFeliz"},
        plugin = {"pretty"}
)
public class Runner {

}