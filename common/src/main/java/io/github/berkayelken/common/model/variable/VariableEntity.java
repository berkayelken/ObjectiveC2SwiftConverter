package io.github.berkayelken.common.model.variable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VariableEntity {
	private boolean primitive;
	private boolean staticField;
	private boolean immutable;
	private boolean atomic;
	private boolean readOnly;
	private boolean array;
	private boolean hasAccessor;
	private String accessorName;
	private boolean hasMutator;
	private String mutatorName;
	private String variableTypeName;
	private VariableType type;
}
