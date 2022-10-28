package io.github.berkayelken.common.model.type;

import io.github.berkayelken.common.model.scope.ScopeEntity;
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
public class ClassEntity {
	private String name;
	private boolean immutable;
	private ClassType type;
	private List<String> imports;
	private List<String> inheritedClasses;
	private String extensionClass;
	private ScopeEntity scope;
	private List<String> sourceLines;
}
