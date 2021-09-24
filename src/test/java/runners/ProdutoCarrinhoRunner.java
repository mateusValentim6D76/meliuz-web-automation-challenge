package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith (Cucumber.class)
@CucumberOptions(
        features = "feature/produtoCarrinho.feature",
        glue = {"steps"},
        tags = {"@RetirarProdutoCarrinho"},
        plugin = {"pretty"}
)
public class ProdutoCarrinhoRunner {

}
