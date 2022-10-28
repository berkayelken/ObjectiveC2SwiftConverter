package io.github.berkayelken.common.model.execution.mutating;

import io.github.berkayelken.common.model.execution.method.MethodCallerEntity;
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
public class MutatorEntity {
	private Object value;
	private MutatingOperator followingOperator;
	private MethodCallerEntity methodCaller;
}
