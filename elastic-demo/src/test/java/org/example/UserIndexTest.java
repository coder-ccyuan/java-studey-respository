package org.example;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.example.DSLMapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * 对索引库操作
 */

@SpringBootTest
public class UserIndexTest {
    private RestHighLevelClient client;
@BeforeEach
    void setUp(){
        this.client=new RestHighLevelClient(RestClient.builder(
                HttpHost.create("http://192.168.99.133:9200")
        ));
    }
    @Test
    public void test(){
    System.out.println(client);
    }

    /**
     * 创建索引库user
     * @throws IOException
     */
    @Test
    void testCreateUserIndex() throws IOException {
        //1.创建request 请求
        CreateIndexRequest request = new CreateIndexRequest("user");//  == PUT /user
        //2.准备请求的参数：DSL语句
        request.source(UserMapper.MAPPER_TEMPLATE, XContentType.JSON);
        //3.发送请求
        client.indices().create(request, RequestOptions.DEFAULT);//create 创建
    }

    /**
     * 删除索引库
     * @throws IOException
     */
    @Test
    void testDeleteUserIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("user");//  == PUT /user
        AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(delete);
    }
    /**
     * 判断索引库
     * @throws IOException
     */
    @Test
    void testExistUserIndex() throws IOException {
        GetIndexRequest user = new GetIndexRequest("user");//使用get
        boolean exists = client.indices().exists(user, RequestOptions.DEFAULT);
        System.out.println(exists);
    }
}
