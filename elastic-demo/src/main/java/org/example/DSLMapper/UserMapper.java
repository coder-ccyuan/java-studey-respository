package org.example.DSLMapper;

public class UserMapper {
    public static final String MAPPER_TEMPLATE=
            "{\n" +
            "  \"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"id\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"index\": false\n" +
            "      },\n" +
            "      \"name\":{\n" +
            "        \"type\": \"text\"\n" +
            "      },\n" +
            "      \"gender\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"email\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";
}
