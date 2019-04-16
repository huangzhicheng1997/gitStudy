package com.hzc.api.annotationTest;

public class B {
    @SourceField(FieldName = "name")
    private String nameB;
    @SourceField(FieldName = "value")
    private String valueA;

    public String getNameB() {
        return nameB;
    }

    public void setNameB(String nameB) {
        this.nameB = nameB;
    }

    public String getValueA() {
        return valueA;
    }

    public void setValueA(String valueA) {
        this.valueA = valueA;
    }

    @Override
    public String toString() {
        return "B{" +
                "nameB='" + nameB + '\'' +
                ", valueA='" + valueA + '\'' +
                '}';
    }
}
