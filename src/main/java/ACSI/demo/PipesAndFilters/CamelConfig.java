package ACSI.demo.PipesAndFilters;

import org.apache.camel.Configuration;
import org.apache.camel.builder.RouteBuilder;

@Configuration
public class CamelConfig extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("kafka:inputTopic")
                .streamCaching()
                .split().tokenize("\n")
                .process(exchange -> {
                    // Lógica de processamento de vídeo aqui
                })
                .to("kafka:outputTopic");
    }
}
