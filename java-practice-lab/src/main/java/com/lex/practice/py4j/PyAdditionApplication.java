package com.lex.practice.py4j;

import py4j.GatewayServer;

/**
 * @author : Lex Yu
 */
public class PyAdditionApplication {
	public int addition(int first, int second) {
		return first + second;
	}

	public static void main(String[] args) {
		var app = new PyAdditionApplication();
		// app is now the gateway.entry_point
		// [python-java-jupyter-collections](https://github.com/TLexYuW/python-java-jupyter-collections)
		GatewayServer server = new GatewayServer(app);
		server.start();
	}
}
