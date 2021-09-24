package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions(
        features = "feature/pesquisaProdutoInexistente.feature",
        glue = {"steps"},
        tags = {"@BuscaProdutoTriste"},
        plugin = {"pretty"}
)
public class ProdutoNaoExistenteRunner {

}
