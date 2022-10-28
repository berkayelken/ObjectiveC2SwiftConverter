package io.github.berkayelken.common.model.parser;

import io.github.berkayelken.common.model.type.ClassEntity;
import io.github.berkayelken.common.model.variable.VariableEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassParserEntity {
	private String path;
	private List<String> imports;
	private List<VariableEntity> globalVariables;
	private List<ClassEntity> classes;
}
