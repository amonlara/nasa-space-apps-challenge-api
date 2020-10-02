package br.com.nasaspaceappschallenge.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

	INVALID_DATA("/invalid-data","Dados inválidos"),
	INVALID_PARAMETER("/invalid-parameter", "Parâmetro inválido"),
	INVALID_LOGIN("/invalid-login", "Login inválido"),
	INVALID_BODY_REQUEST("/invalid-body-request", "Requisição mal formatada"),
	ENTITY_VALIDATION("/entity-validation", "Validação de entidade"),
	RESOURCE_NOT_FOUND("/resource-not-found", "Recurso não encontrado"),
	ACCESS_DENIED("/access-denied", "Acesso negado"),

	SYSTEM_ERROR("/system-error", "Erro de Sistema");
	
	private String title;
	private String uri;
	
	ProblemType(String path, String title) {
		this.uri = "https://api.ze-code-challenge-back.com.br" + path;
		this.title = title;
	}
	
}