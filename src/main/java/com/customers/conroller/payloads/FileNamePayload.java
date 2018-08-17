package com.customers.conroller.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileNamePayload {

    @JsonProperty(value = "file_name")
    private String fileName;

    public FileNamePayload(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
