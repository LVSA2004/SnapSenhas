package br.com.fiap.snapsenhasteste.models;

public record TokenJwt(String token,
                       String type,
                       String prefix)  {}
