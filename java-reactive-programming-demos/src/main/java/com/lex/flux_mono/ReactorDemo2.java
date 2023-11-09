package com.lex.flux_mono;

import com.lex.code_styles.Ways;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : Lex Yu
 */
public class ReactorDemo2 {
    public static void main(String[] args) throws InterruptedException {
//        ReactorSource.rangeFlux().subscribe(integer -> System.out.printf("%d\t", integer));

        /*
        ReactorSource.intervalFlux().subscribe(
                e -> System.out.println(e.intValue()),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed!")
        );
        Thread.sleep(15000);
         */

    }
}
