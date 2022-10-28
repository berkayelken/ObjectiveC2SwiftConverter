package io.github.berkayelken.objectivec.parser.preprocess.utils;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class HeaderUtils {
	private static final String IMPORT_REGEX = "^ *# *(?:import|include)\\s*([<\"])(.*?)[>\"]";
	public static final Pattern IMPORT_PATTERN = Pattern.compile(IMPORT_REGEX, Pattern.MULTILINE);

	public static List<String> collectHeaderInfo(String source) {
		Matcher matcher = IMPORT_PATTERN.matcher(source);
		return matcher.results().map(HeaderUtils::getHeaderPath).collect(Collectors.toList());
	}

	private static String getHeaderPath(MatchResult matchResult) {
		String startingLiteral = matchResult.group(1);
		String header = matchResult.group(2);
		int index = header.indexOf("/") + 1;
		if ("<".equals(startingLiteral) && index > 0)
			return header.substring(index);

		return header;
	}

}
