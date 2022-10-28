package io.github.berkayelken.objectivec.parser.preprocess.utils.separator;

import io.github.berkayelken.objectivec.parser.preprocess.utils.LineUtils;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public final class LineSeparator {
	public static List<String> getSourceLines(String source) {
		return Arrays.stream(source.trim().split("\n")).map(LineUtils::getTrimmedString).filter(LineUtils::isCommandLine)
				.collect(toList());
	}
}
