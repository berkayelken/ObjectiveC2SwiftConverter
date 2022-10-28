package io.github.berkayelken.common.model.execution;

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
public class LineEntity {
	private String mutatedPart;
	private String mutatorPart;
	private MethodCallerEntity methodCaller;
	private String logMessage;
}
