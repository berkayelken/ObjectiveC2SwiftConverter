package io.github.berkayelken.common.model.execution.method;

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
public class MethodCallerEntity {
	private String name;
	private String owner;
	private List<Object> arguments;
}
