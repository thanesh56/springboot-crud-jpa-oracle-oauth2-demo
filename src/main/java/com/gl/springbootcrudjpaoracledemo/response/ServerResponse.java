package com.gl.springbootcrudjpaoracledemo.response;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ServerResponse {
	String code;
	String message;
	Object data;
	String status;


}
