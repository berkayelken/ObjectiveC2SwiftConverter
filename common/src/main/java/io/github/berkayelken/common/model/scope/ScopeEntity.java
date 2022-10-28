package io.github.berkayelken.common.model.scope;

import io.github.berkayelken.common.model.execution.LineEntity;
import io.github.berkayelken.common.model.execution.method.MethodEntity;
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
public class ScopeEntity {
	private List<VariableEntity> variables;
	private List<MethodEntity> methods;
	private List<LineEntity> lines;
	private List<ScopeEntity> scopes;
	private boolean ifScope;
	private boolean elseScope;
	private boolean tryScope;
	private boolean catchScope;
	private boolean switchScope;
	private boolean methodScope;
}
