package io.github.berkayelken.objectivec.parser.preprocess.utils;

import java.util.Arrays;
import java.util.List;

import static io.github.berkayelken.objectivec.parser.preprocess.utils.HeaderUtils.IMPORT_PATTERN;
import static org.springframework.util.StringUtils.hasText;

public final class LineUtils {
	private static final String CLASS_TYPE_IDENTIFIER = "@implementation";
	private static final String PROTOCOL_TYPE_IDENTIFIER = "@protocol";
	private static final String INTERFACE_TYPE_IDENTIFIER = "@interface";

	private static final List<String> TYPE_DECLARATIONS = Arrays.asList(CLASS_TYPE_IDENTIFIER, PROTOCOL_TYPE_IDENTIFIER,
			INTERFACE_TYPE_IDENTIFIER);

	private LineUtils() {

	}

	public static boolean isCommentLine(String line) {
		return !hasText(line) || line.startsWith("//") || line.startsWith("#");
	}

	public static boolean isNotCommentLine(String line) {
		return !isCommentLine(line);
	}

	public static boolean isCommandLine(String line) {
		return isNotCommentLine(line) && !IMPORT_PATTERN.matcher(line).matches() && !isTypeDeclarationLine(line);
	}

	public static String getTrimmedString(String text) {
		if (hasText(text))
			return text.trim();
		return "";
	}

	public static String getTypeDeclarationLine(String source) {
		return Arrays.stream(source.replaceAll("\r", "").trim().split("\n")).map(LineUtils::getTrimmedString)
				.filter(LineUtils::isTypeDeclarationLine).findFirst().orElse("").trim();
	}

	public static boolean isTypeDeclarationLine(String line) {
		return TYPE_DECLARATIONS.stream().anyMatch(line::startsWith);
	}

	public static int getEndIndexOfClassName(String line) {
		if (line.contains(":")) {
			return line.indexOf(":");
		} else if (line.contains("(")) {
			return line.indexOf("(");
		}

		return line.length();
	}

	public static String formatSourceFile(String line) {
		return line.replaceAll("\\{", "\\{\n").replaceAll("\\}", "\\}\n").replaceAll(";", ";\n");
	}
}
