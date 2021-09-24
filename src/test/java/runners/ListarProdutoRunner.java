package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions(
        features = "feature/listarProduto.feature",
        glue = {"steps"},
        tags = {"@ListarSubProdutoFeliz"},
        plugin = {"pretty"}
)
public class ListarProdutoRunner {

}
