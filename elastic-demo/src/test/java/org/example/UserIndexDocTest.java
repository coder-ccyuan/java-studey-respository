package org.example;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.example.model.User;
import org.example.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@SpringBootTest
public class UserIndexDocTest {
    @Resource
    UserService userService;
    private RestHighLevelClient client;
    @BeforeEach
    void setUp(){
        this.client=new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://192.168.99.132:9200")
        ));
    }

    /**
     * 插入数据
     * @throws IOException
     */
    @Test
    void addDocTest() throws IOException {
        User user = userService.getById(1);
        IndexRequest request = new IndexRequest("user").id(user.getId().toString());
        request.source(JSON.toJSONString(user), XContentType.JSON);
        client.index(request, RequestOptions.DEFAULT);
    }

    /**
     * 查找数据
     * @throws IOException
     */
    @Test
    void getDocTest() throws IOException {
        GetRequest request = new GetRequest("user", "1");
        GetResponse documentFields = client.get(request, RequestOptions.DEFAULT);
        String json = documentFields.getSourceAsString();//解析响应
        User user = JSON.parseObject(json,User.class);
        System.out.println(user);
    }
    /**
     * 局部更新数据
     * @throws IOException
     */
    @Test
    void updateDocTest() throws IOException {
        UpdateRequest request = new UpdateRequest("user", "1");
        request.doc("name","王五");
        client.update(request,RequestOptions.DEFAULT);
    }

    /**
     * 删除数据
     * @throws IOException
     */
    @Test
    void deleteDocTest() throws IOException {
        DeleteRequest request = new DeleteRequest("user", "1");
        client.delete(request,RequestOptions.DEFAULT);
    }
    @Test
    void bulkAddDocTest() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        List<User> list = userService.list();
        for (User user : list) {
            bulkRequest.add(new IndexRequest("user")
                    .id(user.getId().toString())
                    .source(JSON.toJSONString(user),XContentType.JSON));
        }

        client.bulk(bulkRequest,RequestOptions.DEFAULT);
    }
}
