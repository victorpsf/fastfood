package com.api.fastfood.Enums;

import java.util.HashMap;
import java.util.Map;

public enum DocumentType {
    None(0), CPF(1), RG(2), CNPJ(3);

    private final int value;
    DocumentType(int _value) {
        this.value = _value;
    }

    private static final Map<Integer, DocumentType> _map = new HashMap<Integer, DocumentType>();
    static {
        for (DocumentType documentType: DocumentType.values())
            _map.put(documentType.value, documentType);
    }

    public int GetValue() {
        return this.value;
    }

    public static DocumentType from (int value) {
        return _map.get(value);
    }
}
