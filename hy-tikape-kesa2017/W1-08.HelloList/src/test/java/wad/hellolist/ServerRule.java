package wad.hellolist;

import java.util.Random;
import org.junit.rules.ExternalResource;
import spark.Spark;

public class ServerRule extends ExternalResource {

    private int randomPort;

    public ServerRule() {
        Random random = new Random();
        this.randomPort = 1024 + random.nextInt(50000);
    }

    @Override
    protected void before() throws Throwable {
        Spark.port(this.randomPort);
        HelloList.main(new String[]{});
        Spark.awaitInitialization();
    }

    @Override
    protected void after() {
        Spark.stop();
    }

    public int getPort() {
        return this.randomPort;
    }
}
