//https://www.baeldung.com/jackson-json-view-annotation

package com.ascending.jsonView;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;


public class JsonViewTest {
    @Test
    public void whenUseJsonViewToSerialize_thenCorrect()
            throws JsonProcessingException {

        User user = new User(1, "John");

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);

        String result = mapper
                .writerWithView(Views.Public.class)
                .writeValueAsString(user);

        assertThat(result, containsString("John"));
        assertThat(result, not(containsString("1")));
    }

    @Test
    public void whenUsePublicView_thenOnlyPublicSerialized()
            throws JsonProcessingException {

        Item item = new Item(2, "book", "John");

        ObjectMapper mapper = new ObjectMapper();
        String result = mapper
                .writerWithView(Views.Public.class)
                .writeValueAsString(item);

        assertThat(result, containsString("book"));
        assertThat(result, containsString("2"));

        assertThat(result, not(containsString("John")));
    }

    @Test
    public void whenUseJsonViewToDeserialize_thenCorrect()
            throws IOException {

        String json = "{\"id\":1,\"name\":\"John\"}";

        ObjectMapper mapper = new ObjectMapper();
        User user = mapper
                .readerWithView(Views.Public.class)
                .forType(User.class)
                .readValue(json);

        assertEquals(1, user.getId());
        assertEquals("John", user.getName());
    }
}
