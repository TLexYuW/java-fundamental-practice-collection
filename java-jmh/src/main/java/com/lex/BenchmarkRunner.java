package com.lex;

import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;

/**
 * @author : LEX_YU
 * @version : 0.0.1
 * @date : 2023/4/7
 */
public class BenchmarkRunner {
	public static void main(String[] args) throws IOException, RunnerException {
		Options opt = new OptionsBuilder()
				.include(StringConnectTest.class.getSimpleName())
				.result("result.json")
				.resultFormat(ResultFormatType.JSON).build();
		new Runner(opt).run();
	}
}
