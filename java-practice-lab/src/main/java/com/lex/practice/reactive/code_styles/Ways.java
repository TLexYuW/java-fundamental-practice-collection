package com.lex.practice.reactive.code_styles;

import com.lex.practice.reactive.model.User;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : Lex Yu
 */
public class Ways {

	// imperative
	public static List<User> userList() {
		List<User> userList = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			User u = User.builder()
					.id(i)
					.firstName("User-First-Name" + i)
					.lastName("User-Last-Name-" + i)
					.build();
			userList.add(u);
		}
		return userList;
	}

	public User authUser(Boolean isAuthenticated) {
		return isAuthenticated ? User.builder().id(9999).firstName("Test First").lastName("Test Last").build() : null;
	}

	// Stream / Functional
	public static Stream<User> userStream() {
		return userList().stream();
	}

	// Reactive
	public static Flux<User> userFlux() {
		return Flux.fromStream(userStream());
	}
}
