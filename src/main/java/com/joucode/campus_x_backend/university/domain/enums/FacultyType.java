package com.joucode.campus_x_backend.university.domain.enums;

public enum FacultyType {

    ARTES_HUMANIDADES("Área de Artes y Humanidades"),

    CIENCIAS_SOCIALES_JURIDICAS("Área de Ciencias Sociales y Jurídicas"),

    CIENCIAS("Área Ciencias"),

    CIENCIAS_SALUD("Área Ciencias de la Salud"),

    INGENIERIA_ARQUITECTURA("Área Ingeniería y Arquitectura");

    private final String displayName;

    FacultyType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

