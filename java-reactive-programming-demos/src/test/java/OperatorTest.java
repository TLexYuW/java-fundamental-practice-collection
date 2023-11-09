import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author : Lex Yu
 */
public class OperatorTest {

    @Test
    public void subscribeOnIO() {
        Mono<List<String>> listMono = Mono.fromCallable(() -> Files.readAllLines(Path.of("io-sample.txt")))
                .log()
                .subscribeOn(Schedulers.boundedElastic());
        listMono.subscribe(System.out::println);
    }
}
