package persistencejs;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Dao {

	public MongoClient client;

	public MongoClient getClient() {
		client = new MongoClient();
		return client;
	}

	public MongoDatabase getDb() throws Exception {
		return getClient().getDatabase("BDOICOTI");
	}

	public void close() throws Exception {
		client.close();
	}

}
