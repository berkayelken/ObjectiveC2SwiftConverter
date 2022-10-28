package io.github.berkayelken.common.model.execution.method;

import io.github.berkayelken.common.model.scope.ScopeEntity;
import io.github.berkayelken.common.model.variable.VariableEntity;
import io.github.berkayelken.common.model.variable.VariableType;
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
public class MethodEntity {
	private String name;
	private boolean staticMethod;
	private VariableType returnType;
	private List<VariableEntity> parameters;
	private boolean abstractBody;
	private List<ScopeEntity> lines;
}
