package io.github.berkayelken.objectivec.parser.preprocess.utils;

import io.github.berkayelken.common.model.type.ClassType;

import java.util.HashMap;
import java.util.Map;

public final class TypeUtils {
	public static final String TYPE_DECLARATION_SCOPE_FINISH_IDENTIFIER = "@end";
	private static final String CLASS_TYPE_IDENTIFIER = "@implementation";
	private static final String PROTOCOL_TYPE_IDENTIFIER = "@protocol";
	private static final String INTERFACE_TYPE_IDENTIFIER = "@interface";
	private static final Map<String, ClassType> TYPE_MAP = new HashMap<>();

	static {
		TYPE_MAP.put(CLASS_TYPE_IDENTIFIER, ClassType.CLASS);
		TYPE_MAP.put(PROTOCOL_TYPE_IDENTIFIER, ClassType.PROTOCOL);
		TYPE_MAP.put(INTERFACE_TYPE_IDENTIFIER, ClassType.INTERFACE);
	}

	private TypeUtils() {

	}

	public static String getClassTypeIdentifier(String line) {
		if (line.startsWith(CLASS_TYPE_IDENTIFIER)) {
			return CLASS_TYPE_IDENTIFIER;
		} else if (line.startsWith(PROTOCOL_TYPE_IDENTIFIER)) {
			return PROTOCOL_TYPE_IDENTIFIER;
		} else if (line.startsWith(INTERFACE_TYPE_IDENTIFIER)) {
			return INTERFACE_TYPE_IDENTIFIER;
		}
		return null;
	}

	public static ClassType getClassType(String typeIdentifier) {
		return TYPE_MAP.get(typeIdentifier);
	}
}
