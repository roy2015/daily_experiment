package com.roy.research.misc.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by apple on 2019/11/25.
 */
public class TestCurator {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestCurator.class);

    /**
     */
    static class Solution {
        private CuratorFramework zkCli ;

        /**
         *
         * @param connectString    IP1:端口，IP2:端口
         * @param sessionTimeoutMs   20000
         * @param connectionTimeoutMs  15000
         */
        public Solution(String connectString, int sessionTimeoutMs, int connectionTimeoutMs) {
            zkCli = CuratorFrameworkFactory.newClient(connectString, sessionTimeoutMs, connectionTimeoutMs, new RetryNTimes(5, 1000));
            zkCli.start();
        }

        public void test1  (byte[] data) {
            try {
                String path = "/com.roy.miscellaneous/zk";
                MyCuratorWatcher myCuratorWatcher = new MyCuratorWatcher();
                if ( zkCli.checkExists().forPath(path) == null ) { //not exist node
                    zkCli.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path, data);
                    zkCli.getData().usingWatcher(myCuratorWatcher).forPath("/com.roy.miscellaneous/zk");
                } else {
                    zkCli.getData().usingWatcher(myCuratorWatcher).forPath("/com.roy.miscellaneous/zk");
                }
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }


        public void create (String path, byte[] data) {
            try {
                if ( zkCli.checkExists().forPath(path) == null ) { //not exist node
                    zkCli.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path, data);
                }
                logger.info("创建结束");
            } catch (Exception e) {
            }
        }

        public void addLister (String path) {
            //监听节点内容改变
            try {
                final NodeCache nodeCache = new NodeCache(zkCli, path);
                nodeCache.start();
                nodeCache.getListenable().addListener(new NodeCacheListener() {
                    @Override
                    public void nodeChanged() throws Exception {
                        logger.info("节点内容发生变化----->" + nodeCache.getCurrentData());
                    }
                });
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            }
        }

        public void test2  (byte[] data) {
            String path = "/com.roy.miscellaneous/zk";
            addLister(path);
//            create("/com.roy.miscellaneous/zk", data);

        }

        class MyCuratorWatcher implements CuratorWatcher {

            /**
             * Same as {@link Watcher#process(WatchedEvent)}. If an exception
             * is thrown, Curator will log it
             *
             * @param event the event
             * @throws Exception any exceptions to log
             */
            @Override
            public void process(WatchedEvent event) throws Exception {
                switch (event.getType()) {
                    case NodeDeleted :
                        logger.info("===========================节点被删除了！！");
                        break;
                    case NodeDataChanged:
                        logger.info("===========================节点被更新了！！");
                        break;
                    case NodeChildrenChanged:
                        logger.info("===========================节点的子节点被更新了！！");
                        break;
                    case None:
                        logger.info("===========================无！！");
                        break;
                    default:break;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution("127.0.0.1:2181", 20000, 15000);
        solution.test2("6789".getBytes(Charset.forName("utf-8")));
        System.in.read();

    }

}
