package com.javastudio.oag.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javastudio.openapigenerator.generated.v1.model.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class MockDataLoader {

    private static final String MOCK_DATA_CREATE_USER_REQUEST = "mock-data/create-product-request.json";

    private static final JSONParser JSON_PARSER = new JSONParser(JSONParser.MODE_PERMISSIVE);
    private static ObjectMapper objectMapper = new ObjectMapper();

    private static String readAsString(String path) throws IOException {
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(path)) {
            if (in == null) throw new IllegalArgumentException(path + " not found");
            return IOUtils.toString(in, StandardCharsets.UTF_8.name());
        }
    }

    private static <T> T readAsType(String resourceName, Class<T> type) throws IOException {
        try (InputStream in = MockDataLoader.class.getClassLoader().getResourceAsStream(resourceName)) {
            if (in == null) throw new IllegalArgumentException(resourceName + " not found");
            return objectMapper.readValue(in, type);
        }
    }

    private static JSONObject readAsJsonObject(String resourceName) throws IOException, ParseException {
        try (InputStream in = MockDataLoader.class.getClassLoader().getResourceAsStream(resourceName)) {
            if (in == null) throw new IllegalArgumentException(resourceName + " not found");
            return (JSONObject) JSON_PARSER.parse(in);
        }
    }

    private static File getResourceAsFile(String resourceName) throws URISyntaxException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(resourceName);
        if (url == null) throw new IllegalArgumentException(resourceName + " not found!");
        return new File(url.toURI());
    }


    public interface Resource<T> {

        Class<T> getType();

        String getResourceName();

        default T readApiModel() throws IOException {
            return readAsType(getResourceName(), getType());
        }

        default String jsonString() throws IOException {
            return readAsString(getResourceName());
        }

        default File getResourceFile() throws URISyntaxException {
            return getResourceAsFile(getResourceName());
        }

        default JSONObject jsonObject() throws IOException, ParseException {
            return readAsJsonObject(getResourceName());
        }
    }

    @Getter
    @RequiredArgsConstructor
    public enum ProductEnum implements Resource<Product> {

        CREATE_PRODUCT_REQUEST("mock-data/create-product-request.json");

        private final String resourceName;

        @Override
        public Class<Product> getType() {
            return Product.class;
        }
    }
}
