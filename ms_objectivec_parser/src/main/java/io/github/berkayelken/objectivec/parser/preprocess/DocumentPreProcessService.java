package io.github.berkayelken.objectivec.parser.preprocess;

import org.springframework.stereotype.Service;

@Service
public class DocumentPreProcessService {

	private String normalize(String source) {
		return source.replaceAll("\r\n", "\n");
	}
}
