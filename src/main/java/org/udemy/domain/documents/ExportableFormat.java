package org.udemy.domain.documents;

public interface ExportableFormat {
    String toTxt();
    byte[] toPdf();
    String toJson();
}
