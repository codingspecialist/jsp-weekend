package com.cos.blog;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Getter, Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
class 대통령 {
	private int id;
	private String name;
	private String phone;
	private String addr;
}

public class Test {
	public static void main(String[] args) {
		대통령 d = 대통령.builder()
				.id(1)
				.name("문재인")
				.build();
	}
}

