package io.github.berkayelken.objectivec.parser.preprocess.utils.separator;

import io.github.berkayelken.common.model.type.ClassEntity;
import io.github.berkayelken.objectivec.parser.preprocess.utils.LineUtils;
import io.github.berkayelken.objectivec.parser.preprocess.utils.TypeUtils;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.github.berkayelken.objectivec.parser.preprocess.utils.HeaderUtils.collectHeaderInfo;
import static io.github.berkayelken.objectivec.parser.preprocess.utils.TypeUtils.TYPE_DECLARATION_SCOPE_FINISH_IDENTIFIER;

public final class ClassSeparator {
	public static List<ClassEntity> getClassEntities(String source) {
		return getTypeDeclarations(source).stream().map(ClassSeparator::createClassParserContent).collect(Collectors.toList());
	}

	private static List<String> getTypeDeclarations(String source) {
		return Arrays.asList(source.split(TYPE_DECLARATION_SCOPE_FINISH_IDENTIFIER));
	}

	private static ClassEntity createClassParserContent(String source) {
		String typeDeclarationLine = LineUtils.getTypeDeclarationLine(source);
		String typeDeclarationIdentifier = TypeUtils.getClassTypeIdentifier(typeDeclarationLine);
		String className = getName(typeDeclarationIdentifier, typeDeclarationLine);

		return ClassEntity.builder().imports(collectHeaderInfo(source)).type(TypeUtils.getClassType(typeDeclarationIdentifier))
				.name(className).inheritedClasses(getInheritedClasses(typeDeclarationLine))
				.extensionClass(getExtension(typeDeclarationLine))
				.sourceLines(LineSeparator.getSourceLines(getFormattedSource(source))).build();
	}

	private static String getFormattedSource(String source) {
		StringBuilder sb = new StringBuilder();

		Arrays.stream(source.replaceAll("\r", "").trim().split("\n")).map(LineUtils::getTrimmedString)
				.filter(LineUtils::isCommandLine).map(LineUtils::formatSourceFile).forEachOrdered(sb::append);

		return sb.toString();
	}

	private static String getName(String typeDeclarationIdentifier, String typeDeclarationLine) {
		int startIndex = typeDeclarationLine.indexOf(typeDeclarationIdentifier) + typeDeclarationIdentifier.length();
		int endIndex = LineUtils.getEndIndexOfClassName(typeDeclarationLine);
		return typeDeclarationLine.substring(startIndex, endIndex).trim();
	}

	private static List<String> getInheritedClasses(String typeDeclarationLine) {
		if (!typeDeclarationLine.contains(":")) {
			return Collections.emptyList();
		}

		String inheritancePart = typeDeclarationLine.substring(typeDeclarationLine.indexOf(":") + 1);
		if (!inheritancePart.contains(",")) {
			return Stream.of(inheritancePart.trim()).collect(Collectors.toList());
		}

		return Arrays.stream(inheritancePart.split(",")).map(String::trim).filter(StringUtils::hasText)
				.collect(Collectors.toList());
	}

	private static String getExtension(String typeDeclarationLine) {
		if (!typeDeclarationLine.contains("(") || !typeDeclarationLine.contains(")")) {
			return null;
		}

		return typeDeclarationLine.substring(typeDeclarationLine.indexOf("(") + 1, typeDeclarationLine.indexOf(")"));
	}

}
