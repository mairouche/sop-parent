package fr.spiritofphoenix.sop.auth.api.util;

import static org.junit.Assert.assertFalse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/applicationContext.xml", "file:src/main/webapp/WEB-INF/spring/applicationServlet.xml"})
@WebAppConfiguration
public abstract class AbstractControllerTest {

    private static final String JSON_CONTENT_TYPE = "application/json";
    protected static final String HTTP_POST_METHOD = "POST";
    protected static final String HTTP_GET_METHOD = "GET";

    @Autowired
    protected RequestMappingHandlerAdapter handlerAdapter;

    @Autowired
    protected RequestMappingHandlerMapping handlerMapping;

    protected MockMvc mockMvc;
    protected MockHttpServletRequest request;
    protected MockHttpServletResponse response;
    protected MockHttpSession session;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        session = new MockHttpSession();
    }

    protected ModelAndView getResponsePage() throws Exception {
        Object handler = handlerMapping.getHandler(request).getHandler();
        return handlerAdapter.handle(request, response, handler);
    }
   
    
    protected void testJsonArrayRoute(String route, String method) throws Exception {
        request.setRequestURI(route);
        request.setMethod(method);
        request.setContentType(JSON_CONTENT_TYPE);
        Object handler = handlerMapping.getHandler(request).getHandler();
        handlerAdapter.handle(request, response, handler);
        JSONArray jsonArray = (JSONArray) new JSONParser().parse(response.getContentAsString());
        System.out.println(jsonArray);
        assertFalse(jsonArray.isEmpty());
    }
    
    protected void testJsonObjectRoute(String route, String method) throws Exception {
        request.setRequestURI(route);
        request.setMethod(method);
        request.setContentType(JSON_CONTENT_TYPE);
        Object handler = handlerMapping.getHandler(request).getHandler();
        handlerAdapter.handle(request, response, handler);
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.getContentAsString());
        System.out.println(jsonObject);
        assertFalse(jsonObject.isEmpty());
    }
    
    protected void processRoute(String route, String method) throws Exception {
        request.setRequestURI(route);
        request.setMethod(method);
        request.setContentType(JSON_CONTENT_TYPE);
        Object handler = handlerMapping.getHandler(request).getHandler();
        handlerAdapter.handle(request, response, handler);
    }
}
