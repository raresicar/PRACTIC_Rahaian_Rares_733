package org.example.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class JsonUtils {

    private JsonUtils() {
    }

    static String readResource(String resourceName) throws IOException {
        InputStream in = JsonUtils.class.getClassLoader().getResourceAsStream(resourceName);
        if (in == null) {
            throw new IOException("Resource not found: " + resourceName +
                    " (put it in src/main/resources/)");
        }

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append('\n');
            }
        }
        return sb.toString();
    }

    static List<Map<String, String>> parseObjectArray(String json) {
        String trimmed = json.trim();
        int start = trimmed.indexOf('[');
        int end = trimmed.lastIndexOf(']');
        if (start == -1 || end == -1 || end <= start) {
            return List.of();
        }

        String inner = trimmed.substring(start + 1, end);
        List<String> objects = splitObjects(inner);
        List<Map<String, String>> results = new ArrayList<>();
        for (String obj : objects) {
            results.add(parseObject(obj));
        }
        return results;
    }

    private static List<String> splitObjects(String json) {
        List<String> objects = new ArrayList<>();
        int depth = 0;
        int start = -1;

        for (int i = 0; i < json.length(); i++) {
            char c = json.charAt(i);
            if (c == '{') {
                if (depth == 0) {
                    start = i;
                }
                depth++;
            } else if (c == '}') {
                depth--;
                if (depth == 0 && start != -1) {
                    objects.add(json.substring(start, i + 1));
                    start = -1;
                }
            }
        }

        return objects;
    }

    private static Map<String, String> parseObject(String jsonObject) {
        Map<String, String> map = new HashMap<>();
        int i = 0;

        while (i < jsonObject.length()) {
            char c = jsonObject.charAt(i);
            if (c == '"') {
                int keyStart = i + 1;
                int keyEnd = jsonObject.indexOf('"', keyStart);
                if (keyEnd == -1) {
                    break;
                }
                String key = jsonObject.substring(keyStart, keyEnd);

                i = keyEnd + 1;
                while (i < jsonObject.length() && (jsonObject.charAt(i) == ' ' || jsonObject.charAt(i) == '\n'
                        || jsonObject.charAt(i) == '\r' || jsonObject.charAt(i) == '\t' || jsonObject.charAt(i) == ':')) {
                    i++;
                }

                String value;
                if (i < jsonObject.length() && jsonObject.charAt(i) == '"') {
                    int valueStart = i + 1;
                    int valueEnd = jsonObject.indexOf('"', valueStart);
                    if (valueEnd == -1) {
                        break;
                    }
                    value = jsonObject.substring(valueStart, valueEnd);
                    i = valueEnd + 1;
                } else {
                    int valueStart = i;
                    while (i < jsonObject.length()
                            && jsonObject.charAt(i) != ','
                            && jsonObject.charAt(i) != '}') {
                        i++;
                    }
                    value = jsonObject.substring(valueStart, i).trim();
                }

                map.put(key, value);
            } else {
                i++;
            }
        }

        return map;
    }
}
