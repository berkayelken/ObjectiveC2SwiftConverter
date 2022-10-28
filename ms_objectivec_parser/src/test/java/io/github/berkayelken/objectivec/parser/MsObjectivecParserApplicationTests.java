package io.github.berkayelken.objectivec.parser;

import io.github.berkayelken.common.model.type.ClassEntity;
import io.github.berkayelken.objectivec.parser.preprocess.utils.separator.ClassSeparator;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class MsObjectivecParserApplicationTests {

	private static final String IMPORT_REGEX = "^ *# *(?:import|include)\\s*([<\"])(.*?)[>\"]";
	private static final Pattern IMPORT_PATTERN = Pattern.compile(IMPORT_REGEX, Pattern.MULTILINE);

	private static void testRegex(String string) {
		final String regex = "^ *# *(?:import|include)\\s*([<\"])(.*?)[>\"]";

		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(string);

		while (matcher.find()) {
			System.out.println("Full match: " + matcher.group(0));

			for (int i = 1; i <= matcher.groupCount(); i++) {
				System.out.println("Group " + i + ": " + matcher.group(i));
			}
		}
	}

	public static List<String> collectHeaderInfo(String source) {
		Matcher matcher = IMPORT_PATTERN.matcher(source);
		return matcher.results().map(matchResult -> getHeaderPath(matchResult)).collect(Collectors.toList());
	}

	private static String getHeaderPath(MatchResult matchResult) {
		String startingLiteral = matchResult.group(1);
		String header = matchResult.group(2);
		int index = header.indexOf("/") + 1;
		if ("<".equals(startingLiteral) && index > 0)
			return header.substring(index);

		return header;
	}

	@Test
	void contextLoads() throws IOException {
		Stream<String> lines = Files.lines(Paths.get("D:\\SwiftConverter\\SwiftTranspiler"
				+ "\\ms_objectivec_parser\\src\\test\\java\\io\\github\\berkayelken\\objectivec\\parser\\test.txt"));
		String data = lines.collect(Collectors.joining("\n"));
		List<ClassEntity> classParserEntities = ClassSeparator.getClassEntities(data);

		assertNotNull(classParserEntities);
	}

}
